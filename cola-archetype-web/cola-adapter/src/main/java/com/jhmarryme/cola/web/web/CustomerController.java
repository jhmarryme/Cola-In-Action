package com.jhmarryme.cola.web.web;

import com.jhmarryme.cola.dto.MultiResponse;
import com.jhmarryme.cola.dto.Response;
import com.jhmarryme.cola.web.api.CustomerServiceI;
import com.jhmarryme.cola.web.dto.CustomerAddCmd;
import com.jhmarryme.cola.web.dto.CustomerListByNameQry;
import com.jhmarryme.cola.web.dto.data.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name) {
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd) {
        return customerService.addCustomer(customerAddCmd);
    }
}
