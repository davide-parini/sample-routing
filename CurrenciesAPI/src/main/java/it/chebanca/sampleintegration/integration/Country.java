package it.chebanca.sampleintegration.integration;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

	private String name;
	private List<Currency> currencies;

	public Country() {
		super();
	}

	public Country(String name, List<Currency> currencies) {
		super();
		this.name = name;
		this.currencies = currencies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", currencies=" + currencies + "]";
	}

}
