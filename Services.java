package com.project_files.E_cart;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {
    
	@Autowired
	Mapper map; 
	
	@Autowired
	Repository rep;
	
	public String addp(Product prd) {
		 System.out.println(prd); 
		rep.save(prd);
		return "Product added";
	}
	
	public List<Product> showp(Product prd){
		return rep.findAll();
	}

	public Product showbyid(int prd) {
		return rep.findById(prd).get();
		 
	}
	
	public ProductResponseDto update(int id, ProductResponseDto prt) {
	    Optional<Product> prdOptional = rep.findById(id);
	    if (prdOptional.isPresent()) {
	        Product prd = prdOptional.get();
	        prd.setName(prt.getName());
	        prd.setModel(prt.getModel());
	        prd.setPrice(prt.getPrice());
	         rep.save(prd);
	    } else {
	        throw new RuntimeException("Product not found for ID: " + id);
	    }
		return null;
	}

	
	public List<ProductResponseDto> showonly(Product prd) {
	 
		List<Product> prd1=rep.findAll();
          if(!prd1.isEmpty()) {
        	    return prd1.stream().map(Mapper::mapToDto).collect(Collectors.toList());
          }
		return null;
	}
}
