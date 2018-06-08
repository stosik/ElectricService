package com.stosik.electric.service;

import com.stosik.electric.model.dto.CommentCommand;
import com.stosik.electric.model.entity.Item;

import java.util.List;

public interface ItemService
{
    List<Item> fetchAllItemsInMagazine();
    
    void reportMalfunction(Long id);
    
    List<Item> retrieveAllBrokenItems();
    
    List<Item> retrieveAllItemsWithingCategory(String category);
    
    void commentItem(Long id, CommentCommand message);
}
