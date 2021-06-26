package com.javaexercices.kougianos.config;

import com.javaexercices.kougianos.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

    @Bean(name = "bankMarshaller")
    public Jaxb2Marshaller bankMarshaller()  {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.javaexercices.kougianos.dto.bank");
        return marshaller;
    }
    @Bean
    public BankService bankService(@Autowired @Qualifier("bankMarshaller") Jaxb2Marshaller marshaller) {
        BankService client = new BankService();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
