package com.itemsharing.itemservice.bootstrap;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.services.ItemService;
import com.itemsharing.itemservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final ItemService itemService;
    private final UserService userService;

    public DataLoader(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadItems();
    }

    private void loadItems() {
        User user = userService.getUserByUsername("jadams");

        Item item1 = new Item();
        item1.setName("Item1");
        item1.setItemCondition("New");
        item1.setStatus("Active");
        item1.setAddDate(LocalDate.now());
        item1.setDescription("This is an item description.");
        item1.setUser(user);

        itemService.addItemByUser(item1, user.getUsername());

        Item item2 = new Item();
        item2.setName("Item2");
        item2.setItemCondition("Used");
        item2.setStatus("Inactive");
        item2.setAddDate(LocalDate.now());
        item2.setDescription("This is an item description for item2.");
        item2.setUser(user);

        itemService.addItemByUser(item2, user.getUsername());
    }
}
