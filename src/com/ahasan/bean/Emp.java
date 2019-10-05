package com.ahasan.bean;

import java.util.HashSet;
import java.util.Set;

public class Emp {
	private int id;
	private String name;
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	
	public static void main(String[] args) {
		Set<Emp>  emps=new HashSet<Emp>();
		Emp e1=new Emp(1, "A");
		Emp e2=new Emp(1, "A");
		
		emps.add(e1);
		emps.add(e2);
		e1.setName("D");
		emps.forEach(action->System.out.println(action.getId()+" : "+action.getName()));
		
		System.out.println(emps.contains(e1));
	}
}
