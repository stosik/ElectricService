package com.stosik.electric.model.dto;

import lombok.NonNull;
import lombok.Value;

@Value
public class MessageCommand
{
    @NonNull
    String message;
}
