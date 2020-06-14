package com.gy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue
    private long id;

    private String companyCode;
    private String companyName;
    private String ceoName;
    private int boardMember;
    private String description;
}