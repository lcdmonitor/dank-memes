package com.dave.enterprise.rest.objects;

public class State {
	int stateID;
	String name;
	int population;
	
	public int getStateID(){
		return this.stateID;
	}
	
	public void setStateID(int stateID){
		this.stateID=stateID;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public int getPopulation(){
		return this.population;
	}
	
	public void setPopulation(int population){
		this.population=population;
	}
}
