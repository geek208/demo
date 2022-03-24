package com.hadron.wfw;


import org.dozer.Mapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 
 * @author xuychao
 * @date 2022年3月15日
 * @classname Dozer.java
 * @email xuychao@163.com  git@github.com:geek208/wfw.git
 */

@Component
public class Dozer {
    /**
     * dozer转换的核心mapper对象
     */
    public static final Mapper dozerMapper = new org.dozer.DozerBeanMapper();
    /**
     * 转换实体为另一个指定的实体
     * 任意一个参数为NULL时 会抛出NPE
     *
     * @param source 源实体 不能为NULL
     * @param clazz 目标实体 不能为NULL
     * @param <T> 泛型
     * @return 转换后的结果
     */
    @NonNull
    public static <T> T convert(@NonNull Object source, @NonNull Class<T> clazz) {
        return  dozerMapper.map(source, clazz);
    }
    /**
     * 转换List实体为另一个指定的实体
     * source如果为NULL 会使用空集合
     * 在目标实体为NULL时 会抛出NPE
     *
     * @param source 源集合 可以为NULL
     * @param clazz 目标实体 不能为NULL
     * @param <T> 泛型
     * @return 转换后的结果
     */
    @Nullable
    public static <T> List<T> convert(@Nullable List<?> source, @NonNull Class<T> clazz) {
        return Optional.ofNullable(source)
                .orElse(Collections.emptyList())
                .stream()
                .map(bean -> dozerMapper.map(bean, clazz))
                .collect(Collectors.toList());
    }
}
