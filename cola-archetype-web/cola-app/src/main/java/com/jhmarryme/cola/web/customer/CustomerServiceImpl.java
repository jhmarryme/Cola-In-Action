package com.jhmarryme.cola.web.customer;

import com.jhmarryme.cola.config.CatchAndLog;
import com.jhmarryme.cola.dto.MultiResponse;
import com.jhmarryme.cola.dto.Response;
import com.jhmarryme.cola.web.api.CustomerServiceI;
import com.jhmarryme.cola.web.customer.executor.CustomerAddCmdExe;
import com.jhmarryme.cola.web.customer.executor.query.CustomerListByNameQryExe;
import com.jhmarryme.cola.web.dto.CustomerAddCmd;
import com.jhmarryme.cola.web.dto.CustomerListByNameQry;
import com.jhmarryme.cola.web.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    @Override
    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}