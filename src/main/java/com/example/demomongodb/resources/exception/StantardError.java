package com.example.demomongodb.resources.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by loliveira on 25/12/18.
 */
@NoArgsConstructor
@AllArgsConstructor
public class StantardError {

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
