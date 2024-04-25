package com.live.practicaapirest.mapper;

import com.live.practicaapirest.domain.Customer;
import com.live.practicaapirest.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}
