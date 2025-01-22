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

package com.richard.website.domain.model.entity;

import com.richard.website.domain.model.entity.base.BaseEntity;
import lombok.*;

/**
 * 归档实体类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-01-21 22:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveEntity extends BaseEntity {

    /**
     * 归档名称
     */
    private String title;

    /**
     * 描述
     */
    private String description;
}
