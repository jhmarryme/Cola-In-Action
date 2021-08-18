package com.jhmarryme.cola.web.gatewayimpl.database.jpa;

import com.jhmarryme.cola.web.gatewayimpl.database.jpa.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JiaHao Wang
 * @date 2021/8/16 11:20
 */
public interface UserRepository extends JpaRepository<UserDO, Long> {
}
