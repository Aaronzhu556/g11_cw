package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Admin;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired(required = false)
    private AdminService adminService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping("/adminlogin")
    @ResponseBody
    public MyResponse adminLogin(@RequestBody Admin admin){
        try {
            String s = adminService.adminLogin(admin);
            if (s=="200") return MyResponse.builder().code(s).msg("登录成功").info(admin).build();
            else if (s=="201") return MyResponse.builder().code(s).msg("账号或者密码错误").info(null).build();
            else return MyResponse.builder().code(s).msg("没有此账户").info(null).build();
        }catch (Exception e){
            logger.info("=====系统出错");
            return MyResponse.builder().code("203").msg("系统出错").info(null).build();
        }
    }

    @RequestMapping("/updateadmin")
    public MyResponse updateAdmin(@RequestBody Admin admin){
        try {
            int i = adminService.updateAdmin(admin);
            if (i!=0) return new MyResponse("200","修改admin成功",null);
            else return new MyResponse("201","修改admin失败",null);
        }catch (Exception e){
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }
    }

}
