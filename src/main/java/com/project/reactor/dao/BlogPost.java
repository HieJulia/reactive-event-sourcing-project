package com.project.reactor.dao;


import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Table
public class BlogPost {
    @PrimaryKey
    @NonNull
    UUID id;
    @NonNull
    String title;
    @NonNull
    String author;
    @NonNull
    String body;
}