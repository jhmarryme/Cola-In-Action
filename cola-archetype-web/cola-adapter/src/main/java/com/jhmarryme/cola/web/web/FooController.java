package com.jhmarryme.cola.web.web;

import com.jhmarryme.cola.dto.SingleResponse;
import com.jhmarryme.cola.exception.BizException;
import com.jhmarryme.cola.web.api.UserServiceI;
import com.jhmarryme.cola.web.dto.UserGetByIdQry;
import com.jhmarryme.cola.web.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class FooController {

    @Autowired
    private UserServiceI userService;

    @GetMapping(value = "/user")
    public SingleResponse<UserDTO> getUserById(@RequestParam(required = false) Long id) {
        UserGetByIdQry userGetByIdQry = new UserGetByIdQry();
        userGetByIdQry.setId(id);
        return userService.getUserById(userGetByIdQry);
    }

    @GetMapping(value = "/error")
    public SingleResponse<UserDTO> getError(@RequestParam(required = false) Long id) {
        throw new BizException("PARAM_VERIFICATION_ERROR", "这是错误测试");
    }

}
