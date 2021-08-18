package com.jhmarryme.cola.web.gatewayimpl.database.mybatis.customer;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper{

  public CustomerDO getById(String customerId);
}
