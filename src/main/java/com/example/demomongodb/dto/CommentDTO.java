package com.example.demomongodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by loliveira on 30/12/18.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String text;
    private Date date;
    private AuthorDTO author;
}
