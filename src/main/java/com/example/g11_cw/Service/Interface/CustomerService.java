package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.Entity.Customer;
import com.example.g11_cw.QueryInfo.QueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public Customer getCustomerByEmail(String cuemail);

    public int addCustomer(Customer customer);

    public List<Customer> getAllCustomer(QueryInfo queryInfo);

//    public String getUserVerificationCode(String cuemail);

    public String customerLogin(Customer customer);

}
