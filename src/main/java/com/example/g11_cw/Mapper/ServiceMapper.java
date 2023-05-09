package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.Service;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceMapper {

//    List<Service> getAllService(String service_name, String service_area, String service_category);

    List<Service> getAllService(String pvaddress, String scname);

    int addService(Service service);
    int updateService(Service service);
}
