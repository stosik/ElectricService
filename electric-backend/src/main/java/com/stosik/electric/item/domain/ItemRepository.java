package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.entity.Item;
import com.stosik.electric.item.domain.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>
{
    List<Item> findItemsByStatus(Status status);
    
    @Query("SELECT DISTINCT i from Item i left join fetch i.category left join fetch i.comments left join fetch i.parameters")
    List<Item> findAll();
    
    @Query("SELECT DISTINCT i from Item i where i.category.name = :category")
    List<Item> findItemsWithinCategory(String category);
    
    @Query("SELECT DISTINCT i from Item i left join fetch i.category left join fetch i.comments left join fetch i.parameters where i.id = :id")
    Item findOne(@Param("id") Long id);
}
