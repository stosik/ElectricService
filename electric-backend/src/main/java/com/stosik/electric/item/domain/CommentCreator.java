package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.entity.Comment;
import com.stosik.electric.item.domain.entity.Item;
import lombok.Synchronized;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

class CommentCreator
{
    @Synchronized
    @Nullable
    public Comment from(CommentCommand commentCommand, Item item)
    {
        requireNonNull(commentCommand);
        
        return new Comment(item, commentCommand.getMessage());
    }
}
