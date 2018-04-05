package it.chebanca.sampleintegration.integration;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.common.model.CountryBO;
import it.chebanca.sampleintegration.integration.mapper.CountryMapper;
import it.chebanca.sampleintegration.integration.model.Country;

@Component
public class CountriesRestService {

	private static final Logger LOG = LogManager.getLogger(CountriesRestService.class.getName());

	private static final RestTemplate restTemplate = new RestTemplate();
	private static final String REST_COUNTRIES_URL = "https://restcountries.eu/rest/v2/all";

	/**
	 * Questa classe di servizio maschera le speficifità dell'integrazione REST
	 * sottostante. Viene esposto un modello dati basato su oggetti di business
	 * (BO), relegando il modello dati imposto dal servizio REST consumato alla
	 * componente di integratuion.
	 * 
	 * @return La lista di country restituita dal servizio REST, rimappata su
	 *         oggetti del model standard.
	 * @throws TechnicalException
	 */
	public List<CountryBO> getCountries() throws TechnicalException {
		LOG.debug("Calling endpoint " + REST_COUNTRIES_URL);
		Country[] countries = restTemplate.getForObject(REST_COUNTRIES_URL, Country[].class);
		if (countries == null)
			throw new TechnicalException("Got an empty response from REST client!");
		LOG.debug("Response: " + Arrays.asList(countries));
		return CountryMapper.INSTANCE.toBusinessObject(Arrays.asList(countries));
	}

}
