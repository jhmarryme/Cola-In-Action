package com.jhmarryme.cola.web.gatewayimpl.database.jpa.dataobject;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_jpa")
@Data
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
