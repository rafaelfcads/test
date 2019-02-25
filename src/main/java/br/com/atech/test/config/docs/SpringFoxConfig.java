package br.com.atech.test.config.docs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo());
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Flights List",
                "API to list the flights",
                "v1.0.0",
                null,
                null,
                null,
                null,
                Collections.emptyList()
        );
    }
}
