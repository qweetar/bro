package ru.myfirstwebsite.bro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.myfirstwebsite.bro.domain.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}
