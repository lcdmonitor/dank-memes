package com.dave.enterprise.rest.objects;

import java.util.*;

public class StateList {
	int numberOfStates;
	List<State> states;
	
	public int getNumberOfStates(){
		return this.numberOfStates;
	}
	
	public void setNumberOfStates(int numberOfStates){
		this.numberOfStates=numberOfStates;
	}

	public List<State> getStates(){
		return this.states;
	}
	
	public void setStates(List<State> states)
	{
		this.states=states;
	}
}
