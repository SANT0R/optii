package com.santor.optiim.dao;

import com.santor.optiim.model.firstInput;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface firstInputRepo extends JpaRepository<firstInput, Long> {


    firstInput findByFullName(String fullName);

    firstInput findByEMail(String eMail);

    firstInput findByPhone(String phone);

    List<firstInput> findByFullNameContains(String fullName);
}
