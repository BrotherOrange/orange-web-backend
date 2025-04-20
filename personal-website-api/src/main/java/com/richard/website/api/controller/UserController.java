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

package com.richard.website.api.controller;

import com.richard.website.api.dto.request.UserQueryRequest;
import com.richard.website.api.dto.request.UserRegisterRequest;
import com.richard.website.api.dto.response.UserResponse;
import com.richard.website.api.mapstruct.request.UserReqMapper;
import com.richard.website.api.mapstruct.response.UserResMapper;
import com.richard.website.application.service.impl.UserServiceImpl;
import com.richard.website.domain.model.entity.UserEntity;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户Controller
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserReqMapper userReqMapper;

    @Resource
    private UserResMapper userResMapper;

    /**
     * 注册新用户
     */
    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRegisterRequest userRegisterRequest) {
        UserEntity userEntity = userReqMapper.toUserEntity(userRegisterRequest);
        UserEntity registeredUser = userService.register(userEntity);
        return userResMapper.toUserResponse(registeredUser);
    }

    /**
     * 通过ID查询具体用户信息
     */
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable @Positive Long id) {
        UserEntity userEntity = userService.getUserById(id);
        return userResMapper.toUserResponse(userEntity);
    }

    /**
     * 通过属性集合查询用户信息
     */
    @GetMapping
    public List<UserResponse> queryUsers(@Valid UserQueryRequest userQueryRequest) {
        UserEntity userEntity = userReqMapper.toUserEntity(userQueryRequest);
        List<UserEntity> users = userService.getUserByAttributes(userEntity);
        return users.stream()
                .map(userResMapper::toUserResponse)
                .collect(Collectors.toList());
    }
}
