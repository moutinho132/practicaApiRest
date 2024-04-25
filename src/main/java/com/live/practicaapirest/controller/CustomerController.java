package com.live.practicaapirest.controller;

import com.live.practicaapirest.model.CustomerDto;
import com.live.practicaapirest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/customer")
public class CustomerController {
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto saveCustomer(@RequestBody CustomerDto dto) {
        return customerService.save(dto);
    }
}
