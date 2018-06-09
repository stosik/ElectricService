package com.stosik.electric.item.domain

import com.stosik.electric.item.domain.dto.ItemCommand
import com.stosik.electric.item.domain.entity.enums.Status
import groovy.transform.CompileStatic

@CompileStatic
trait SampleItems
{
    ItemCommand lgK5 = createFilmDto("Lg k5", Status.WORKING)
    ItemCommand macbook = createFilmDto("Macbook Air", Status.BROKEN)

    static private ItemCommand createFilmDto(String name, Status status)
    {

        return ItemCommand
            .builder()
            .id(1)
            .name(name)
            .status(status)
            .build()
    }
}
