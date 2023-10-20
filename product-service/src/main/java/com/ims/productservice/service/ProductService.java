package com.ims.productservice.service;

import com.ims.productservice.model.ProductRequest;
import com.ims.productservice.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void reduceQuantity(long productId, long quantity);

	ProductResponse updateProduct(long productId, ProductRequest productRequest);

}
