package com.project.realtimeonlinetrackingservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="tracking-data")
public class TrackingData/ {
    @Id
    private long id;

    private String username;

    private String email;

}