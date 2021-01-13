package com.shabushabu.javashop.shop.controllers;

import java.sql.Date;

public class User {
	private String name;
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "name:" + name + " color:" + color ;
	}

}
