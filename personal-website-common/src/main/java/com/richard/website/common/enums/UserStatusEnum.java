package com.richard.website.common.enums;

import lombok.Getter;

/**
 * 用户状态枚举类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:43
 */
@Getter
public enum UserStatusEnum {
    ACTIVE("正常"),
    INACTIVE("已冻结"),
    DELETED("已删除");

    private final String content;

    UserStatusEnum(String content) {
        this.content = content;
    }
}
