package com.mycompany.propertymanagement.model;

import lombok.Data;

@Data
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;
    private Long UserId;

}
