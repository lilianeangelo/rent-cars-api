package br.gov.sp.fatec.domain.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.domain.response.CarroResponse;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = SPRING)
public interface CarroMapper {
    Carro map(CarroRequest source);

    AluguelResponse map(Carro source);

    Carro toEntity(CarroRequest carroRequest);

    CarroResponse toResponse(Carro savedCarro);

    void updateEntityFromDto(CarroUpdateRequest carroUpdateRequest, @MappingTarget Carro carro);
}
