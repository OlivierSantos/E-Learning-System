package mum.ea.dto;

import java.io.Serializable;

import mum.ea.domain.Command;

public class ResourceDto implements Serializable{
	private static final long serialVersionUID = 4849713453395430477L;
	private Command command;
	private String payLoad;
	 
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public String getPayLoad() {
		return payLoad;
	}
	public void setPayLoad(String payLoad) {
		this.payLoad = payLoad;
	}		
	
	
}
