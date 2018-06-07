package com.stosik.electric.controller;

import com.stosik.electric.model.dto.MessageCommand;
import com.stosik.electric.model.entity.Item;
import com.stosik.electric.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
public class ItemController
{
    private final ItemService itemService;
    
    @GetMapping("/all")
    public List<Item> retrieveAllItemsInMagazine()
    {
        return itemService.fetchAllItemsInMagazine();
    }
    
    @GetMapping("/all/broken")
    public List<Item> retrieveAllBrokent()
    {
        return itemService.retrieveAllBrokenItems();
    }
    
    @GetMapping("/{category}")
    public List<Item> retrieveAllItemsWithingCategory(@RequestParam String category)
    {
        return itemService.retrieveAllItemsWithingCategory(category);
    }
    
    @PostMapping("/{id}/comment/add")
    public Item commentItem(@PathVariable Long id, MessageCommand message)
    {
        return itemService.commentItem(id, message);
    }
    
    @PostMapping("/{id}/changeState")
    public Item changeStateOfItem(@PathVariable Long id)
    {
        return itemService.reportMalfunction(id);
    }
}
