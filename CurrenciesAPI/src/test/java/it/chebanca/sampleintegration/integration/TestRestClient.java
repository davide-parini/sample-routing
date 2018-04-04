package it.chebanca.sampleintegration.integration;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.util.Assert;

import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.common.model.CountryBO;

public class TestRestClient {

	private static final Logger LOG = LogManager.getLogger(TestRestClient.class.getName());

	@Test
	public void testIntegration() throws TechnicalException {
		CountriesRestService service = new CountriesRestService();
		List<CountryBO> countries = service.getCountries();
		Assert.notNull(countries, "Null response received.");
		Assert.notEmpty(countries, "Empty list response received.");
		LOG.info(countries);
	}

}
