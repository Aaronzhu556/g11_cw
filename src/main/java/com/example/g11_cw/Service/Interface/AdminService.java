package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.Entity.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
     String adminLogin(Admin admin);

     int updateAdmin(com.example.g11_cw.Entity.Admin admin);


}
