package br.gov.sp.fatec.domain.request;

import java.util.Date;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.enums.AluguelStatus;
import lombok.Builder;

@Builder
public record AluguelRequest(
        Long id,
        Date dataInicioLocacao,
        Date dataFimLocacao,
        Double valorLocacao,
        AluguelStatus aluguelStatus,
        Carro carro,
        Cliente cliente

) {}