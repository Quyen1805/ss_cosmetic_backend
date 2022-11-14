package com.example.springbootblogrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootblogrestapi.entity.Oder;
import com.example.springbootblogrestapi.repository.OderRepository;

@RestController
@RequestMapping("/api/auth")
public class OderController {
	
	@Autowired
    private OderRepository oderRepository;
	
	@GetMapping("/oders")
    public List<Oder> getAllUsers() {
        return oderRepository.findAll();
    }

}
