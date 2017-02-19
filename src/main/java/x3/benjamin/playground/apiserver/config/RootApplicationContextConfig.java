package x3.benjamin.playground.apiserver.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import x3.benjamin.playground.apiserver.utils.MessageBundleUtil;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@ComponentScan(basePackages = {
        "x3.benjamin.playground.apiserver"
})
public class RootApplicationContextConfig {

    @Bean(name = "system")
    public PropertiesFactoryBean propertiesFactoryBean() throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("/properties/system.properties"));
        bean.afterPropertiesSet();
        return bean;
    }

    @Bean
    public MessageBundleUtil messageBundleUtil() throws Exception {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");
        source.setBasename("META-INF/message/message");

        MessageSourceAccessor accessor = new MessageSourceAccessor(source);

        MessageBundleUtil util = new MessageBundleUtil();
        util.setMessageSourceAccessor(accessor);
        return util;
    }
}
