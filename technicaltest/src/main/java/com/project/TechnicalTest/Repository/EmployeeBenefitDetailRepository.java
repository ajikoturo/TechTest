package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.EmployeeBenefitDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeBenefitDetailRepository extends CrudRepository<EmployeeBenefitDetail, Long> {
}
