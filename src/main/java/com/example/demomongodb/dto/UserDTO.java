package com.example.demomongodb.dto;

import com.example.demomongodb.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by loliveira on 25/12/18.
 */
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
