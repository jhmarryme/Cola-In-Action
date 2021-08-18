package com.jhmarryme.cola.web.foo.gateway;

import com.jhmarryme.cola.web.foo.FooUser;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 11:25
 */
public interface UserGateway {
    FooUser getByById(Long customerId);

}
