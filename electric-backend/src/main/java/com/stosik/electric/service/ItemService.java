package com.stosik.electric.service;

import com.stosik.electric.model.entity.Item;

import java.util.List;

public interface ItemService
{
    List<Item> fetchAllItemsInMagazine();
}
