package coloca.user.listeners;

import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.TourGuideResult;

/**
 * Created by User on 18/03/2018.
 */

public interface Main {
    interface OnDestinationClicked{
        void onClick(DestinationResult destinationResult);
    }

    interface OnTourGuideClicked{
        void onClick(TourGuideResult tourGuideResult);
    }
}
