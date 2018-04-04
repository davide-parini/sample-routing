package it.chebanca.sampleintegration.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.chebanca.sampleintegration.api.model.CountryAO;
import it.chebanca.sampleintegration.common.model.CountryBO;

@Mapper(uses = CurrencyApiMapper.class)
public interface CountryApiMapper {

	CountryApiMapper INSTANCE = Mappers.getMapper(CountryApiMapper.class);

	CountryAO toApiObject(CountryBO obj);

	List<CountryAO> toApiObject(List<CountryBO> obj);

}
