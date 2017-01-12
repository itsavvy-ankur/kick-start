package com.asi.www;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ManagementStrategy;
import org.apache.camel.spi.RestConfiguration;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Ankur on 17-12-2016.
 */
@SpringBootApplication
@Configuration
public class AppLauncher extends FatJarRouter{

public static void main(String... args){
    SpringApplication.run(AppLauncher.class,args);

}



    @Bean
    CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {

            public void beforeApplicationStart(CamelContext context)  {

                RestConfiguration restConfiguration = new RestConfiguration();
                restConfiguration.setComponent("jetty");
                restConfiguration.setBindingMode(RestConfiguration.RestBindingMode.json);
                restConfiguration.setPort(9886);
                restConfiguration.setHost("0.0.0.0");
                restConfiguration.setContextPath("/asi/api/v1_0");
                context.setRestConfiguration(restConfiguration);
                try {
                    ClassLoader classLoader = AppLauncher.class.getClassLoader();
                    URI uri = classLoader.getResource("ehcache.xml").toURI();
                    CachingProvider cachingProvider = Caching.getCachingProvider();
                    CacheManager cm = ((CachingProvider) cachingProvider).getCacheManager(uri, classLoader);

                }catch (URISyntaxException e){

                }
            }

            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }
}
