package com.example.springh1.service.impl;

import com.example.springh1.pojo.Provider;
import com.example.springh1.repository.ProviderRepository;
import com.example.springh1.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    @Override
    public Integer insertNewProvider(Provider provider) {

        providerRepository.save(provider);

        return provider.getId();
    }

    @Override
    public Provider getProviderById(Integer id) {
        Optional<Provider> res = providerRepository.findById(id);

        if(res.isPresent()){
            return res.get();
        }
        return null;
    }

    @Override
    public List<Provider> getAllProvider() {
        List<Provider> list = new LinkedList<>();

        Iterator<Provider> it = providerRepository.findAll().iterator();

        while(it.hasNext()){
            list.add(it.next());
        }

        return list;
    }


}
