package com.santor.optiim.dao;

import com.santor.optiim.model.firstInput;
import com.santor.optiim.model.report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reportRepo extends JpaRepository<report, Long> {

    report findByFullName(String fullName);

    report findByEMail(String eMail);

    report findByPhone(String phone);

    List<report> findByFullNameContains(String fullName);
}
