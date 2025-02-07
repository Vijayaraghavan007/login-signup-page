package com.example.demo;

import org.springframework.data.repository.CrudRepository;




public interface agent extends CrudRepository<getset, Integer> {
	getset findByEmail(String email);;
}
