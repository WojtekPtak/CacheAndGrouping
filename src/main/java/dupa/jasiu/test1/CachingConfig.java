package dupa.jasiu.test1;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CachingConfig {

    CachingConfig() {
        System.out.println("CachingConfig contructor");
    }

    @Bean
    public CacheManager cacheManager() {
        System.out.println("CacheManager created");;
        return new ConcurrentMapCacheManager("kesz1");
    }
}
