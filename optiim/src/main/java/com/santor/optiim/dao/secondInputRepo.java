package com.santor.optiim.dao;

import com.santor.optiim.model.secondInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface secondInputRepo extends JpaRepository<secondInput, Long> {


    secondInput findByFullName(String fullName);

    secondInput findByEMail(String eMail);

    secondInput findByPhone(String phone);

    List<secondInput> findByFullNameContains(String fullName);
}
