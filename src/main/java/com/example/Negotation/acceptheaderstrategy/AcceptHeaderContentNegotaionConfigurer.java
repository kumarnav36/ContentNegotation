
package com.example.Negotation.acceptheaderstrategy;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnProperty(value = "content.negotationType", havingValue = "ACCEPTHEADER")
public class AcceptHeaderContentNegotaionConfigurer implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .ignoreAcceptHeader(false)
                .mediaType("/xml", MediaType.APPLICATION_XML)
                .mediaType("/json", MediaType.APPLICATION_JSON)
                .defaultContentType(MediaType.APPLICATION_XML)
                .useJaf(false);
    }
}

