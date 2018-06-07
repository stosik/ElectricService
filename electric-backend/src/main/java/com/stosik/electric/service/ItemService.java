package com.stosik.electric.service;

import com.stosik.electric.model.dto.MessageCommand;
import com.stosik.electric.model.entity.Item;

import java.util.List;

public interface ItemService
{
    List<Item> fetchAllItemsInMagazine();
    
    Item reportMalfunction(Long id);
    
    List<Item> retrieveAllBrokenItems();
    
    List<Item> retrieveAllItemsWithingCategory(String category);
    
    Item commentItem(Long id, MessageCommand message);
}
