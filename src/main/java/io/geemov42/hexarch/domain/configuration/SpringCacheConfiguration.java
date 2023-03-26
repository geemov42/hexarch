package io.geemov42.hexarch.domain.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class SpringCacheConfiguration {

    public static final String CUSTOM_CACHE_NAME = "CUSTOM_CACHE_NAME";
}
