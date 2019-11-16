package com.peter.kist.model.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private String passwordConfirm;

}
