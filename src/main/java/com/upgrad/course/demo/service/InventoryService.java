package com.upgrad.course.demo.service;

import com.upgrad.course.demo.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

public interface InventoryService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProduct(int productId);

    List<ProductDTO> getAllProducts();
}
