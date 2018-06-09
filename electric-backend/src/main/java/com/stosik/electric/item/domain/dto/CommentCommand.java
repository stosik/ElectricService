package com.stosik.electric.item.domain.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class CommentCommand
{
    @NonNull
    String message;
}
