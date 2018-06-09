package com.stosik.electric.item.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ItemConfiguration
{
    @Bean
    ItemFacade itemFacade(ItemRepository itemRepository)
    {
        ItemCommandCreator itemCommandCreator = new ItemCommandCreator();
        MessageCreator messageCreator = new MessageCreator();
        
        return new ItemFacade(itemRepository, messageCreator, itemCommandCreator);
    }
}
