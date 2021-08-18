package com.jhmarryme.cola.web.dto;

import com.jhmarryme.cola.dto.Query;
import lombok.Data;

@Data
public class UserGetByIdQry extends Query {
    private Long id;
}
