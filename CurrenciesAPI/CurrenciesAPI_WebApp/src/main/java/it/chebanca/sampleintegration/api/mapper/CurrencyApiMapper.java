package it.chebanca.sampleintegration.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.chebanca.sampleintegration.api.model.CurrencyAO;
import it.chebanca.sampleintegration.common.model.CurrencyBO;

@Mapper
public interface CurrencyApiMapper {

	CurrencyApiMapper INSTANCE = Mappers.getMapper(CurrencyApiMapper.class);

	CurrencyAO toApiObject(CurrencyBO obj);

	List<CurrencyAO> toApiObject(List<CurrencyBO> obj);

}
