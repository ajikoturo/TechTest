package com.project.TechnicalTest.Controller;

import com.project.TechnicalTest.DTO.ResponseData;
import com.project.TechnicalTest.Models.*;
import com.project.TechnicalTest.Services.EmployeeBenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeBenefitService EBS;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/profile/employeeid")
    public ResponseEntity<ResponseData<EmployeeID>> saveEmployeeID(@Valid @RequestBody EmployeeID employeeID, Errors errors){

        ResponseData<EmployeeID> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeID(employeeID));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/profile/employeeid")
    public ResponseEntity<ResponseData<EmployeeID>> updateEmployeeID(@Valid @RequestBody EmployeeID employeeID, Errors errors){

        ResponseData<EmployeeID> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeID(employeeID));

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/profile/employeejob")
    public ResponseEntity<ResponseData<EmployeeJobDetail>> saveEmployeeJob(@Valid @RequestBody EmployeeJobDetail employeeJobDetail, Errors errors){

        ResponseData<EmployeeJobDetail> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeJob(employeeJobDetail));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/profile/employeejob")
    public ResponseEntity<ResponseData<EmployeeJobDetail>> updateEmployeeJob(@Valid @RequestBody EmployeeJobDetail employeeJobDetail, Errors errors){

        ResponseData<EmployeeJobDetail> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeJob(employeeJobDetail));

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/profile/employeebenefit")
    public ResponseEntity<ResponseData<EmployeeBenefitDetail>> saveEmployeeBenefit(@Valid @RequestBody EmployeeBenefitDetail employeeBenefitDetail, Errors errors){

        ResponseData<EmployeeBenefitDetail> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeBenefit(employeeBenefitDetail));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/profile/employeebenefit")
    public ResponseEntity<ResponseData<EmployeeBenefitDetail>> updateEmployeeBenefit(@Valid @RequestBody EmployeeBenefitDetail employeeBenefitDetail, Errors errors){

        ResponseData<EmployeeBenefitDetail> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveEmployeeBenefit(employeeBenefitDetail));

        return ResponseEntity.ok(responseData);
    }

    @PostMapping("/currency/")
    public ResponseEntity<ResponseData<MasterCurrency>> saveMasterCurrency(@Valid @RequestBody MasterCurrency masterCurrency, Errors errors){

        ResponseData<MasterCurrency> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveMasterCurrency(masterCurrency));

        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/currency/")
    public ResponseEntity<ResponseData<MasterCurrency>> updateMasterCurrency(@Valid @RequestBody MasterCurrency masterCurrency, Errors errors){

        ResponseData<MasterCurrency> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(EBS.SaveMasterCurrency(masterCurrency));

        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/profile/employeeid/{id}")
    public EmployeeID findEmployee(@PathVariable Long id){
        return EBS.findByEmployee(id);
    }

    @GetMapping("/currency/{currencyCode}")
    public MasterCurrency findCurrency(@PathVariable String currencyCode){
        return EBS.findByCurrency(currencyCode);
    }

    @GetMapping("/paymentDetails")
    public Iterable<PaymentDetails> gettAllPayment(){
        return EBS.findAllPayment();
    }

    @GetMapping("/paymentDetails/less20M")
    public List<PaymentDetails> gettPaymentL20(){
        return EBS.less20Mil();
    }

    @GetMapping("/paymentDetails/more20M")
    public List<PaymentDetails> gettPaymentM20(){
        return EBS.more20Mil();
    }

    @GetMapping("/paymentDetails/{id}")
    public List<PaymentDetails> gettPaymentID(@PathVariable Long id){
        return EBS.employeePayment(id);
    }

    @DeleteMapping("/profile/employeeid/{id}")
    public ResponseEntity<ResponseData<EmployeeID>> deleteEmployeeID(@Valid @RequestBody EmployeeID employeeID, @PathVariable Long id, Errors errors){

        ResponseData<EmployeeID> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error: errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setMessages(Collections.singletonList("The data employee with id '"+ id +"' has been deleted"));
        responseData.setPayload(EBS.removeEmployee(id));

        return ResponseEntity.ok(responseData);
    }

}
