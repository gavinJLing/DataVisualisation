package co.uk.lingzone.datasource.perlin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.uk.lingzone.datasource.perlin.service.Data3DService;

@Configuration
public class Config {
    
       
    
    @Bean
    public Data3DService data3DService() {
        return new Data3DService();
    }
    
   
    
}

