package com.dakr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_TBL")
public class Contact {

    @Id
    private Integer id;
    private String name;
    private String email;
    private Long phno;
}
