package com.live.practicaapirest.service;


import com.live.practicaapirest.mapper.CustomerMapper;
import com.live.practicaapirest.model.CustomerDto;
import com.live.practicaapirest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
@Slf4j
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

     public CustomerDto save(CustomerDto customerDto) {
         CustomerDto dtoSave = null;
         if(Objects.nonNull(customerDto)){
             dtoSave = customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerDto)));
         }else{
             log.error("Error dto empty");
         }
       return  dtoSave;
    }

}
