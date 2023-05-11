package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.Admin;
import com.example.g11_cw.Mapper.AdminMapper;
import com.example.g11_cw.Service.Interface.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired(required = false)
    private AdminMapper adminMapper;

    @Override
    public String adminLogin(Admin admin) {
        Admin adminByName = adminMapper.getAdminByName(admin.getAdname());
        if (adminByName!=null) {
            if (admin.getAdpassword().equals(adminByName.getAdpassword())){
                //正确
                return "200";
            } else {
                return "201";
            }
        }else {
            return "202";//没有此账号
        }
    }

    @Override
    public int updateAdmin(Admin admin){ return 0; }


}
