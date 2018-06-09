package com.stosik.electric.service.impl;

import com.stosik.electric.model.converter.ItemToItemCommand;
import com.stosik.electric.model.converter.MessageCommandToMessage;
import com.stosik.electric.model.dto.CommentCommand;
import com.stosik.electric.model.dto.ItemCommand;
import com.stosik.electric.model.entity.Item;
import com.stosik.electric.model.entity.enums.Status;
import com.stosik.electric.repository.ItemRepository;
import com.stosik.electric.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ItemServiceImpl implements ItemService
{
    private final ItemRepository itemRepository;
    private final MessageCommandToMessage messageConverter;
    private final ItemToItemCommand itemToItemCommand;
    
    public List<Item> fetchAllItemsInMagazine()
    {
        return itemRepository.findAll();
    }
    
    public List<Item> retrieveAllBrokenItems()
    {
        return itemRepository
            .findItemsByStatus(Status.BROKEN);
    }
    
    public ItemCommand retrieveSpecificItem(Long id)
    {
        return itemToItemCommand
            .convert(itemRepository.findOne(id));
    }
    
    public List<Item> retrieveAllItemsWithingCategory(String category)
    {
        return itemRepository
            .findItemsWithinCategory(category);
    }
    
    public void reportMalfunction(Long id)
    {
        Item item = itemRepository.findOne(id);
        item.setStatus(Status.BROKEN);
    }
    
    public void commentItem(Long id, CommentCommand message)
    {
        Item item = itemRepository.findOne(id);
        item.getComments().add(messageConverter.convert(message));
    }
}
