package cn.ocoop.framework.mybank;

import com.wxmlabs.aurora.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import static cn.ocoop.framework.mybank.MybankProperties.ConfiguredKeyStore;

@Slf4j
public class TCACompatibleSignatureService {
    public static SignatureService getInstance(ConfiguredKeyStore keyStore) {
        MemorySignatureService signatureService = new MemorySignatureService();

        String name = "default";
        String type = keyStore.getType();
        String keyStorePath = keyStore.getPath();
        char[] password = keyStore.getPassword().toCharArray();

        try {
            KeyStore ks = KeyStore.getInstance(type);
            ks.load(TCACompatibleSignatureService.class.getClassLoader().getResourceAsStream(keyStorePath), password);
            Enumeration<String> aliases = ks.aliases();
            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                if (ks.isKeyEntry(alias)) {
                    PrivateKey signerKey = (PrivateKey) ks.getKey(alias, password);
                    X509Certificate signerCert = (X509Certificate) ks.getCertificate(alias);
                    DigestAlgorithm defaultDigestAlg = SignatureAlgorithmNameGenerator.getDefaultDigestAlg(signerKey);
                    signatureService.addSigner(name + "_" + alias, new SimpleCMSSigner(signerKey, signerCert, defaultDigestAlg, true));
                    signatureService.addCMSVerifier(name + "_" + alias, signerCert);
                }
            }
        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException | UnrecoverableKeyException e) {
            log.error("keystore 异常", e);
        }

        return signatureService;
    }
}
