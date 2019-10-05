package com.ahasan.arraylist.test;

import java.time.LocalDate;

public class Employee {
	long id;
	String name;
	LocalDate of;

	public Employee(long id, String name, LocalDate of) {
		this.id = id;
		this.name = name;
		this.of = of;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getOf() {
		return of;
	}

	public void setOf(LocalDate of) {
		this.of = of;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", of=" + of + "]";
	}

}
