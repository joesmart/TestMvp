package com.smart.show.shared;

import java.util.Date;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.smart.show.server.Task;

@ProxyFor(Task.class)
public interface TaskProxy extends EntityProxy {
	  Date getDueDate();

	  Long getId();

	  String getName();

	  String getNotes();

	  void setDueDate(Date dueDate);

	  void setName(String name);

	  void setNotes(String notes);
}
