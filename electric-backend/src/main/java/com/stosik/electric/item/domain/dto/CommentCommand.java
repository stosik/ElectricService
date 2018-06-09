package com.stosik.electric.item.domain.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class CommentCommand
{
    @NonNull
    String message;
}
