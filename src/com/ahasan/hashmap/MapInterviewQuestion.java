package com.ahasan.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ahasan.bean.Emp;

public class MapInterviewQuestion {
	Map<String,Emp>  oldValue;
	Map<String,Emp>  newValue;
	public MapInterviewQuestion() {
		super();
	}
	public MapInterviewQuestion(Map<String, Emp> oldValue, Map<String, Emp> newValue) {
		super();
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	public Map<String, Emp> getOldValue() {
		return oldValue;
	}
	public void setOldValue(Map<String, Emp> oldValue) {
		this.oldValue = oldValue;
	}
	public Map<String, Emp> getNewValue() {
		return newValue;
	}
	public void setNewValue(Map<String, Emp> newValue) {
		this.newValue = newValue;
	}
	
	public static void main(String[] args) {
		MapInterviewQuestion interviewQuestion=new MapInterviewQuestion();
		Map<String,Emp>  oldValue=new HashMap<String, Emp>();
		Map<String,Emp>  newValue=new HashMap<String, Emp>();
		oldValue.put("A", new Emp(1, "A"));
		newValue.put("A", new Emp(1, "A"));
		interviewQuestion.setNewValue(newValue);
		interviewQuestion.setNewValue(newValue);
		
		System.out.println(oldValue);
		
		for(Entry<String, Emp> entry:oldValue.entrySet()) {
			Emp value = entry.getValue();
			value.setName("B");
		}
		
		System.out.println(oldValue);
	}
}
