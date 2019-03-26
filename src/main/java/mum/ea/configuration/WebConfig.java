package mum.ea.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"mum.ea.controller",
        "mum.ea.serviceImpl",
        "mum.ea.service",
        "mum.ea.dao",
        "mum.ea.daoImpl",
        "mum.ea.dao.abstracts",
        "mum.ea.logger"})
public class WebConfig extends WebMvcConfigurerAdapter {

    public WebConfig() {
    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//
//        //converters.add(new MappingJackson2XmlHttpMessageConverter());
//        converters.add(new MappingJackson2HttpMessageConverter());
//        super.configureMessageConverters(converters);
//
//    }

}
