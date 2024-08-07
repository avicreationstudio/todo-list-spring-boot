package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/view/todolist")
public class ItemViewController {
    @Autowired ItemService itemService;

    //    crud post man call
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "My Todo List Application");
        model.addAttribute("input", "Enter your new item value below");
        model.addAttribute("items", itemService.getAllItems());
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(@RequestParam String name, @RequestParam String category, @RequestParam String note, Model model) {
        Item newItem = new Item();
        newItem.setName(name);
        newItem.setCategory(category);
        newItem.setNote(note);
        itemService.createItem(newItem);
        model.addAttribute("items", itemService.getAllItems());
        return "redirect:/view/todolist/index";
    }

}
