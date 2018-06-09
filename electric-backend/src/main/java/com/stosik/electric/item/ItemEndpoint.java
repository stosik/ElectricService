package com.stosik.electric.item;

import com.stosik.electric.item.domain.ItemFacade;
import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Item;
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
class ItemEndpoint
{
    private final ItemFacade itemFascade;
    
    @GetMapping("/all")
    public List<Item> retrieveAllItemsInMagazine()
    {
        return itemFascade.fetchAllItemsInMagazine();
    }
    
    @GetMapping("/all/broken")
    public List<Item> retrieveAllBrokenItems()
    {
        return itemFascade.retrieveAllBrokenItems();
    }
    
    @GetMapping("/{category}")
    public List<Item> retrieveAllItemsWithingCategory(@PathVariable String category)
    {
        return itemFascade.retrieveAllItemsWithingCategory(category);
    }
    
    @GetMapping("/{id}/report")
    public void changeStateOfItem(@PathVariable Long id)
    {
        itemFascade.reportMalfunction(id);
    }
    
    @GetMapping("/{id}/details")
    public ItemCommand retrieveItemDetails(@PathVariable Long id)
    {
        return itemFascade.retrieveSpecificItem(id);
    }
    
    @PostMapping("/{id}/comment/add")
    public void commentOnItem(@PathVariable Long id, @RequestBody CommentCommand message)
    {
        itemFascade.commentItem(id, message);
    }
}
