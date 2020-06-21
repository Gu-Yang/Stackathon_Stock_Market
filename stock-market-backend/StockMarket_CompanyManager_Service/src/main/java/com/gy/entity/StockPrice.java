package com.gy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="STOCK_PRICE")
@Getter
@Setter
@ToString(exclude = {"company"})
public class StockPrice {

    @Id
    @GeneratedValue
    private Long id;

    private double currentPrice;
    private LocalDateTime timestamp;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="company_id")
    private Company company;
}
