package com.smart.show.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sample implementation of {@link SampleView}.
 */
public class SampleViewImpl extends Composite implements SampleView {

	interface Binder extends UiBinder<Widget, SampleViewImpl> {
	}
	
	private static final Binder binder = GWT.create(Binder.class);

	private Presenter listener;
	@UiField
	Button button;

	public SampleViewImpl() {
		initWidget(binder.createAndBindUi(this));
	}

	@Override
	public void setName(String name) {
		button.setHTML(name);
	}

	@Override
	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		Place newPlace = null;
		// TODO
		listener.goTo(newPlace);
	}
}
