package br.com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableAutoConfiguration
@EnableSwagger
@ComponentScan(basePackages = {"br.com.erudio"})
public class Application {
    
    @Autowired
    private SpringSwaggerConfig swaggerConfig;
    
    public static void main(String[] args) {
           new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
    
    @Bean
    public SwaggerSpringMvcPlugin groupOnePlugin() {
       return new SwaggerSpringMvcPlugin(swaggerConfig)
           .apiInfo(apiInfo())
           .includePatterns("/cliente.*?", "/greeting.*?")
           .swaggerGroup("admin");
    }
    
    private ApiInfo apiInfo() {
       ApiInfo apiInfo = new ApiInfo(
             "Swagger com Spring Boot",
             "Este projeto demonstra como trablhar com swagger dentro do Spring boot !!",
             "Livre para usar",
             "fabiano.freitas@gmail.com",
             "Versao 1.0",
             "fabiano.freitas@gmail.com"
       );
       return apiInfo;
    }
}
