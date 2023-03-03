package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.EmployeeID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeIDRepository extends CrudRepository<EmployeeID, Long> {
}
