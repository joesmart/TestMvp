package com.smart.show.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MainPlace(String name){
		this.name = name;
	}
	
	public static class Tokenizer implements PlaceTokenizer<MainPlace>{

		@Override
		public MainPlace getPlace(String token) {
			// TODO Auto-generated method stub
			return new MainPlace(token);
		}

		@Override
		public String getToken(MainPlace place) {
			// TODO Auto-generated method stub
			return place.getName();
		}
		
	}
	
}
