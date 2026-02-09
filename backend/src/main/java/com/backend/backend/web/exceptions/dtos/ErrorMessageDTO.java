package com.backend.backend.web.exceptions.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private int status;
    private String error;
    private String message;
    private String path;
}
