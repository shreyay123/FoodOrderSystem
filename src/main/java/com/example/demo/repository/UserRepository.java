package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Dish;

@Repository
public interface UserRepository extends JpaRepository<Dish, Integer>{

}
