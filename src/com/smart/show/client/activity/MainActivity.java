package com.smart.show.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.smart.show.client.ClientFactory;
import com.smart.show.client.place.MainPlace;
import com.smart.show.client.ui.SampleView;

public class MainActivity extends AbstractActivity {

	private Place place;
	private ClientFactory clientFactory;
	
	public MainActivity(MainPlace place, ClientFactory clientFactory) {
		// TODO Auto-generated constructor stub
		this.clientFactory = clientFactory;
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		//SampleView view = clientFactory.getSampleView();
	}

}
