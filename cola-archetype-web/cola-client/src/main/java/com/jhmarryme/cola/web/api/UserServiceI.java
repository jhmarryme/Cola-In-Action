package com.jhmarryme.cola.web.api;

import com.jhmarryme.cola.dto.SingleResponse;
import com.jhmarryme.cola.web.dto.UserGetByIdQry;
import com.jhmarryme.cola.web.dto.data.UserDTO;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 12:50
 */
public interface UserServiceI {

    SingleResponse<UserDTO> getUserById(UserGetByIdQry userGetByIdQry);
}
