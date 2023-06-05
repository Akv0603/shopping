package com.akv.shopping.controller;

import com.akv.shopping.entity.ShoppingItem;
import com.akv.shopping.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShoppingController {
    private final ShoppingItemRepository repository;

    @Autowired
    public ShoppingController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    //показать начальную страницу. html не указываем. в thymeleaf он дефолтный
    @GetMapping
    public String frontPage(Model model){
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newItem(ShoppingItem item){
        repository.save(item);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return "redirect:/";
    }
}
