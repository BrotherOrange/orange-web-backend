package com.richard.website.common.enums;

import lombok.Getter;

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