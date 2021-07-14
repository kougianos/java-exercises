package com.javaexercices.kougianos.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.util.Assert;

import java.util.Properties;

/**
 * This class is created in order to be able to parse a map from a YAML file.
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());

        Properties properties = factory.getObject();

        Assert.notNull(encodedResource.getResource().getFilename(), "filename is null");
        Assert.notNull(properties, "properties is null");

        return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
    }
}
