package com.stosik.electric.model.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class CommentCommand
{
    @NonNull
    String message;
}
