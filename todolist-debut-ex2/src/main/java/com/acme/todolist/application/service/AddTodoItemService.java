package com.acme.todolist.application.service;

import javax.inject.Inject;

import com.acme.todolist.application.port.out.LoadTodoItem;
import org.springframework.stereotype.Component;

import com.acme.todolist.application.port.in.AddTodoItem;
import com.acme.todolist.application.port.out.UpdateTodoItem;
import com.acme.todolist.domain.TodoItem;

@Component
public class AddTodoItemService implements AddTodoItem {

	private UpdateTodoItem updateTodoItem;

	private LoadTodoItem loadTodoItem;

	@Inject
	public AddTodoItemService(UpdateTodoItem updateTodoItem, LoadTodoItem loadTodoItem) {
		this.loadTodoItem=loadTodoItem;
		this.updateTodoItem= updateTodoItem;
	}

	@Override
	public void addTodoItem(TodoItem item) {
		updateTodoItem.storeNewTodoItem(item);
	}
}
