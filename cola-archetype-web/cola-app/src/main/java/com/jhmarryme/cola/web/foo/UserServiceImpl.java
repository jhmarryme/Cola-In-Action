package com.jhmarryme.cola.web.foo;

import com.jhmarryme.cola.dto.SingleResponse;
import com.jhmarryme.cola.web.api.UserServiceI;
import com.jhmarryme.cola.web.dto.UserGetByIdQry;
import com.jhmarryme.cola.web.dto.data.UserDTO;
import com.jhmarryme.cola.web.foo.executor.query.UserGetByIdQryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 12:51
 */
@Service
public class UserServiceImpl implements UserServiceI {

    @Resource
    private UserGetByIdQryExe userGetByIdQryExe;

    @Override
    public SingleResponse<UserDTO> getUserById(UserGetByIdQry userGetByIdQry) {
        return SingleResponse.of(userGetByIdQryExe.execute(userGetByIdQry));
    }
}
