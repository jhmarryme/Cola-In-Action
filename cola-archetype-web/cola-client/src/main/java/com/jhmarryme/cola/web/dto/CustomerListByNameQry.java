package com.jhmarryme.cola.web.dto;

import com.jhmarryme.cola.dto.Query;
import lombok.Data;

@Data
public class CustomerListByNameQry extends Query {
    private String name;
}
