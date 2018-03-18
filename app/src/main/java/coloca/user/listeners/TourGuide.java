package coloca.user.listeners;

import coloca.user.models.guide.TourGuideResult;

/**
 * Created by User on 18/03/2018.
 */

public interface TourGuide {
    interface OnTourGudeClicked{
        void onClick(TourGuideResult tourGuideResult);
    }
}
