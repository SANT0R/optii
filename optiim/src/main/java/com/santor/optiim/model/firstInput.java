package com.santor.optiim.model;


import com.santor.optiim.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class firstInput  extends BaseModel {


    private static final long serialVersionUID = -6351021095604979392L;


    @Column()
    private String state ;
}
