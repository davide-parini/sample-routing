package it.chebanca.sampleintegration.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.chebanca.sampleintegration.api.mapper.CountryApiMapper;
import it.chebanca.sampleintegration.common.TechnicalException;
import it.chebanca.sampleintegration.integration.CountriesRestService;

@Controller
@RequestMapping("/web")
public class CurrenciesWebController {

	private static final Logger LOG = LogManager.getLogger(CurrenciesWebController.class.getName());

	@Autowired
	private CountriesRestService service;

	@GetMapping("/countries")
	public String countries(Model model) throws TechnicalException {
		LOG.debug("countries()");
		model.addAttribute("countries", CountryApiMapper.INSTANCE.toApiObject(service.getCountries()));
		return "countries/list";
	}

}
