package com.ms.comments.services;

import com.ms.comments.dto.CommentDTO;
import com.ms.comments.exception.BadRequestException;
import com.ms.comments.exception.ResourceNotFoundException;
import com.ms.comments.models.Comment;
import com.ms.comments.repository.CommentRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(CommentService.class);

    public CommentService(CommentRepository commentRepository,ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public List<Comment> getComments(){

            List<Comment> result = commentRepository.findAll();
        if(result.isEmpty()){
            throw new ResourceNotFoundException("commentarios");
        }
            log.info("Calling to all comments");
            return commentRepository.findAll();

    }

    public ResponseEntity<Comment> getCommentById(Long id){

        try {
            log.info("Obtain a comment with id {}", id);
            Optional<Comment> result = commentRepository.findById(id);
            if (!result.isPresent()) {
                throw new ResourceNotFoundException("commentario", "id", id);
            }
            return ResponseEntity.ok(result.get());
        }catch (DataAccessException ext){
                throw new BadRequestException(ext.getMessage());
        }

    }

    public CommentDTO saveComment(CommentDTO commentDTO){

        try {
            Comment comment = modelMapper.map(commentDTO, Comment.class);
            Comment newComment = commentRepository.save(comment);
            return commentDTO;
        }catch (DataAccessException ext){
            throw new BadRequestException(ext.getMessage());
        }
    }

    public ResponseEntity<Comment> deleteComment(Long id){

        try {
            Optional<Comment> result = commentRepository.findById(id);
            if (!result.isPresent()) {
                throw new ResourceNotFoundException("comentario", "id", id);
            }else{
                commentRepository.delete(result.get());
            }
            return ResponseEntity.ok(result.get());
        }catch (DataAccessException ext){
            throw new BadRequestException(ext.getMessage());
        }

    }

    public List<Comment> getCommentByTask(Long id){

        try {
            log.info("Obtain a comment with task id {}", id);
            List<Comment> result = commentRepository.findCommentByTask(id);
            if (result.isEmpty()) {
                throw new ResourceNotFoundException("commentario", "id", id);
            }
            return result;
        }catch (DataAccessException ext){
            throw new BadRequestException(ext.getMessage());
        }

    }

}
