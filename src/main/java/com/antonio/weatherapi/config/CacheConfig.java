package com.antonio.weatherapi.config;

import org.springframework.boot.cache.autoconfigure.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
public class CacheConfig {
    @Bean
    public RedisCacheManagerBuilderCustomizer  redisCacheManagerBuilderCustomizer() {
        return builder -> builder
                .withCacheConfiguration("weather",
                        RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(1)))
                .withCacheConfiguration("location",
                        RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(5)));
    }
}
