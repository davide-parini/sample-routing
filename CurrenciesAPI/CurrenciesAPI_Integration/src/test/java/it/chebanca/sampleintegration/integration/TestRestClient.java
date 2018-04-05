package it.chebanca.sampleintegration.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.common.model.CountryBO;

public class TestRestClient {

	private static final Logger LOG = LogManager.getLogger(TestRestClient.class.getName());

	@Test
	public void testIntegration() throws TechnicalException {
		CountriesRestService service = new CountriesRestService();
		List<CountryBO> countries = service.getCountries();
		LOG.info(countries);
		assertNotNull(countries);
	}

	@Test
	public void testPaginazioneValida() throws TechnicalException {
		CountriesRestService service = new CountriesRestService();
		List<CountryBO> countries = service.getCountries(1, 5);
		LOG.info(countries);
		assertNotNull(countries);
		assertEquals(5, countries.size());
	}

	@Test
	public void testPaginazioneNonValida() {
		CountriesRestService service = new CountriesRestService();
		try {
			service.getCountries(0, 5);
			fail("TechnicalException expected");
		} catch (TechnicalException e) {
			LOG.info(e);
			assertTrue("Invalid range!".equals(e.getMessage()));
		}
	}

}
