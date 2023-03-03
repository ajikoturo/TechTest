package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.EmployeeID;
import com.project.TechnicalTest.Models.PaymentDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Transactional
public class PaymentDetailsRepositoryImpl implements PaymentDetailsRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    public List<PaymentDetails> salaryLess20Mil(){
        Query query = null;
        query = em.createNativeQuery("select X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary from (\n" +
                "select EI.employeeid, EI.full_name, EJD.job_position, EJD.department, coalesce(MC.currency_code, 'IDR') as currency_code,\n" +
                "case when EBD.currency_code <> 'IDR' then EBD.salary * MC.rate \n" +
                "\t when EBD.currency_code = 'IDR' then EBD.salary \n" +
                "\t else EBD.salary \n" +
                "end as salary\n" +
                "from employeeid EI\n" +
                "left join employee_job_detail EJD on EI.employeeid = EJD.employeeid \n" +
                "left join employee_benefit_detail EBD on EI.employeeid = EBD.employeeid \n" +
                "left join master_currency MC on EBD.currency_code = MC.currency_code\n" +
                "where \n" +
                "MC.valid_from = (select MAX(MC2.valid_from) from master_currency MC2 where MC2.currency_code = MC.currency_code and MC2.valid_from <= current_date())\n" +
                "order by EI.employeeid\n" +
                ") X\n" +
                "group by X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary", PaymentDetails.class);
                //"having X.salary1 < 20000000", PaymentDetails.class);

        List<PaymentDetails> details = query.getResultList();
        List<PaymentDetails> pd = details.stream().filter(e -> e.getSalary() < 20000000).collect(Collectors.toList());

        return pd;
    }

    public List<PaymentDetails> salaryMore20Mil(){
        Query query = null;
        query = em.createNativeQuery("select X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary from (\n" +
                "select EI.employeeid, EI.full_name, EJD.job_position, EJD.department, coalesce(MC.currency_code, 'IDR') as currency_code,\n" +
                "case when EBD.currency_code <> 'IDR' then EBD.salary * MC.rate \n" +
                "\t when EBD.currency_code = 'IDR' then EBD.salary \n" +
                "\t else EBD.salary \n" +
                "end as salary\n" +
                "from employeeid EI\n" +
                "left join employee_job_detail EJD on EI.employeeid = EJD.employeeid \n" +
                "left join employee_benefit_detail EBD on EI.employeeid = EBD.employeeid \n" +
                "left join master_currency MC on EBD.currency_code = MC.currency_code\n" +
                "where \n" +
                "MC.valid_from = (select MAX(MC2.valid_from) from master_currency MC2 where MC2.currency_code = MC.currency_code and MC2.valid_from <= current_date())\n" +
                "order by EI.employeeid\n" +
                ") X\n" +
                "group by X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary", PaymentDetails.class);
                //"having X.salary1 > 20000000", PaymentDetails.class);
        List<PaymentDetails> details = query.getResultList();
        List<PaymentDetails> pd = details.stream().filter(e -> e.getSalary() > 20000000).collect(Collectors.toList());

        return pd;
    }

    public List<PaymentDetails> employeePayment(Long employeeID){
        Query query = null;
        query = em.createNativeQuery("select X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary from (\r\n" +
                "select EI.employeeid, EI.full_name, EJD.job_position, EJD.department, coalesce(MC.currency_code, 'IDR') as currency_code,\r\n" +
                "case when EBD.currency_code <> 'IDR' then EBD.salary * MC.rate \r\n" +
                "\t when EBD.currency_code = 'IDR' then EBD.salary \r\n" +
                "\t else EBD.salary \r\n" +
                "end as salary\r\n" +
                "from employeeid EI\r\n" +
                "left join employee_job_detail EJD on EI.employeeid = EJD.employeeid \r\n" +
                "left join employee_benefit_detail EBD on EI.employeeid = EBD.employeeid \r\n" +
                "left join master_currency MC on EBD.currency_code = MC.currency_code\r\n" +
                "where EI.employeeid = '"+employeeID+"'\r\n" +
                "and MC.valid_from = (select MAX(MC2.valid_from) from master_currency MC2 where MC2.currency_code = MC.currency_code and MC2.valid_from <= current_date())\r\n" +
                "order by EI.employeeid\r\n" +
                ") X\r\n" +
                "group by X.employeeid, X.full_name, X.job_position, X.department, X.currency_code, X.salary", PaymentDetails.class);

        //query.setParameter(1, employeeID);
        List<PaymentDetails> details = query.getResultList();

        return details;
    }
}
