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

package com.richard.website.application.service;

import com.richard.website.common.enums.UserRoleEnum;
import com.richard.website.common.enums.UserStatusEnum;
import com.richard.website.common.exception.UserDomainException;
import com.richard.website.common.utils.PasswordUtil;
import com.richard.website.domain.model.entity.UserEntity;
import com.richard.website.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {

    @Autowired
    private PasswordUtil passwordUtil;

    @Autowired
    private UserRepository userRepository; // 添加仓储接口

    public UserEntity register(UserEntity user) {
        // 领域逻辑校验
        validateUserRegistration(user);

        // 密码加密
        String password = user.getPassword();
        String encodedPassword = passwordUtil.encode(password);
        user.setPassword(encodedPassword);

        // 设置默认值
        user.setRole(UserRoleEnum.NORMAL);
        user.setStatus(UserStatusEnum.ACTIVE);

        // 设置基础字段
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        userRepository.save(user);
        return user;
    }

    public boolean authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        return user != null && passwordUtil.matches(password, user.getPassword());
    }

    private void validateUserRegistration(UserEntity user) {
        // 用户名唯一性检查
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw UserDomainException.usernameAlreadyExists(user.getUsername());
        }
    }
}
