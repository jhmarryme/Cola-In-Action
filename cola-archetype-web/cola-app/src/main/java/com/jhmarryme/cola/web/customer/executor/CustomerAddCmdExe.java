
package com.jhmarryme.cola.web.customer.executor;

import com.jhmarryme.cola.dto.Response;
import com.jhmarryme.cola.exception.BizException;
import com.jhmarryme.cola.web.dto.CustomerAddCmd;
import com.jhmarryme.cola.web.dto.data.ErrorCode;
import org.springframework.stereotype.Component;


@Component
public class CustomerAddCmdExe {

    public Response execute(CustomerAddCmd cmd) {
        //The flow of usecase is defined here.
        //The core ablility should be implemented in Domain. or sink to Domian gradually
        if (cmd.getCustomerDTO().getCompanyName().equals("ConflictCompanyName")) {
            throw new BizException(ErrorCode.B_CUSTOMER_companyNameConflict.getErrCode(), "公司名冲突");
        }
        return Response.buildSuccess();
    }

}
