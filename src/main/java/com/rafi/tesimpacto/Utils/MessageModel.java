package com.rafi.tesimpacto.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageModel {

    private String message;
    private boolean status;
    private Object data;
}
