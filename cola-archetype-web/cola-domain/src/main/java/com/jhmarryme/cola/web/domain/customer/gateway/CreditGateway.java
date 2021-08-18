package com.jhmarryme.cola.web.domain.customer.gateway;

import com.jhmarryme.cola.web.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
