package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long>, PaymentDetailsRepositoryCustom {
}
