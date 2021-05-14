package com.itemsharing.itemservice.controllers;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        String username = "jadams";
        return itemService.addItemByUser(item, username);
    }

    @GetMapping("/itemsByUser")
    public List<Item> getAllItemsByUser() {
        String username = "jadams";
        return itemService.getItemsByUsername(username);
    }

    @GetMapping("/all")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item) throws IOException {
        item.setId(id);
        return itemService.updateItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id){
        itemService.deleteItemById(id);
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username){
        return itemService.getUserByUsername(username);
    }
}
