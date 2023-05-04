package com.mycompany.propertymanagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADDRESS_TABLE")
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    private String houseNbr;
    private String street;
    private String city;
    private String postalCode;
    private String country;

    @OneToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;

}
