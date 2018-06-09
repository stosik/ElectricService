package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Item;
import com.stosik.electric.item.domain.entity.enums.Status;
import com.stosik.electric.item.domain.exception.ItemNotFoundException;
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
        return itemRepository
            .findById(id)
            .map(itemToItemCommand::from)
            .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
    }
    
    public List<Item> retrieveAllItemsWithingCategory(String category)
    {
        return itemRepository
            .findItemsWithinCategory(category);
    }
    
    public ItemCommand reportMalfunction(Long id)
    {
        return itemRepository
            .findById(id)
            .map(this::changeStatus)
            .map(itemToItemCommand::from)
            .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
    }
    
    public void commentItem(Long id, CommentCommand message)
    {
        Item item = itemRepository.findOne(id);
        item.getComments().add(messageConverter.from(message));
    }
    
    private Item changeStatus(Item item)
    {
        item.setStatus(Status.BROKEN);
        return item;
    }
}
