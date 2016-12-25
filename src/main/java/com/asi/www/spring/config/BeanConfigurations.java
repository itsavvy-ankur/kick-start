package com.asi.www.spring.config;

import com.asi.www.netty.processor.XMLProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ankur on 25-12-2016.
 */
@Configuration
public class BeanConfigurations {

    @Bean
    public XMLProcessor nettyXmlProcessor() {
        return new XMLProcessor();
    }
}
