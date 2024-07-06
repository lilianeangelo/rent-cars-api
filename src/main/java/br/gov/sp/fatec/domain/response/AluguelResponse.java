package br.gov.sp.fatec.domain.response;

import java.util.Date;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.enums.AluguelStatus;

public record AluguelResponse(
        Long id,
        Date dataInicioLocacao,
        Date dataFimLocacao,
        Double valorLocacao,
        AluguelStatus aluguelStatus,
        Carro carro,
        Cliente cliente
) {}
