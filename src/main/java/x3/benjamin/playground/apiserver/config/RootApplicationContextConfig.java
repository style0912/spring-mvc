package x3.benjamin.playground.apiserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@ComponentScan(basePackages = {
        "x3.benjamin.playground.apiserver.repository",
        "x3.benjamin.playground.apiserver.service"
})
public class RootApplicationContextConfig {
}
