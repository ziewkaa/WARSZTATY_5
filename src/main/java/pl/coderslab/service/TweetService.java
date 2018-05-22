package pl.coderslab.service;

import pl.coderslab.entity.Tweet;

import java.util.List;

public interface TweetService {

    void saveTweet(Tweet tweet);

    List<Tweet> findAllTweetsByUserID(Long id);

    List<Tweet> findAllTweets();

    List<Tweet> findAllTweetsOrderByCreatedDesc();

    Tweet findOneTweetById(Long id);

    void deleteTweet(Tweet tweet);
}
