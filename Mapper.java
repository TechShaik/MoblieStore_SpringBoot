package com.project_files.E_cart;

import org.springframework.stereotype.Component;

@Component
public class Mapper {
	
	public static ProductResponseDto mapToDto(Product prd) {
		ProductResponseDto pdto=new ProductResponseDto();
		pdto.setId(prd.getId());
		pdto.setName(prd.getName());
		pdto.setModel(prd.getModel());
		pdto.setPrice(prd.getPrice());
		return pdto;
	}

}
