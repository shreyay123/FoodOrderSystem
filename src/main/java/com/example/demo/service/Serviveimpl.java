package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Entity.Dish;
import com.example.demo.repository.UserRepository;

@org.springframework.stereotype.Service
public class Serviveimpl implements Service{
	@Autowired
	private UserRepository repository;
	
	public boolean order(Dish dish) {
		try {
			repository.save(dish);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Dish> getDishes(){
		List<Dish> dishes = repository.findAll();
		return dishes;
		
	}

	@Override
	public void deletedish(int id) {
		repository.deleteById(id);
	}

	@Override
	public Dish getdishById(int id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	public void updatedish(Dish dish) {
		repository.save(dish);
	}
}
