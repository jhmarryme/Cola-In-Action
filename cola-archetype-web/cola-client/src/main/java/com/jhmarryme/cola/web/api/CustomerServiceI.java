package com.jhmarryme.cola.web.api;

import com.jhmarryme.cola.dto.MultiResponse;
import com.jhmarryme.cola.dto.Response;
import com.jhmarryme.cola.web.dto.CustomerAddCmd;
import com.jhmarryme.cola.web.dto.CustomerListByNameQry;
import com.jhmarryme.cola.web.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
