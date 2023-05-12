package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


@Mapper
public interface CustomerMapper {

    @Select("select * from customer where cuemail=#{cuemail}")
    Customer getCustomerByEmail(String cuemail);

    @Insert("insert into customer(cuemail, cupassword, cuname) values (#{cuemail},#{cupassword},#{cuname})")
    int addCustomer(Customer customer);

    @Select("select * from customer")
    List<Customer> getAllCustomer();

    //设置用户描述
    int setCustomerDescription(String description);


    List<Customer> getAllCustomerEmailByServiceId();


    int updateCustomerInfo(Customer customer);
}
