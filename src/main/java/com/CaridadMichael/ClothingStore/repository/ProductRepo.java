package com.CaridadMichael.ClothingStore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.CaridadMichael.ClothingStore.model.Product;

public interface ProductRepo  extends PagingAndSortingRepository<Product, Long> {
	Page<Product> findAllByOrderByPriceAsc(PageRequest pageRequest);
	Page<Product> findAllByOrderByPriceDesc(PageRequest pageRequest);
	Page<Product> findAllByOrderByCreatedDateDesc(PageRequest pageRequest);

}
