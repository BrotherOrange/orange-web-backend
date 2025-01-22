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

import java.util.List;

/**
 * 文章实体类
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
public class ArticleEntity extends BaseEntity {

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String abstractContent;

    /**
     * 内容
     */
    private String content;

    /**
     * 作者
     */
    private Long authorId;

    /**
     * 收藏数
     */
    private Integer likeCount;

    /**
     * 浏览数
     */
    private Integer viewCount;

    /**
     * 点赞数
     */
    private Integer thumbUpCount;

    /**
     * 点踩数
     */
    private Integer thumbDownCount;

    /**
     * 评论
     */
    private List<Long> commentIds;

    /**
     * 标签
     */
    private List<Long> tagIds;

    /**
     * 分类
     */
    private List<Long> archiveIds;
}
