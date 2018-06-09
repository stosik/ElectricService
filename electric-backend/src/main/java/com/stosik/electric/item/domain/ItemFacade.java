package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Item;
import com.stosik.electric.item.domain.entity.enums.Status;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Slf4j
public class ItemFacade
{
    private ItemRepository itemRepository;
    private MessageCreator messageConverter;
    private ItemCommandCreator itemToItemCommand;
    
    public ItemFacade(ItemRepository itemRepository, MessageCreator messageConverter, ItemCommandCreator itemToItemCommand)
    {
        this.itemRepository = itemRepository;
        this.messageConverter = messageConverter;
        this.itemToItemCommand = itemToItemCommand;
    }
    
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
            .from(itemRepository.findOne(id));
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
        item.getComments().add(messageConverter.from(message));
    }
}
