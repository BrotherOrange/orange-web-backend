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

package com.richard.website.infrastructure.dao;

import com.richard.website.domain.model.entity.UserEntity;
import com.richard.website.infrastructure.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户数据库操作接口
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:46
 */
@Mapper
public interface UserDAO {
    /**
     * 插入新用户
     */
    void insert(UserPo userPo);

    /**
     * 通过用户ID查询用户
     */
    UserPo findById(Long id);

    /**
     * 通过用户名查询用户
     */
    UserPo findByUsername(String username);

    /**
     * 通过用户信息查询用户集合
     */
    List<UserPo> findByAttributes(UserEntity queryRequest);
}
