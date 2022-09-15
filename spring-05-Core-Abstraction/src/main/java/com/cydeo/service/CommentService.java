package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    //unique stuff , business logic

    //private final DBCommentRepository dbCommentRepository; // Class - tightly coupled : X

    //@Autowired : no needed ; Constructor will be enough
    private final CommentRepository commentRepository; // Interface - loosely coupled

    //@Autowired : no needed ; Constructor will be enough
    private final CommentNotificationProxy commentNotificationProxy; // Interface


    //                                                           @Qualifier("emailCommentNotificationProxy") or:
    //                                                                      default bean name
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        //save in the DB
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);




    }

}
