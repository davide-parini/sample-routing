package it.chebanca.sampleintegration.api.model;

public class CurrencyAO {

	private String code;
	private String name;
	private String symbol;

	public CurrencyAO() {
		super();
	}

	public CurrencyAO(String code, String name, String symbol) {
		super();
		this.code = code;
		this.name = name;
		this.symbol = symbol;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "CurrencyAO [code=" + code + ", name=" + name + ", symbol=" + symbol + "]";
	}

}
