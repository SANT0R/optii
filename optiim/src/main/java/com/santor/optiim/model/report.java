package com.santor.optiim.model;

import com.santor.optiim.model.base.BaseModel;

import javax.persistence.Column;

public class report extends BaseModel {



    private static final long serialVersionUID = -6351021095604979392L;


    @Column()
    private String birthPlace;


    @Column()
    private String state ;


    @Column()
    private String workStatus ;


    @Column()
    private String university ;
}
