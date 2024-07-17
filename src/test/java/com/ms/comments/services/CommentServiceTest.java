package com.ms.comments.services;

import com.ms.comments.exception.BadRequestException;
import com.ms.comments.exception.ResourceNotFoundException;
import com.ms.comments.factory.MockFactory;
import com.ms.comments.models.Comment;
import com.ms.comments.repository.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    private CommentService commentService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getComments() {
        when(commentRepository.findAll()).thenReturn(MockFactory.getListComment());
        List<Comment> commentList = commentService.getComments();
        assertNotNull(commentList);
        assertEquals(2, commentList.size());
    }

    @Test
    public void getCommentsEmpty(){
        when(commentRepository.findAll()).thenReturn(new ArrayList<>(Collections.EMPTY_LIST));

        assertThrows(ResourceNotFoundException.class, ()-> {
            commentService.getComments();
        });

    }

    @Test
    public void getCommentById(){
        when(commentRepository.findById(any())).thenReturn(Optional.of(MockFactory.getComment()));
        ResponseEntity<Comment> comment = commentService.getCommentById(1L);
        assertNotNull(comment);
        assertEquals(1L, comment.getBody().getId());
    }

    @Test
    public void getCommentByIdEmpty(){
        when(commentRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () ->{
            commentService.getCommentById(any());
        });
    }

    @Test
    public void getCommentByIdException(){
        when(commentRepository.findById(any())).thenThrow(new DataAccessException(any()) {
            @Override
            public String getLocalizedMessage() {
                return "Error al buscar comentario"; // Mensaje de error personalizado
            }
        });
        ResponseEntity<Comment> comment = commentService.getCommentById(any());
        assertEquals("Error al buscar comentario", comment.getStatusCodeValue());
    }
}