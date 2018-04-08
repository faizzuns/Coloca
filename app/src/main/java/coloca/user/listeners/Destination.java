package coloca.user.listeners;

import coloca.user.models.destination.Review;
import coloca.user.models.tweet.TweetResult;

/**
 * Created by User on 18/03/2018.
 */

public interface Destination {
    interface OnReviewClicked{
        void onClick(Review tweetResult);
    }
}
