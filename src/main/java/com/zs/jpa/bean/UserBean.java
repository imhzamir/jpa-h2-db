package com.zs.jpa.bean;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserBean {

    @NotBlank
    private String name;
    private String address;

}
