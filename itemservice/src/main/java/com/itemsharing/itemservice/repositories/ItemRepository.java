package com.itemsharing.itemservice.repositories;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ItemRepository extends CrudRepository<Item,Long> {
    Item findItemByName(String name);
    List<Item> findByUser(User user);
}
