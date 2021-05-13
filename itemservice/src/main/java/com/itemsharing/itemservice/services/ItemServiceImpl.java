package com.itemsharing.itemservice.services;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.repositories.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserService userService;

    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    @Override
    public Item addItemByUser(Item item, String username) {
        Item localItem=itemRepository.findItemByName(item.getName());

        if(localItem!=null){
            log.info("Item with this name {} already exists!.Nothing will be done",item.getName());
            return null;
        }else{
            LocalDate today=LocalDate.now();
            item.setAddDate(today);

            User user=userService.getUserByUsername(username);
            item.setUser(user);

            Item newItem=itemRepository.save(item);
            return newItem;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public List<Item> getItemsByUsername(String username) {
        User user=userService.getUserByUsername(username);
        return (List<Item>) itemRepository.findByUser(user);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item updateItem(Item item) throws IOException {
        Item localItem = getItemById(item.getId());

        if(localItem==null){
            throw new IOException("Item was not found!");
        }else{
            localItem.setName(item.getName());
            localItem.setItemCondition(item.getItemCondition());
            localItem.setStatus(item.getStatus());
            localItem.setDescription(item.getStatus());

            return itemRepository.save(localItem);
        }
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }
}
