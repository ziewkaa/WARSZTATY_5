package pl.coderslab.service;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

import java.util.List;

public interface TweetService {

    void saveTweet(Tweet tweet);

    List<Tweet> findAllTweetsByUserID(Long id);

    List<Tweet> findAllTweets();

//    List<Tweet> findAllTweetsByUser(User user);
}
