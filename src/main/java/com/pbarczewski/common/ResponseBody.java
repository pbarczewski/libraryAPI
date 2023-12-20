package com.pbarczewski.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseBody {
    private String message;
    private String messageEn;
    private HttpStatus httpStatus;
}
