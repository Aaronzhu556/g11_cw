package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.Service;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ServiceMapper {


    List<Service> getAllService(String sename, String seaddress, String scname);

    int addService(Service service);
    int updateService(Service service);
}
