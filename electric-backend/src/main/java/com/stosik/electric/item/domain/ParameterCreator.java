package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.dto.ParameterCommand;
import com.stosik.electric.item.domain.entity.Parameter;
import lombok.Synchronized;

import javax.annotation.Nullable;

import static java.util.Objects.requireNonNull;

class ParameterCreator
{
    @Synchronized
    @Nullable
    public Parameter from(ParameterCommand parameterCommand)
    {
        requireNonNull(parameterCommand);
        final Parameter parameter = new Parameter();
        parameter.setKey(parameterCommand.getKey());
        parameter.setValue(parameterCommand.getValue());
        
        return parameter;
    }
}
