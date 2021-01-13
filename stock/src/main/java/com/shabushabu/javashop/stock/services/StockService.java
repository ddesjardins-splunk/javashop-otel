package com.shabushabu.javashop.stock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shabushabu.javashop.stock.exceptions.StockNotFoundException;
import com.shabushabu.javashop.stock.model.Stock;
import com.shabushabu.javashop.stock.repositories.StockRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StockService {

    private StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getStocks() {
        return StreamSupport.stream(stockRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Stock getStock(String productId) throws StockNotFoundException {
        return stockRepository.findById(productId)
                .orElseThrow(() -> new StockNotFoundException("Stock not found with productId: " + productId));
    }
}
