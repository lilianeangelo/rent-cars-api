package br.gov.sp.fatec.domain.entity;

import java.util.Date;

import br.gov.sp.fatec.domain.enums.AluguelStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataInicioLocacao;
    private Date dataFimLocacao;
    private Double valorLocacao;

    @Enumerated(EnumType.STRING)
    private AluguelStatus aluguelStatus;

    @ManyToOne
    private Carro carro;

    @OneToOne
    private Cliente cliente;
}
