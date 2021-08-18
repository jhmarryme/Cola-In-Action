package com.jhmarryme.cola.web.gatewayimpl;

import com.jhmarryme.cola.web.foo.FooUser;
import com.jhmarryme.cola.web.foo.gateway.UserGateway;
import com.jhmarryme.cola.web.gatewayimpl.database.jpa.UserRepository;
import com.jhmarryme.cola.web.gatewayimpl.database.jpa.dataobject.UserDO;
import com.jhmarryme.cola.web.gatewayimpl.database.mybatis.UserMapper;
import com.jhmarryme.cola.web.gatewayimpl.database.mybatis.dataobject.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 11:23
 */
@Slf4j
@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public FooUser getByById(Long id) {

        UserDO userJpa = userRepository.findById(id).orElse(null);
        log.info("userJpa: \n{}", userJpa);
        User userMybatis = userMapper.selectById(id);
        log.info("userMybatis: \n{}", userMybatis);
        // to foouser
        return null;
    }
}
