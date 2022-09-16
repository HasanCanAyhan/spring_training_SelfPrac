package com.cydeo.proxy;

import com.cydeo.model.Comment;

public interface CommentNotificationProxy { // Iterface, because there might be more than one implementations

    void sendComment(Comment comment);

}
