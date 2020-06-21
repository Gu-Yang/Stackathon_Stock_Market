package com.gy.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
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
    private boolean isActive;

    @JsonManagedReference
    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER)
    private Set<StockPrice> stockPriceSet;
}