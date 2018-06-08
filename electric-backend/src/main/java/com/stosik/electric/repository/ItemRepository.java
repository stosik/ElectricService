package com.stosik.electric.repository;

import com.stosik.electric.model.entity.Item;
import com.stosik.electric.model.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>
{
    List<Item> findItemsByStatus(Status status);
    
    @Query("SELECT i from Item i where i.category.name = ?1")
    List<Item> findItemsWithinCategory(String category);
}
