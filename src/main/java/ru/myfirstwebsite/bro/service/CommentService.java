package ru.myfirstwebsite.bro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myfirstwebsite.bro.domain.Comment;
import ru.myfirstwebsite.bro.domain.User;
import ru.myfirstwebsite.bro.domain.Views;
import ru.myfirstwebsite.bro.dto.EventType;
import ru.myfirstwebsite.bro.dto.ObjectType;
import ru.myfirstwebsite.bro.repo.CommentRepo;
import ru.myfirstwebsite.bro.util.WsSender;

import java.util.function.BiConsumer;

@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }

}
