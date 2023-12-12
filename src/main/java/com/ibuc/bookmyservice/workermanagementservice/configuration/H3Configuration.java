package com.ibuc.bookmyservice.workermanagementservice.configuration;

import com.uber.h3core.H3Core;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class H3Configuration {

    @Bean
    public H3Core H3core() throws IOException {
        return H3Core.newInstance();
    }
}
