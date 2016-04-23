package com.apress.isf.spring.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

/**
 * Created by nishi on 2016-04-23.
 */
@Component("documentTweet")
public class DocumentTweet {

    @Autowired
    Twitter tweet;

    public void tweet(String text) {
        tweet.timelineOperations().updateStatus(text);
    }
}
