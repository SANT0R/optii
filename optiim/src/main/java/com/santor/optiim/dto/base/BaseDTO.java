package com.santor.optiim.dto.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 2263708886354994555L;
    private Long id;


    private String name ;

    private String lastName ;

    private String fullName = name + lastName ;

    private LocalDate birthDate ;

    private String eMail;

    private String phone ;


}
