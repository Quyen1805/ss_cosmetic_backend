package com.example.springbootblogrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootblogrestapi.entity.Oder;

public interface OderRepository extends JpaRepository<Oder, Long> {

}
