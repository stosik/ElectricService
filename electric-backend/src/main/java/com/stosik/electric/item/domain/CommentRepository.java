package com.stosik.electric.item.domain;

import com.stosik.electric.item.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
}
