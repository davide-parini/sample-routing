package it.chebanca.sampleintegration.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.chebanca.sampleintegration.api.mapper.CountryApiMapper;
import it.chebanca.sampleintegration.api.model.CountryAO;
import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.integration.CountriesRestService;

@RestController
@RequestMapping("/api")
public class CurrenciesApiController {

	@Autowired
	private CountriesRestService service;

	@GetMapping("/countries")
	public List<CountryAO> countries(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) throws TechnicalException {
		return CountryApiMapper.INSTANCE.toApiObject(service.getCountries(page, pageSize));
	}

}
