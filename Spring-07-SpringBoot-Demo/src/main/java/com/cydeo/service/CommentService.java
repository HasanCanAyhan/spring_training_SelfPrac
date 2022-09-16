package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
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

    private final AppConfigData appConfigData;

    private final DBConfigData dbConfigData;


    //                                                           @Qualifier("emailCommentNotificationProxy") or:
    //                                                                      default bean name
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){

        //save in the DB
        commentRepository.storeComment(comment);
        // send email
        commentNotificationProxy.sendComment(comment);

    }


    public void printConfigData(){

        System.out.println( appConfigData.getAbc() );
        System.out.println( appConfigData.getPassword() );
        System.out.println( appConfigData.getUrl() );

        //print Ozzy
        //print abc123
        //print url

    }


    public void printDbConfigData(){

        System.out.println(dbConfigData.getUserName());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());

    }


}
