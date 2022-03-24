package com.hadron.wfw.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname EmailVCache.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Component
public class EmailVCache extends RootCache {
    //10分钟过期
    Cache<Object, Object> cacheManager = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES).build();
    @Override
    public Object getCache(Object key) {


        return cacheManager.getIfPresent(key);
    }

    @Override
    public void setCache(Object key, Object value) {
        cacheManager.put(key, value);
    }


    @Override
    public void rmCache(Object key) {
         cacheManager.
                 invalidate(key);
    }
}
