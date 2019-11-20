package com.nutritech.nu34life.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/prueba")
public class PruebaController {
	@GetMapping(path="/{password}")
	String prueba1(@PathVariable String password) {
		return password + "FUNCIONA";
	}
}
