package com.stosik.electric.service.impl;

import com.stosik.electric.model.converter.MessageCommandToMessage;
import com.stosik.electric.model.dto.MessageCommand;
import com.stosik.electric.model.entity.Item;
import com.stosik.electric.model.entity.enums.Status;
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
    private final MessageCommandToMessage messageConverter;
    
    public List<Item> fetchAllItemsInMagazine()
    {
        return itemRepository.findAll();
    }
    
    public List<Item> retrieveAllBrokenItems()
    {
        return itemRepository
            .findItemsByStatus(Status.BROKEN);
    }
    
    public List<Item> retrieveAllItemsWithingCategory(String category)
    {
        return itemRepository
            .findItemsWithinCategory(category);
    }
    
    public Item reportMalfunction(Long id)
    {
        Item item = itemRepository.findOne(id);
        item.setStatus(Status.BROKEN);
        
        return item;
    }
    
    public Item commentItem(Long id, MessageCommand message)
    {
        Item item = itemRepository.findOne(id);
        item.getMessages().add(messageConverter.convert(message));
        
        return item;
    }
}
