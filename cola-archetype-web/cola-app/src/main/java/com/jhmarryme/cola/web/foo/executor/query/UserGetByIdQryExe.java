package com.jhmarryme.cola.web.foo.executor.query;

import com.jhmarryme.cola.web.dto.UserGetByIdQry;
import com.jhmarryme.cola.web.dto.data.UserDTO;
import com.jhmarryme.cola.web.foo.FooUser;
import com.jhmarryme.cola.web.foo.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 12:49
 */
@Component
public class UserGetByIdQryExe {

    @Autowired
    private UserGateway userGateway;

    public UserDTO execute(UserGetByIdQry cmd) {
        FooUser fooUser = userGateway.getByById(cmd.getId());
        // fooUser ->　userDto
        return null;
    }
}
