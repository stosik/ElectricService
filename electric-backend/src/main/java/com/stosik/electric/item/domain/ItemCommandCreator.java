package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.ItemCommand;
import com.stosik.electric.item.domain.entity.Item;
import lombok.Synchronized;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

class ItemCommandCreator
{
    @Synchronized
    @Nullable
    ItemCommand from(Item item)
    {
        requireNonNull(item);
        return ItemCommand
            .builder()
            .id(item.getId())
            .name(item.getName())
            .category(item.getCategory())
            .status(item.getStatus())
            .parameters(item.getParameters())
            .comments(item.getComments())
            .build();
    }
}
