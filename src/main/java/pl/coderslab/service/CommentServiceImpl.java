package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comment> findAllCommentsByTweetId(Long id) {
        return commentRepository.findAllByTweetId(id);
    }
}
