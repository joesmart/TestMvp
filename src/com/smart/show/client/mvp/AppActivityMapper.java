package com.smart.show.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.smart.show.client.ClientFactory;
import com.smart.show.client.activity.MainActivity;
import com.smart.show.client.activity.SampleActivity;
import com.smart.show.client.place.MainPlace;
import com.smart.show.client.place.SamplePlace;

/**
 * ActivityMapper associates each {@link Place} with its corresponding {@link Activity}.
 */
public class AppActivityMapper implements ActivityMapper {

	/**
	 * Provided for {@link Activitie}s.
	 */
	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
	  
		if(place instanceof SamplePlace)
			return new SampleActivity((SamplePlace) place, clientFactory);

		if(place instanceof MainPlace){
			return new MainActivity((MainPlace)place,clientFactory);
		}
		
		return null;
	}

}
