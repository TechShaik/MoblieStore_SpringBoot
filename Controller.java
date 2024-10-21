package com.project_files.E_cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	Services serv;
	
	@GetMapping("/")
	public String Home() {
		return "Hello Coustomer Welocme to our store..!!!!";
	}
	
	
	@PostMapping("/addp")
	public ResponseEntity< String> addp(@RequestBody Product prd) {
 	    serv.addp(prd);
	    return  new ResponseEntity<>("Product added",HttpStatus.OK) ;
	}

	
	@GetMapping("/pbyid/{prd}")
	public ResponseEntity<Product> showpbyid(@PathVariable int prd){
		return new ResponseEntity<>( serv.showbyid(prd),HttpStatus.ACCEPTED);
	}
	@GetMapping("/showp")
	public ResponseEntity<List<Product>> showp(Product prd) {
		return new ResponseEntity<>(serv.showp(prd),HttpStatus.OK);
	}
	
	@GetMapping("/showonly")
	public List<ProductResponseDto> showonly(Product prd) {
		return serv.showonly(prd);
	
	}
	@PutMapping("/update")
	public ResponseEntity<ProductResponseDto> updateProduct(@RequestParam int id, @RequestBody ProductResponseDto productDto) {
		ProductResponseDto updatedProduct = serv.update(id, productDto);
	    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
	}



}
