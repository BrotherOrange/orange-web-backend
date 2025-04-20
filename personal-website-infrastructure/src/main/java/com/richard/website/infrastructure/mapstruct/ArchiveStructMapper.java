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

package com.richard.website.infrastructure.mapstruct;

import com.richard.website.domain.model.entity.ArchiveEntity;
import com.richard.website.infrastructure.po.ArchivePo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 归档持久化实体与归档信息实体映射转换类
 *
 * @Author Richard Zhang
 * @Email richard.jih.zhang@gmail.com
 * @Date 2025-04-20 22:47
 */
@Mapper(componentModel = "spring")
public interface ArchiveStructMapper {
    ArchiveStructMapper INSTANCE = Mappers.getMapper(ArchiveStructMapper.class);

    ArchivePo toArchivePo(ArchiveEntity archiveEntity);
    ArchiveEntity toArchiveEntity(ArchivePo archivePo);
}
