package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired ItemRepository itemRepository;
    //    CRUD OPERATION
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public String createItem(Item newItem) {
        itemRepository.save(newItem);
        return "Item created successfully";
    }

    public String removeItem(int id) {
        Item existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem != null) {
            itemRepository.deleteById(id);
            return "removed";
        }else{
            return "not-removed";
        }
    }

    // logic to update the item
    public String updateItem(Item item) {
        Item existingItem = itemRepository.findById(item.getId()).orElse(null);
        if (existingItem == null) {
            return "updated";
        }else{
            existingItem.setId(item.getId());
            existingItem.setName(item.getName());
            existingItem.setCategory(item.getCategory());
            existingItem.setNote(item.getNote());
            itemRepository.save(existingItem);
            return "notupdated";
        }
    }
}
