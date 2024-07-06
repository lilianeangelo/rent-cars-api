package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.AluguelController;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AluguelControllerImpl implements AluguelController {

    @Override
    public ResponseEntity<AluguelResponse> save(AluguelRequest aluguel) {
        return null;
    }

    @Override
    public ResponseEntity<AluguelResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AluguelResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, AluguelUpdateRequest request) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> partiallyUpdateById(Long id, AluguelUpdateRequest request){
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return ResponseEntity.noContent().build();
    }
}
