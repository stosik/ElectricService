package com.stosik.electric.model.converter;

import com.stosik.electric.model.dto.MessageCommand;
import com.stosik.electric.model.entity.Message;
import com.sun.istack.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MessageCommandToMessage implements Converter<MessageCommand, Message>
{
    @Synchronized
    @Nullable
    @Override
    public Message convert(MessageCommand msg)
    {
        if(msg == null)
        {
            return null;
        }
        else
        {
            final Message message = new Message();
            message.setMessage(message.getMessage());
            
            return message;
        }
    }
}
