package it.chebanca.sampleintegration.integration.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.chebanca.sampleintegration.common.model.CountryBO;
import it.chebanca.sampleintegration.integration.model.Country;

@Mapper(uses = CurrencyMapper.class)
public interface CountryMapper {

	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

	CountryBO toBusinessObject(Country obj);

	List<CountryBO> toBusinessObject(List<Country> obj);

}
