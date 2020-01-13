package cn.ocoop.framework.mybank;

import cn.ocoop.framework.common.spring.SimplifiedAnnotationBeanNameGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableConfigurationProperties({MybankProperties.class})
@ComponentScan(basePackageClasses = MybankAutoConfiguration.class, nameGenerator = SimplifiedAnnotationBeanNameGenerator.class)
public class MybankAutoConfiguration implements ApplicationContextAware {
    public static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MybankAutoConfiguration.ctx = applicationContext;
    }
}
