package com.example.springh1.service;


import com.example.springh1.pojo.Provider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProviderService {
    Integer insertNewProvider(Provider provider);

    Provider getProviderById(Integer id);

    List<Provider> getAllProvider();
}
