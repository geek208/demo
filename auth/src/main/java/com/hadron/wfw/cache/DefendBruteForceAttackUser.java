package com.hadron.wfw.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname DefendBruteForceAttackUser.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
@Component
public class DefendBruteForceAttackUser extends RootCache<String, AtomicInteger> {
    /**
     * 最后访问后1小时过期
     */
    Cache<String, AtomicInteger> cacheManager = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1, TimeUnit.HOURS).build();

    @Override
    public AtomicInteger getCache(String key) {
        if (key == null) return null;
        return cacheManager.getIfPresent(key);
    }

    @Override
    public void setCache(String key, AtomicInteger value) {
        cacheManager.put(key, value);
    }


    @Override
    public void rmCache(String key) {
        cacheManager.invalidate(key);
    }

    @Override
    public boolean containKey(String key) {
        return getCache(key) != null;
    }
}
