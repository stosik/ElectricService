package com.stosik.electric.item.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ItemConfiguration
{
    @Bean
    ItemFacade itemFacade(ItemRepository itemRepository, CommentRepository commentRepository)
    {
        ItemCommandCreator itemCommandCreator = new ItemCommandCreator();
        CommentCreator messageCreator = new CommentCreator();
        
        return new ItemFacade(itemRepository, messageCreator, itemCommandCreator, commentRepository);
    }
}
