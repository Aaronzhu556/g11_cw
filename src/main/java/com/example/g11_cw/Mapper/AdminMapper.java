package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where adname=#{adname}")
    Admin getAdminByName(String adname);

    int updateAdmin(Admin admin);

}
