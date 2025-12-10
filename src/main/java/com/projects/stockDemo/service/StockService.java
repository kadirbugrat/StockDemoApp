package com.projects.stockDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.stockDemo.model.Product;
import com.projects.stockDemo.model.StockItem;
import com.projects.stockDemo.repository.ProductRepository;
import com.projects.stockDemo.repository.StockItemRepository;

@Service
public class StockService {

    private final ProductRepository productRepository;
    private final StockItemRepository stockItemRepository;

    public StockService(ProductRepository productRepository, StockItemRepository stockItemRepository) {
        this.productRepository = productRepository;
        this.stockItemRepository = stockItemRepository;
    }

    public int increaseStock(Long productId, int amount) {
        // Logic to increase stock for a product

        // Fetch product by productId (Ürünü Bulduk)
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Fetch stock item by product (Ürüne Ait Stok Kalemini Bulduk Yoksa Yeni
        // Oluşturduk)
        StockItem stockItem = stockItemRepository.findByProduct(product)
                .orElseGet(() -> {

                    // If stock item doesn't exist, create a new one
                    StockItem newStockItem = new StockItem();
                    newStockItem.setProduct(product);
                    newStockItem.setQuantity(0);
                    return newStockItem;
                });

        // Increase the quantity
        stockItem.increaseQuantity(amount);

        // Save the updated stock item
        stockItemRepository.save(stockItem);

        return stockItem.getQuantity(); // Güncellenmiş Miktarı Döndürüyoruz
    }

    public int decreaseStock(Long productId, int amount) {
        // Logic to decrease stock for a product

        // Fetch product by productId (Ürünü Bulduk)
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Fetch stock item by product (Ürüne Ait Stok Kalemini Bulduk)
        StockItem stockItem = stockItemRepository.findByProduct(product)
                .orElseThrow(() -> new IllegalArgumentException("Stock item not found for the product"));

        // Decrease the quantity
        stockItem.decreaseQuantity(amount);

        // Save the updated stock item
        stockItemRepository.save(stockItem);

        return stockItem.getQuantity(); // Güncellenmiş Miktarı Döndürüyoruz
    }

    public int getStockByProductId(Long productId) {

        // Fetch product by productId (Ürünü Bulduk)
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        // Fetch stock item by product (Ürüne Ait Stok Kalemini Bulduk)
        StockItem stockItem = stockItemRepository.findByProduct(product)
                .orElseThrow(() -> new IllegalArgumentException("Stock item not found for the product"));

        return stockItem.getQuantity(); // Mevcut Stok Miktarını Döndürüyoruz
    }

    public List<StockItem> listAllProductsInStock() {
        // Logic to list all products in stock
        return stockItemRepository.findAll(); // Tüm Stok Kalemlerini Döndürüyoruz
    }

}
