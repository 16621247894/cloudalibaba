package com.zwq.controller;

import com.zwq.domain.Storage;
import com.zwq.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public void update(){
        storageService.decrease(1L,20);


    }
}
