package com.stosik.electric.model.dto;

import com.stosik.electric.model.entity.Category;
import com.stosik.electric.model.entity.Comment;
import com.stosik.electric.model.entity.Parameter;
import com.stosik.electric.model.entity.enums.Status;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class ItemCommand
{
    @NonNull
    Long id;
    
    String name;
    
    Status status;
    
    Set<Parameter> parameters;
    
    Category category;
    
    Set<Comment> comments;
}
