package com.stosik.electric.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.NonFinal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Parameter
{
    @NonFinal
    String key;
    @NonFinal
    String value;
}
