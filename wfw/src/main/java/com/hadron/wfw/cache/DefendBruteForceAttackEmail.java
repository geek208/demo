package com.hadron.wfw.cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname DefendBruteForceAttackEmail.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */
public class DefendBruteForceAttackEmail extends RootCache<String, AtomicInteger> {
    /**
     * 最后访问后1小时过期
     * todo 验证码获取code
     */
  /*  Cache<String, AtomicInteger> cacheManager = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1, TimeUnit.HOURS).build();

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
    }*/
}
