package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Customer;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public MyResponse getCustomerByEmail(@RequestParam String cuemail){
        Customer customer = customerService.getCustomerByEmail(cuemail);
        if (customer != null) return new MyResponse("200","查询成功",customer);
        else return new MyResponse("201","查询失败",null);
    }

    @RequestMapping("/addcustomer")
    @ResponseBody
    public MyResponse addCustomer(@RequestBody Customer customer){//这里接收的参数要修改
        int i = customerService.addCustomer(customer);
        if (i==1) return  MyResponse.builder().code("200").msg("用户注册成功").info(null).build();
        else if(i==2) return MyResponse.builder().code("201").msg("验证码错误").info(null).build();
        else return MyResponse.builder().code("202").msg("用户注册失败").info(null).build();
    }
    @RequestMapping("/getallcustomer")
    @ResponseBody
    public MyResponse getAllCustomer(@RequestBody QueryInfo queryInfo){
        List<Customer> allUser = customerService.getAllCustomer(queryInfo);
        return new MyResponse("200","查询所有用户成功",allUser);
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
    public MyResponse customerLogin(@RequestBody Customer user){
        try {
            String s = customerService.customerLogin(user);
            if (s=="200") return MyResponse.builder().code(s).msg("登录成功").info(user).build();
            else if (s=="201") return MyResponse.builder().code(s).msg("账号或者密码错误").info(null).build();
            else return MyResponse.builder().code(s).msg("没有此账户").info(null).build();
        }catch (Exception e){
            logger.info("=====系统出错");
            return MyResponse.builder().code("203").msg("系统出错").info(null).build();
        }

    }

    @RequestMapping("/updatecustomerinfo")
    @ResponseBody
    public MyResponse updateCustomerInfo(@RequestBody Customer customer){
        int i = customerService.updateCustomerInfo(customer);
        Customer customerByEmail = customerService.getCustomerByEmail(customer.getCuemail());
        if (i==1) return new MyResponse("200","修改成功",customerByEmail);
        else return new MyResponse("201","修改失败",null);
    }

    @RequestMapping("/setcustomerdescription")
    @ResponseBody
    public MyResponse setCustomerDescription(@RequestParam int id,@RequestParam String description){
        int i = customerService.setCustomerDescription(id, description);
        if (i==1) return new MyResponse("200","修改成功",null);
        else return new MyResponse("201","修改失败",null);
    }
}
