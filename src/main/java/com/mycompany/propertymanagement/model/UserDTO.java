package com.mycompany.propertymanagement.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private Long id;
    private String ownerName;

    @NotNull(message = "Owner Email is Mandatory")
    @Size(min = 1, max = 50, message = "owner email should be between 1 to 50 characters")
    private String ownerEmail;

    private String userName;

    @NotNull(message = "password can not be null")
    @NotEmpty(message = "Password can not be empty")
    private String password;

    private String phoneNbr;
}
