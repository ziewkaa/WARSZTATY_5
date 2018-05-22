package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Comment;
import pl.coderslab.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findAllCommentsByTweetId(Long id) {
        return commentRepository.findAllByTweetIdOderByCreatedAsc(id);
    }

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public int countAllCommentsByTweetId(Long id) {
        return commentRepository.countAllByTweetId(id);
    }
}
