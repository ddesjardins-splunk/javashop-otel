package com.shabushabu.javashop.stock.repositories;

import org.springframework.data.repository.CrudRepository;
import com.shabushabu.javashop.stock.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
}
