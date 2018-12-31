package com.example.demomongodb.dto;

import com.example.demomongodb.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 30/12/18.
 */
@Data
@NoArgsConstructor
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
