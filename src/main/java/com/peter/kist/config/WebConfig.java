package com.peter.kist.config;


import com.peter.kist.model.converter.EnumFromStringConverterFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${date.pattern}")
    private String datePattern;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setPattern(datePattern);
        registry.addFormatter(dateFormatter);

        registry.addConverterFactory(new EnumFromStringConverterFactory());
    }

}
