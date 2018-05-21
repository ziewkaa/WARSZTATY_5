package pl.coderslab.service;

import pl.coderslab.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAllCommentsByTweetId(Long id);

}
