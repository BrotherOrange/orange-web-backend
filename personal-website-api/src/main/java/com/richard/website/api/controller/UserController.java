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

import com.richard.website.api.dto.request.UserRequest;
import com.richard.website.api.dto.response.UserResponse;
import com.richard.website.api.mapstruct.request.UserReqMapper;
import com.richard.website.api.mapstruct.response.UserResMapper;
import com.richard.website.application.service.UserService;
import com.richard.website.domain.model.entity.UserEntity;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserReqMapper userReqMapper;

    @Resource
    private UserResMapper userResMapper;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid UserRequest userRequest) {
        UserEntity userEntity = userReqMapper.toUserEntity(userRequest);
        UserEntity registeredUser = userService.register(userEntity);
        return userResMapper.toUserResponse(registeredUser);
    }
}
