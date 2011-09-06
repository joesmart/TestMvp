package com.smart.show.client;

import com.smart.show.client.ui.SampleView;


import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * ClientFactory helpful to use a factory or dependency injection framework like GIN to obtain 
 * references to objects needed throughout your application like the {@link EventBus},
 * {@link PlaceController} and views.
 */
public interface ClientFactory {

	EventBus getEventBus();

	PlaceController getPlaceController();
	public SampleView getSampleView();
	
}
