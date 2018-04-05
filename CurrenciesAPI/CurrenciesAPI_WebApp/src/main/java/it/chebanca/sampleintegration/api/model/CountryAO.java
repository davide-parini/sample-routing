package it.chebanca.sampleintegration.api.model;

import java.util.List;

public class CountryAO {

	private String name;
	private List<CurrencyAO> currencies;

	public CountryAO() {
		super();
	}

	public CountryAO(String name, List<CurrencyAO> currencies) {
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

	public List<CurrencyAO> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyAO> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "CountryAO [name=" + name + ", currencies=" + currencies + "]";
	}

}
