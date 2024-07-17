package com.ms.comments.repository;

import com.ms.comments.dto.CommentDTO;
import com.ms.comments.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Autowired
    @Query("SELECT c FROM Comment c WHERE c.task = :id ")
    List<Comment> findCommentByTask(Long id);

}
