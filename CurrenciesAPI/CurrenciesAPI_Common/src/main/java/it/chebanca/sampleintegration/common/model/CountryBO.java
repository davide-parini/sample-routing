package it.chebanca.sampleintegration.common.model;

import java.util.List;

public class CountryBO {

	private String name;
	private List<CurrencyBO> currencies;

	public CountryBO() {
		super();
	}

	public CountryBO(String name, List<CurrencyBO> currencies) {
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

	public List<CurrencyBO> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(List<CurrencyBO> currencies) {
		this.currencies = currencies;
	}

	@Override
	public String toString() {
		return "CountryBO [name=" + name + ", currencies=" + currencies + "]";
	}

}
