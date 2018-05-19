package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Tweet;
import pl.coderslab.repository.TweetRepository;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService{

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public void saveTweet(Tweet tweet) {
        tweetRepository.save(tweet);
    }

    @Override
    public List<Tweet> findAllTweetsByUserID(Long id) {
        return tweetRepository.findAllByUserID(id);
    }

    @Override
    public List<Tweet> findAllTweets() {
        return tweetRepository.findAll();
    }

//    @Override
//    public List<Tweet> findAllTweetsByUser(User user) {
//        return tweetRepository.findAllByUser(user);
//    }
}
