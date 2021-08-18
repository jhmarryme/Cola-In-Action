package com.jhmarryme.cola.web.domain.customer.gateway;

import com.jhmarryme.cola.web.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
