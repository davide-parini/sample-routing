package it.chebanca.sampleintegration.integration.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.chebanca.sampleintegration.common.model.CurrencyBO;
import it.chebanca.sampleintegration.integration.model.Currency;

@Mapper
public interface CurrencyMapper {

	CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

	CurrencyBO toBusinessObject(Currency obj);

	List<CurrencyBO> toBusinessObject(List<Currency> obj);

}
