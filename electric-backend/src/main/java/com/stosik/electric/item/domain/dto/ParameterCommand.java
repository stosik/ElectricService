package com.stosik.electric.item.domain.dto;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
public class ParameterCommand
{
    @NonFinal
    private String key;
    
    @NonFinal
    private String value;
}
