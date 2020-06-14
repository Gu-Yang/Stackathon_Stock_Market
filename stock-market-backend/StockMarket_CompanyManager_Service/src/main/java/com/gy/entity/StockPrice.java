package com.gy.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="STOCK_PRICE")
@Data
public class StockPrice {

    @Id
    @GeneratedValue
    private Long id;

    private double currentPrice;
    private Timestamp timestamp;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="company_code")
    private Company company;
}
