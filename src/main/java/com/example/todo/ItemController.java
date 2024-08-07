package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/todolist")
public class ItemController {
    @Autowired ItemService itemService;

    @GetMapping("/")
    public List<Item> getAll() {
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return itemService.removeItem(id);
    }
}
