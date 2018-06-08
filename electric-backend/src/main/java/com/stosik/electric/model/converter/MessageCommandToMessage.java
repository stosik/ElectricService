package com.stosik.electric.model.converter;

import com.stosik.electric.model.dto.CommentCommand;
import com.stosik.electric.model.entity.Comment;
import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageCommandToMessage implements Converter<CommentCommand, Comment>
{
    @Synchronized
    @Nullable
    @Override
    public Comment convert(CommentCommand msg)
    {
        if(msg == null)
        {
            return null;
        }
        else
        {
            final Comment message = new Comment();
            message.setMessage(message.getMessage());
            
            return message;
        }
    }
}
