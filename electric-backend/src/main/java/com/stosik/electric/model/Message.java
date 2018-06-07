package com.stosik.electric.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    @CreationTimestamp
    Timestamp timestamp;
    
    String message;
}
