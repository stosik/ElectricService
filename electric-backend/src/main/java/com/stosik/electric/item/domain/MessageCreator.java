package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.CommentCommand;
import com.stosik.electric.item.domain.entity.Comment;
import lombok.Synchronized;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

class MessageCreator
{
    @Synchronized
    @Nullable
    public Comment from(CommentCommand commentCommand)
    {
        requireNonNull(commentCommand);
        final Comment message = new Comment();
        message.setMessage(message.getMessage());
        
        return message;
    }
}
