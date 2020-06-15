package com.gy.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "COMPANY")
@ToString(exclude = {"stockPriceSet"})
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String companyCode;

    private String companyName;
    private String ceoName;
    private int boardMember;
    private String description;

    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER)
    private Set<StockPrice> stockPriceSet;
}