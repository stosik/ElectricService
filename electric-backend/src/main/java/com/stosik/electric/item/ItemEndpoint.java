package com.stosik.electric.item;

import com.stosik.electric.item.domain.ItemFacade;
import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Comment;
import com.stosik.electric.item.domain.entity.Item;
import com.stosik.electric.item.domain.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
@PreAuthorize("hasRole('USER')")
class ItemEndpoint
{
    private final ItemFacade itemFacade;
    
    @GetMapping("/all")
    public List<Item> retrieveAllItemsInMagazine()
    {
        return itemFacade.fetchAllItemsInMagazine();
    }
    
    @GetMapping("/all/broken")
    public List<Item> retrieveAllBrokenItems()
    {
        return itemFacade.retrieveAllBrokenItems();
    }
    
    @GetMapping("/{id}/details")
    public ItemCommand retrieveItemDetails(@PathVariable Long id)
    {
        return itemFacade.retrieveSpecificItem(id);
    }
    
    @GetMapping("/{category}")
    public List<Item> retrieveAllItemsWithingCategory(@PathVariable String category)
    {
        return itemFacade.retrieveAllItemsWithingCategory(category);
    }
    
    @PutMapping("/{id}/report")
    public ItemCommand reportMalfunction(@PathVariable Long id)
    {
        return itemFacade.reportMalfunction(id);
    }
    
    @PostMapping("/{id}/comment/add")
    public Comment commentOnItem(@PathVariable Long id, @RequestBody CommentCommand message)
    {
        return itemFacade.commentItem(id, message);
    }
}
