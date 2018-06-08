package com.stosik.electric.model.converter;

import com.stosik.electric.model.dto.ItemCommand;
import com.stosik.electric.model.entity.Item;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component
public class ItemToItemCommand implements Converter<Item, ItemCommand>
{
    @Synchronized
    @Nullable
    @Override
    public ItemCommand convert(Item item)
    {
        if(item == null)
        {
            return null;
        }
        else
        {
            return ItemCommand
                .builder()
                .id(item.getId())
                .category(item.getCategory())
                .status(item.getStatus())
                .parameters(item.getParameters())
                .comments(item.getComments())
                .build();
        }
    }
}
