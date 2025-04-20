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

package com.richard.website.infrastructure.repository;

import com.richard.website.domain.model.entity.UserEntity;
import com.richard.website.domain.repository.UserRepository;
import com.richard.website.infrastructure.dao.UserDAO;
import com.richard.website.infrastructure.mapstruct.UserStructMapper;
import com.richard.website.infrastructure.po.UserPo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户数据存储实现类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:47
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private UserDAO userDAO;
    @Resource
    private UserStructMapper userStructMapper;

    @Override
    public void save(UserEntity user) {
        userDAO.insert(userStructMapper.toUserPo(user));
    }

    @Override
    public UserEntity findById(Long id) {
        UserPo userPO = userDAO.findById(id);
        return userStructMapper.toUserEntity(userPO);
    }

    @Override
    public UserEntity findByUsername(String username) {
        UserPo userPO = userDAO.findByUsername(username);
        return userStructMapper.toUserEntity(userPO);
    }

    @Override
    public List<UserEntity> findByAttributes(UserEntity user) {
        List<UserPo> userPos = userDAO.findByAttributes(user);
        return userPos.stream()
                .map(userStructMapper::toUserEntity)
                .collect(Collectors.toList());
    }
}
