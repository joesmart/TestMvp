package com.smart.show.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.smart.show.client.place.TaskListPlace;
import com.smart.show.client.place.TaskPlace;
import com.smart.show.client.ui.tasklist.TaskEditView;
import com.smart.show.client.ui.tasklist.TaskListView;
import com.smart.show.client.ui.tasklist.TaskReadView;

public class MobileWebAppShellDesktop extends ResizeComposite implements
		MobileWebAppShelll {

	private static MobileWebAppShellDesktopUiBinder uiBinder = GWT
			.create(MobileWebAppShellDesktopUiBinder.class);

	interface MobileWebAppShellDesktopUiBinder extends
			UiBinder<Widget, MobileWebAppShellDesktop> {
	}

	interface MainMenuStyle extends CellList.Style {
	}

	interface Resources extends CellList.Resources {
		@Source({ "MainMenuCellList.css", CellList.Style.DEFAULT_CSS })
		MainMenuStyle cellListStyle();
	}

	@UiField
	Anchor helpLink;

	/**
	 * The main menu list.
	 */
	@UiField(provided = true)
	CellList<MainMenuItem> mainMenu;

	/**
	 * The container that holds content.
	 */
	@UiField
	DeckLayoutPanel contentContainer;

	@UiField
	DockLayoutPanel leftNav;

	/**
	 * The container that holds the pie chart.
	 */
	@UiField
	HasOneWidget pieChartContainer;

	public MobileWebAppShellDesktop() {
		Resources resources = GWT.create(Resources.class);
		mainMenu = new CellList<MainMenuItem>(new MainMenuItem.Cell(),
				resources);
		initWidget(uiBinder.createAndBindUi(this));
	}

	public MobileWebAppShellDesktop(EventBus bus, PlaceController controller) {

	}

	public MobileWebAppShellDesktop(EventBus bus,final PlaceController placeController, TaskListView taskListView,
			TaskEditView taskEditView, TaskReadView taskReadView) {

		// Initialize the main menu.
		Resources resources = GWT.create(Resources.class);
		mainMenu = new CellList<MainMenuItem>(new MainMenuItem.Cell(),
				resources);
		mainMenu.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);

		// We don't expect to have more than 30 menu items.
		mainMenu.setVisibleRange(0, 30);

		// Add items to the main menu.
		final List<MainMenuItem> menuItems = new ArrayList<MainMenuItem>();
		menuItems.add(new MainMenuItem("Task List", new TaskListPlace(false)) {
			@Override
			public boolean mapsToPlace(Place p) {
				// Map to all TaskListPlace instances.
				return p instanceof TaskListPlace;
			}
		});
		menuItems.add(new MainMenuItem("Add Task", TaskPlace.getTaskCreatePlace()));
		mainMenu.setRowData(menuItems);

		// Choose a place when a menu item is selected.
		final SingleSelectionModel<MainMenuItem> selectionModel = new SingleSelectionModel<MainMenuItem>();
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						MainMenuItem selected = selectionModel
								.getSelectedObject();
						if (selected != null
								&& !selected.mapsToPlace(placeController.getWhere())) {
							placeController.goTo(selected.getPlace());
						}
					}
				});
		mainMenu.setSelectionModel(selectionModel);



		// Initialize this widget.
		initWidget(uiBinder.createAndBindUi(this));

		

		/*
		 * Add all views to the DeckLayoutPanel so we can animate between them.
		 * Using a DeckLayoutPanel here works because we only have a few views,
		 * and we always know that the task views should animate in from the
		 * right side of the screen. A more complex app will require more
		 * complex logic to figure out which direction to animate.
		 */
		contentContainer.add(taskListView);
		contentContainer.add(taskReadView);
		contentContainer.add(taskEditView);
		contentContainer.setAnimationDuration(800);

	
	}

	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub

	}
}
