package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.exceptions.ResourceNotFoundException;
import br.gov.sp.fatec.domain.mapper.CarroMapper;
import br.gov.sp.fatec.domain.request.CarroRequest;
import br.gov.sp.fatec.domain.request.CarroUpdateRequest;
import br.gov.sp.fatec.domain.response.CarroResponse;
import br.gov.sp.fatec.repository.CarroRepository;
import br.gov.sp.fatec.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Override
    @Transactional
    public CarroResponse save(CarroRequest carroRequest) {
        Carro carro = carroMapper.toEntity(carroRequest);
        Carro savedCarro = carroRepository.save(carro);
        return carroMapper.toResponse(savedCarro);
    }

    @Override
    @Transactional(readOnly = true)
    public CarroResponse findById(Long id) {
        Carro carro = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com id: " + id));
        return carroMapper.toResponse(carro);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarroResponse> findAll() {
        List<Carro> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void updateById(Long id, CarroUpdateRequest carroUpdateRequest) {
        Carro carroToUpdate = carroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com id: " + id));
        carroMapper.updateEntityFromDto(carroUpdateRequest, carroToUpdate);
        carroRepository.save(carroToUpdate);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Carro não encontrado com id: " + id);
        }
    }
}
