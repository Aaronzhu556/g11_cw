package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Customer;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.Response;
import com.example.g11_cw.Service.Interface.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/getcustomerbyemail")
    @ResponseBody
    public Response getCustomerByEmail(@RequestParam String cuemail){
        Customer customer = customerService.getCustomerByEmail(cuemail);
        if (customer != null) return new Response("200","查询成功",customer);
        else return new Response("201","查询失败",null);
    }

    @RequestMapping("/addcustomer")
    @ResponseBody
    public Response addCustomer(@RequestBody Customer customer){//这里接收的参数要修改
        int i = customerService.addCustomer(customer);
        if (i==1) return  Response.builder().res_code("200").res_msg("用户注册成功").res_object(null).build();
        else if(i==2) return Response.builder().res_code("201").res_msg("验证码错误").res_object(null).build();
        else return Response.builder().res_code("202").res_msg("用户注册失败").res_object(null).build();
    }
    @RequestMapping("/getallcustomer")
    @ResponseBody
    public Response getAllCustomer(@RequestBody QueryInfo queryInfo){
        List<Customer> allUser = customerService.getAllCustomer(queryInfo);
        return new Response("200","查询所有用户成功",allUser);
    }
//    @RequestMapping("/getuserverificationcode")
//    @ResponseBody
//    public Response getUserVerificationCode(@RequestParam String user_email){
//        try {
//            userService.getUserVerificationCode(user_email);
//            logger.info("code发送成功");
//            return Response.builder().res_code("200").res_msg("Verification Code Send successfully!").res_object(null).build();
//        }catch (Exception e){
//            logger.info("code发送失败");
//            return Response.builder().res_code("202").res_msg("verification code send failure").res_object(null).build();
//        }
//    }
    @RequestMapping("/customerlogin")
    @ResponseBody
    public Response customerLogin(@RequestBody Customer user){
        try {
            String s = customerService.customerLogin(user);
            if (s=="200") return Response.builder().res_code(s).res_msg("登录成功").res_object(user).build();
            else if (s=="201") return Response.builder().res_code(s).res_msg("账号或者密码错误").res_object(null).build();
            else return Response.builder().res_code(s).res_msg("没有此账户").res_object(null).build();
        }catch (Exception e){
            logger.info("=====系统出错");
            return Response.builder().res_code("203").res_msg("系统出错").res_object(null).build();
        }

    }
}
