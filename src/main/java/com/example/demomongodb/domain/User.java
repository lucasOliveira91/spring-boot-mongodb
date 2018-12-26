package com.example.demomongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by loliveira on 25/12/18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection = "user")
@Document
public class User {

    @Id
    private String id;
    private String name;
    private String email;
}
