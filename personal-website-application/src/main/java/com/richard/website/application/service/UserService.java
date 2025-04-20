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

import com.richard.website.domain.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 注册新用户
     */
    UserEntity register(UserEntity user);

    /**
     * 通过ID查询用户信息
     */
    UserEntity getUserById(Long id);

    /**
     * 通过属性集合查询用户信息
     */
    List<UserEntity> getUserByAttributes(UserEntity user);


}
