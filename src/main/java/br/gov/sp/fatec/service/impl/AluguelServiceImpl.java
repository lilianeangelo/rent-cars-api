package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.exceptions.ResourceNotFoundException;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {


    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    @Transactional
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel aluguel = aluguelMapper.toEntity(aluguelRequest);
        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return aluguelMapper.toResponse(savedAluguel);
    }

    @Override
    @Transactional(readOnly = true)
    public AluguelResponse findById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com id: " + id));
        return aluguelMapper.toResponse(aluguel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll().stream()
                .map(aluguelMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        if (aluguelUpdateRequest == null) {
            throw new IllegalArgumentException("O objeto aluguelUpdateRequest não pode ser nulo");
        }
    
        Aluguel aluguelToUpdate = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com id: " + id));
        aluguelMapper.updateEntityFromDto(aluguelUpdateRequest, aluguelToUpdate);
        aluguelRepository.save(aluguelToUpdate);
    }
    

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (aluguelRepository.existsById(id)) {
            aluguelRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Aluguel não encontrado com id: " + id);
        }
    }
}