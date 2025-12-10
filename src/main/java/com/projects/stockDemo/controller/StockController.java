package com.projects.stockDemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.stockDemo.model.StockItem;
import com.projects.stockDemo.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/increase")
    public ResponseEntity<Integer> increase(@RequestParam Long productId,
            @RequestParam int amount) {
        int newQuantity = stockService.increaseStock(productId, amount);
        return ResponseEntity.ok(newQuantity);
    }

    @PostMapping("/decrease")
    public ResponseEntity<Integer> decrease(@RequestParam Long productId,
            @RequestParam int amount) {
        int newQuantity = stockService.decreaseStock(productId, amount);
        return ResponseEntity.ok(newQuantity);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Integer> getForProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(stockService.getStockByProductId(productId));
    }

    @GetMapping
    public ResponseEntity<List<StockItem>> getAll() {
        return ResponseEntity.ok(stockService.listAllProductsInStock());
    }

}
