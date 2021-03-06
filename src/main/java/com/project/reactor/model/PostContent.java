package com.project.reactor.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.Wither;

@Value
@Builder
@Wither
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class PostContent {

    @NonNull
    String title;

    @NonNull
    String author;

    @NonNull
    String body;
}

