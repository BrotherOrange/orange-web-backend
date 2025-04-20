/*
 * Copyright (c) 2024 Richard Zhang (richard.jih.zhang@gmail.com).
 * Website: https://zhang-jihao.com
 * All rights reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.richard.website.common.exception;

import com.richard.website.common.exception.base.DomainException;

/**
 * 用户数据层异常封装类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:43
 */
public class UserDomainException extends DomainException {

    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
    public static final String USERNAME_ALREADY_EXISTS = "USERNAME_ALREADY_EXISTS";
    public static final String INVALID_PASSWORD = "INVALID_PASSWORD";

    public UserDomainException(String code, String message) {
        super(code, message);
    }

    /**
     * 用户查询失败
     */
    public static UserDomainException userNotFound(String username) {
        return new UserDomainException(USER_NOT_FOUND,
                String.format("User not found with username: %s", username));
    }

    /**
     * 用户名已存在
     */
    public static UserDomainException usernameAlreadyExists(String username) {
        return new UserDomainException(USERNAME_ALREADY_EXISTS,
                String.format("Username already exists: %s", username));
    }

    /**
     * 密码不合法
     */
    public static UserDomainException invalidPassword() {
        return new UserDomainException(INVALID_PASSWORD, "Invalid password");
    }
}
