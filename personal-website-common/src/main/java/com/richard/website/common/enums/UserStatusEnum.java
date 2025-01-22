package com.richard.website.common.enums;

import lombok.Getter;

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
