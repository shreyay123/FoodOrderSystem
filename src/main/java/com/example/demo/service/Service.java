package com.example.demo.service;

import java.util.List;

import com.example.demo.Entity.Dish;

public interface Service {
	public boolean order(Dish dish);
	public List<Dish> getDishes();
	public void deletedish(int id);
	public Dish getdishById(int id);
	public void updatedish(Dish dish);
	
	
}
