package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
//@SessionScoped
public class CalcBB {
	private String x="500"; //kwota kredytu
	private String y="2";//lata
	private String z="20";//ilosc rat
	private Double result;
	

	
	
	public String getX() {
		return x;
	}


	public void setX(String x) {
		this.x = x;
	}


	public String getY() {
		return y;
	}


	public void setY(String y) {
		this.y = y;
	}


	public String getZ() {
		return z;
	}


	public void setZ(String z) {
		this.z = z;
	}


	public Double getResult() {
		return result;
	}


	public void setResult(Double result) {
		this.result = result;
	}
	public boolean doTheMath() {
		try {
			int x = Integer.parseInt(this.x);
			int y = Integer.parseInt(this.y);
			double z = Double.parseDouble(this.z);
			  
			y = y * 12;
			z = z / 100;
		
			result = (x * z) / (12 * (1 - (Math.pow((12 / (12 + z)), y))));
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jest Gitówa", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			return false;
		}
	}

	@Inject
	FacesContext ctx;

	
	// Go to "showresult" if ok
	public String calc() {
		if (doTheMath()) {
		return "showresult";
		}
		return null;
	
	}
}
