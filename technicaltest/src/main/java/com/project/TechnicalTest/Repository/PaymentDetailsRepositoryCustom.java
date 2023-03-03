package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.EmployeeID;
import com.project.TechnicalTest.Models.PaymentDetails;

import java.util.List;

public interface PaymentDetailsRepositoryCustom {

    List<PaymentDetails> salaryLess20Mil();
    List<PaymentDetails> salaryMore20Mil();
    List<PaymentDetails> employeePayment(Long employeeID);
}
