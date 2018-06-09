package com.stosik.electric.item.domain.dto;

import com.stosik.electric.item.domain.entity.Category;
import com.stosik.electric.item.domain.entity.Comment;
import com.stosik.electric.item.domain.entity.Parameter;
import com.stosik.electric.item.domain.entity.enums.Status;
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
