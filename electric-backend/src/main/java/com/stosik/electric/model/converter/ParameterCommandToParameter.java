package com.stosik.electric.model.converter;

import com.stosik.electric.model.dto.ParameterCommand;
import com.stosik.electric.model.entity.Parameter;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component
public class ParameterCommandToParameter implements Converter<ParameterCommand, Parameter>
{
    @Synchronized
    @Nullable
    @Override
    public Parameter convert(ParameterCommand parameterCommand)
    {
        if(parameterCommand == null)
        {
            return null;
        }
        else
        {
            final Parameter parameter = new Parameter();
            parameter.setKey(parameterCommand.getKey());
            parameter.setValue(parameterCommand.getValue());
            
            return parameter;
        }
    }
}
