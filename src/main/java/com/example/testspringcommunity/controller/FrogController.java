package com.example.testspringcommunity.controller;

import com.example.testspringcommunity.model.Frog;
import com.example.testspringcommunity.service.FrogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("frog")
public class FrogController {

    @Autowired
    private FrogService frogService;

    @PostMapping("create")
    public CompletableFuture<ResponseEntity<Frog>> create(@RequestBody Frog frog){
        try{
            return frogService.create(frog)
                    .thenApply(createdFrog -> new ResponseEntity<>(createdFrog, HttpStatus.CREATED));
        }
        catch (Exception e){
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT));
        }
    }

    @GetMapping("getAll")
    public CompletableFuture<ResponseEntity<List<Frog>>> getAll(){
        try{
            return frogService.getAll()
                    .thenApply(ResponseEntity::ok);
        } catch (Exception e) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

}
