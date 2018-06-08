package com.stosik.electric.controller;

import com.stosik.electric.model.dto.CommentCommand;
import com.stosik.electric.model.entity.Item;
import com.stosik.electric.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<Item> retrieveAllBrokenItems()
    {
        return itemService.retrieveAllBrokenItems();
    }
    
    @GetMapping("/{category}")
    public List<Item> retrieveAllItemsWithingCategory(@PathVariable String category)
    {
        return itemService.retrieveAllItemsWithingCategory(category);
    }
    
    @PostMapping("/{id}/comment/add")
    public void commentOnItem(@PathVariable Long id, @RequestBody CommentCommand message)
    {
        itemService.commentItem(id, message);
    }
    
    @GetMapping("/{id}/report")
    public void changeStateOfItem(@PathVariable Long id)
    {
        itemService.reportMalfunction(id);
    }
}
