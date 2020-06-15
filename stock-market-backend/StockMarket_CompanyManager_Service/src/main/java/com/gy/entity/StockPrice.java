package com.gy.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="STOCK_PRICE")
@Data
@ToString(exclude = {"company"})
public class StockPrice {

    @Id
    @GeneratedValue
    private Long id;

    private double currentPrice;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
}
