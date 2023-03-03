package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.EmployeeJobDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJobDetailRepository extends CrudRepository<EmployeeJobDetail, Long> {
}
