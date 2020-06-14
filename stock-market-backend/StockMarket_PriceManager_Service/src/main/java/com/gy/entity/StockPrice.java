package com.gy.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="STOCK_PRICE")
@Data
public class StockPrice {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;
    private String mobile;
}
