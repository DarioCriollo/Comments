package com.ms.comments.factory;

import com.ms.comments.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class MockFactory {

    public static List<Comment> getListComment(){
        List<Comment> listComment = new ArrayList<>();
        Comment comment = new Comment();
        comment.setId(1L);
        comment.setMessage("Mejorar el proceso");
        comment.setTask(10L);
        comment.setUser(10L);

        Comment comment1 = new Comment();
        comment1.setId(2L);
        comment1.setMessage("Mejorar el proceso");
        comment1.setTask(10L);
        comment1.setUser(10L);

        listComment.add(comment);
        listComment.add(comment1);

        return listComment;

    }

    public static Comment getComment(){

        Comment comment = new Comment();
        comment.setId(1L);
        comment.setMessage("Mejorar el proceso");
        comment.setTask(10L);
        comment.setUser(10L);

        return comment;

    }
}
