package com.ms.comments.controller;

import com.ms.comments.constants.ResourceEndpoint;
import com.ms.comments.dto.CommentDTO;
import com.ms.comments.models.Comment;
import com.ms.comments.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = ResourceEndpoint.ENTERPRISE)

public class CommentController {

    @Autowired
    private CommentService commentService;

    @CrossOrigin(origins = "*")
    @GetMapping(value=ResourceEndpoint.FIND_ALL_COMMENTS)
    public List<Comment> getComments(){
        List<Comment> response= commentService.getComments();
        return response;
        //return null;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value=ResourceEndpoint.FIND_COMMENT_BY_ID)
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id){
        ResponseEntity<Comment> comment = commentService.getCommentById(id);
        return comment;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value=ResourceEndpoint.SAVE_COMMENT)
    public ResponseEntity<CommentDTO> saveComment(@RequestBody @Valid CommentDTO commentDTO){
        CommentDTO response = commentService.saveComment(commentDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        CommentDTO response = new CommentDTO();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(value=ResourceEndpoint.DELETE_COMMENT)
    public ResponseEntity<Comment> deleteComment(@PathVariable Long id){
        ResponseEntity<Comment> response = commentService.deleteComment(id);
        return response;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value=ResourceEndpoint.FIND_COMMENT_TASK)
    public List<Comment> getCommentByTask(
            @RequestParam(value = "id") Long id){
        List<Comment> comment = commentService.getCommentByTask(id);
        return comment;
    }
}
