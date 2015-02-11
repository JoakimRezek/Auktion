package com.jbay.model;

public class Manad {
	private String manad;
	private double provision;
	
	
	
	@Override
	public String toString() {
		return manad;
	}

	public Manad(String manad, double summa) {
		super();
		this.manad = manad;
		this.provision = summa;
	}
	
	public String getManad() {
		return manad;
	}
	public void setManad(String manad) {
		this.manad = manad;
	}
	public double getProvision() {
		return provision;
	}
	public void setProvision(double provision) {
		this.provision = provision;
	}
	

}
