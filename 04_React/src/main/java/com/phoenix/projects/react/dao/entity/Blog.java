package com.phoenix.projects.react.dao.entity;

import com.phoenix.projects.react.dao.entity.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "blog")
public class Blog extends BaseEntity {


    @TextIndexed
    private String title;

    private String content;

    @Indexed
    private String author;


    public Blog(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
