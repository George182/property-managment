package com.mycompany.propertymanagement.model;


import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {

    private String ownerName;

    private String ownerEmail;

    private String userName;

    private String password;

    private String phoneNbr;
}
