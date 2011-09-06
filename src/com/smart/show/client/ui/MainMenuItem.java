package com.smart.show.client.ui;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.place.shared.Place;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class MainMenuItem {
	static class Cell extends AbstractCell<MainMenuItem>{
		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context,
				MainMenuItem value, SafeHtmlBuilder sb) {
			// TODO Auto-generated method stub
			if(value == null){
				return;
			}
			sb.appendEscaped(value.getName());
		}
		
	}
	
	private final String name;
	private final Place place;

	public MainMenuItem(String name, Place place) {
	    this.name = name;
	    this.place = place;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean mapsToPlace(Place where) {
		// TODO Auto-generated method stub
		return false;
	}

	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

}
