package com.example.testspringcommunity.service;

import com.example.testspringcommunity.model.Frog;
import com.example.testspringcommunity.repository.FrogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class FrogService {

    @Autowired
    private FrogRepository frogRepository;

    @Async
    public CompletableFuture<Frog> create(Frog frog){
        return CompletableFuture.supplyAsync(() -> frogRepository.save(frog));
    }

    @Async
    public CompletableFuture<List<Frog>> getAll() {
        return CompletableFuture.supplyAsync(() -> frogRepository.findAll());
    }
}
