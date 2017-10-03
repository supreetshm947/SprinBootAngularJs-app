package com.example.fullstackangular.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.example.fullstackangular.converter.RoomEntityToReservationResponseCoverter;

@Configuration
public class ConversionConfig {
	public Set<Converter> getConverters(){
		Set<Converter> converters = new HashSet<>();
		converters.add((Converter)new RoomEntityToReservationResponseCoverter());
		return converters;
	}
	
	@Bean
	public ConversionService conversionService() {
		ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
		bean.setConverters(getConverters());
		bean.afterPropertiesSet();
		
		return bean.getObject();
	}
	
}
