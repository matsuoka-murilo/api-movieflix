package com.movieflix.service;

import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.StreamingResponse;
import com.movieflix.entity.Streaming;
import com.movieflix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRepository repository;

    public List<Streaming> getAll(){
        return repository.findAll();
    }

    public Streaming getById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("id nao encontrado"));
    }

    public Streaming create(Streaming streaming){
        return repository.save(streaming);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
