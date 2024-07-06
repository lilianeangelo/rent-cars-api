package br.gov.sp.fatec.domain.mapper;


import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;

@Mapper(componentModel = SPRING)
public interface AluguelMapper {
    Aluguel map(AluguelRequest source);

    AluguelResponse map(Aluguel source);

    void updateEntityFromDto(AluguelUpdateRequest aluguelUpdateRequest, @MappingTarget Aluguel aluguelToUpdate);

    Aluguel toEntity(AluguelRequest aluguelRequest);

    AluguelResponse toResponse(Aluguel savedAluguel);
}
