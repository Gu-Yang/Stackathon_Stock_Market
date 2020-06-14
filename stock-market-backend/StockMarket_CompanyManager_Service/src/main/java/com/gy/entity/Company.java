package com.gy.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(mappedBy = "company", cascade=CascadeType.ALL)
    private Set<StockPrice> stockPriceSet;
}