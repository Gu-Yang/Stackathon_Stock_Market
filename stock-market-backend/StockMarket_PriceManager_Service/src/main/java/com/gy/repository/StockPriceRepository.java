package com.gy.repository;

import com.gy.entity.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
