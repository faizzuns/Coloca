package coloca.user.services;

import coloca.user.listeners.Destination;
import coloca.user.services.apiHelper.AllGuideService;
import coloca.user.services.apiHelper.DestinationService;
import coloca.user.services.apiHelper.DetailGuideService;
import coloca.user.services.apiHelper.PlaceService;
import coloca.user.services.apiHelper.RouteService;
import coloca.user.services.apiHelper.TopTenService;
import coloca.user.utils.RetrofitClientUtils;

public class RetrofitServices {
    public static AllGuideService sendAllGuideRequest(){
        return RetrofitClientUtils.client().create(AllGuideService.class);
    }

    public DestinationService sendDestinationRequest(){
        return RetrofitClientUtils.client().create(DestinationService.class);
    }

    public DetailGuideService sendDetailGuideRequest(){
        return RetrofitClientUtils.client().create(DetailGuideService.class);
    }

    public PlaceService sendPlaceRequest(){
        return RetrofitClientUtils.client().create(PlaceService.class);
    }

    public RouteService sendRouteRequest(){
        return RetrofitClientUtils.client().create(RouteService.class);
    }

    public TopTenService sendTopTenRequest(){
        return RetrofitClientUtils.client().create(TopTenService.class);
    }
}
