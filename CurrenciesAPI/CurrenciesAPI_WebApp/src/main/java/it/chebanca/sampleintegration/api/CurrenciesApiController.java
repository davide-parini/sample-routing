package it.chebanca.sampleintegration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.chebanca.sampleintegration.api.mapper.CountryApiMapper;
import it.chebanca.sampleintegration.api.model.CountryAO;
import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.integration.CountriesRestService;

@RestController
public class CurrenciesApiController {

	@Autowired
	private CountriesRestService service;

	@GetMapping("/countries")
	public List<CountryAO> countries() throws TechnicalException {
		return CountryApiMapper.INSTANCE.toApiObject(service.getCountries());
	}

}
