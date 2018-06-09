package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Comment;
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
    private CommentCreator commentCreator;
    private ItemCommandCreator itemToItemCommand;
    private CommentRepository commentRepository;
    
    public ItemFacade(ItemRepository itemRepository, CommentCreator commentCreator, ItemCommandCreator itemToItemCommand, CommentRepository commentRepository)
    {
        this.itemRepository = itemRepository;
        this.commentCreator = commentCreator;
        this.itemToItemCommand = itemToItemCommand;
        this.commentRepository = commentRepository;
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
    
    public Comment commentItem(Long id, CommentCommand commentCommand)
    {
        return itemRepository
            .findById(id)
            .map(item -> commentRepository.save(commentCreator.from(commentCommand, item)))
            .orElseThrow(() -> new ItemNotFoundException("Item", "id", id));
    }
    
    private Item changeStatus(Item item)
    {
        item.setStatus(Status.BROKEN);
        return item;
    }
}
