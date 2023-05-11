package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Admin;
import com.example.g11_cw.Response.Response;
import com.example.g11_cw.Service.Interface.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Response adminLogin(@RequestBody Admin admin){
        try {
            String s = adminService.adminLogin(admin);
            if (s=="200") return Response.builder().res_code(s).res_msg("登录成功").res_object(admin).build();
            else if (s=="201") return Response.builder().res_code(s).res_msg("账号或者密码错误").res_object(null).build();
            else return Response.builder().res_code(s).res_msg("没有此账户").res_object(null).build();
        }catch (Exception e){
            logger.info("=====系统出错");
            return Response.builder().res_code("203").res_msg("系统出错").res_object(null).build();
        }
    }

    @RequestMapping("/updateadmin")
    public Response updateAdmin(@RequestBody Admin admin){
        try {
            int i = adminService.updateAdmin(admin);
            if (i!=0) return new Response("200","修改admin成功",null);
            else return new Response("201","修改admin失败",null);
        }catch (Exception e){
            return Response.builder().res_code("202").res_msg("系统出错").res_object(null).build();
        }
    }

}
