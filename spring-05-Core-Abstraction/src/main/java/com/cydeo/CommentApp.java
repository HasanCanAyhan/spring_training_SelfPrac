package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp { // it should be under the main package

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        /*
        Comment is something that can change all the time.
        Whenever user sends a new Comment, it is different than the others,
        so object also has to be new.
        But other objects we created beans from, are never changing objects,
        their job is always the same, take something save it into database,
        take something send it to UI etc. Those beans doesn't need to change.
         */



        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);


    }

}
