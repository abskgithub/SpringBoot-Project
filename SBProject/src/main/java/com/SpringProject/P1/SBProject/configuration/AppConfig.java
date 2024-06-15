package com.SpringProject.P1.SBProject.configuration;


import com.SpringProject.P1.SBProject.DB;
import com.SpringProject.P1.SBProject.DevDB;
import com.SpringProject.P1.SBProject.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty (name = "project.mode" , havingValue = "production")
    public DB getProdDBBean(){
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty (name = "project.mode" , havingValue = "development")
    public DB DevDBBean(){
        return new DevDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

}
