package x3.benjamin.playground.apiserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"x3.benjamin.playground.apiserver.controller"})
public class ServletContextConfig extends WebMvcConfigurerAdapter {
}
