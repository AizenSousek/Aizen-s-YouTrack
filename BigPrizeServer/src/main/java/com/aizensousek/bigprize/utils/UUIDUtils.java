package com.aizensousek.bigprize.utils;

import cn.hutool.core.lang.UUID;

/**
 * UUID生成工具类
 *
 * @author aizensousek
 * @since 创建于2022/6/1 17:36
 **/
public class UUIDUtils {
    /**
     * 得到字符串类型的UUID
     *
     * @return {@link String}
     */
    public static String getUUIDString() {
        return UUID.randomUUID().toString(true).replace("-","");
    }
}