package com.stosik.electric.service.impl;

import com.stosik.electric.model.entity.Item;
import com.stosik.electric.repository.ItemRepository;
import com.stosik.electric.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService
{
    private final ItemRepository itemRepository;
    
    @Override
    public List<Item> fetchAllItemsInMagazine()
    {
        return itemRepository.findAll();
    }
}
