package coloca.user.listeners;

import coloca.user.models.destination.AllPlaceModel;
import coloca.user.models.destination.DestinationResult;
import coloca.user.models.guide.AllTourGuideModel;
import coloca.user.models.guide.TourGuideResult;

/**
 * Created by User on 18/03/2018.
 */

public interface Main {
    interface OnDestinationClicked{
        void onClick(AllPlaceModel.PlaceData destinationResult);
    }

    interface OnTourGuideClicked{
        void onClick(AllTourGuideModel.TourGuideData tourGuideResult);
    }
}
