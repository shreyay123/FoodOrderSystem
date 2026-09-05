package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Dish;
import com.example.demo.service.Service;

@Controller
public class MyController {

	@Autowired
	private Service service;
	
	@GetMapping("/ordernow")
	public String ordernow(Model model) {
	    model.addAttribute("dish", new Dish());
	    return "ordernow";
	
    }
	
	@PostMapping("/orders")
	public String afterorder(@ModelAttribute("dish") Dish dish,Model model) {
		service.order(dish);
		return "ordernow";
	}
	
	@GetMapping("/my-orders")
	public String myorders(Model model) {
		model.addAttribute("orders", service.getDishes());
		return "orders";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteorder(@PathVariable int id) {
		service.deletedish(id);
		return "redirect:/my-orders";
	}
	@GetMapping("/edit/{id}")
	public String editorder(@PathVariable int id,Model model) {
		Dish dish = service.getdishById(id);
		model.addAttribute("dish",dish);
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ("dish") Dish dish) {
		service.updatedish(dish);
		return "redirect:/my-orders";
		
	}
}

