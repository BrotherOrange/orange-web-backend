package com.richard.website.common.enums;

import lombok.Getter;

/**
 * 用户角色枚举类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:43
 */
@Getter
public enum UserRoleEnum {
    OWNER("主人"),
    ADMIN("管理员"),
    NORMAL("普通用户");

    private final String content;

    UserRoleEnum(String content) {
        this.content = content;
    }
}