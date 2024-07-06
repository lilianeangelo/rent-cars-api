package br.gov.sp.fatec.domain.request;

import br.gov.sp.fatec.domain.enums.CarroStatus;
import lombok.Builder;

@Builder
public record CarroUpdateRequest(
        Long id,
        String modelo,
        String marca,
        int ano,
        CarroStatus carroStatus
) {}
