package com.stosik.electric.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}