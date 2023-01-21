package com.example.springh1.controller;


import com.example.springh1.pojo.Provider;
import com.example.springh1.pojo.Wrapper;
import com.example.springh1.pojo.dto.ProviderDTO;
import com.example.springh1.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/userinfo")
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping
    public ResponseEntity getAllProvider(){
        List<Provider> list = providerService.getAllProvider();

        List<ProviderDTO> transform = list.stream().map(e -> new ProviderDTO(e)).collect(Collectors.toList());
        return new ResponseEntity<>(transform, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createProvider(@RequestBody Wrapper wrapper){

        if(wrapper.getProvider().getFirst_name() == null || wrapper.getProvider().getLast_name() == null || wrapper.getProvider().getDob() == null){
            throw new IllegalArgumentException();
        }

        Integer newId = providerService.insertNewProvider(wrapper.getProvider());

        String success = "Create new user success. New user Id is : " + newId;
        return new ResponseEntity<>(success, HttpStatus.CREATED);

    }
}
