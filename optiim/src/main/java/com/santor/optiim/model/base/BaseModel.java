package com.santor.optiim.model.base;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;


    @Column(nullable = false)
    private String name ;


    @Column(nullable = false)
    private String lastName ;


    @Column()
    private String fullName = name + lastName ;


    @Column(nullable = false)
    private LocalDate birthDate ;


    @Column()
    private String eMail;


    @Column()
    private String phone ;


}
