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

package com.richard.website.domain.repository;

import com.richard.website.domain.model.entity.UserEntity;

import java.util.List;

/**
 * 用户数据存储接口类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:46
 */
public interface UserRepository {

    /**
     * 保存新用户
     */
    void save(UserEntity user);

    /**
     * 通过用户ID查询用户
     */
    UserEntity findById(Long id);

    /**
     * 通过用户名查询用户
     */
    UserEntity findByUsername(String username);

    /**
     * 通过用户信息查询用户集合
     */
    List<UserEntity> findByAttributes(UserEntity user);
}
