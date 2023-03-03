package com.project.TechnicalTest.Services;

import com.project.TechnicalTest.Models.*;
import com.project.TechnicalTest.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeBenefitService {

    @Autowired
    PaymentDetailsRepository PDR;

    @Autowired
    EmployeeIDRepository EID;

    @Autowired
    EmployeeJobDetailRepository EJD;

    @Autowired
    EmployeeBenefitDetailRepository EBD;

    @Autowired
    MasterCurrencyRepository MC;

    //Post & Put
    public EmployeeID SaveEmployeeID(EmployeeID employeeID){
        return EID.save(employeeID);
    }

    public EmployeeJobDetail SaveEmployeeJob(EmployeeJobDetail EmployeeJob){
        return EJD.save(EmployeeJob);
    }

    public EmployeeBenefitDetail SaveEmployeeBenefit(EmployeeBenefitDetail EmployeeBenefit){
        return EBD.save(EmployeeBenefit);
    }

    public MasterCurrency SaveMasterCurrency(MasterCurrency masterCurrency){
        return MC.save(masterCurrency);
    }

    //Get
    public EmployeeID findByEmployee(Long employeeID){
        Optional<EmployeeID> employee = EID.findById(employeeID);

        if(!employee.isPresent()){
            return null;
        }

        return EID.findById(employeeID).get();
    }

    public MasterCurrency findByCurrency(String Currency){
        Optional<MasterCurrency> Curr = MC.findById(Currency);

        if(!Curr.isPresent()){
            return null;
        }

        return MC.findById(Currency).get();
    }

    public Iterable<PaymentDetails> findAllPayment(){
        return PDR.findAll();
    }

    public List<PaymentDetails> less20Mil(){
        return PDR.salaryLess20Mil();
    }

    public List<PaymentDetails> more20Mil(){
        return PDR.salaryMore20Mil();
    }

    public List<PaymentDetails> employeePayment(Long employeeID){
        return PDR.employeePayment(employeeID);
    }

    //Delete
    public EmployeeID removeEmployee(Long employeeID){
        Optional<EmployeeID> employee = EID.findById(employeeID);

        if(!employee.isPresent()){
            System.out.println("Employee not found");
        } else{
            EID.deleteById(employeeID);
        }
        return null;
    }


}
