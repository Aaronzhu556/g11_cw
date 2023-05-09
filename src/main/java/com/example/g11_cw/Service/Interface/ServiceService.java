package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.QueryInfo.QueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceService {
    List<com.example.g11_cw.Entity.Service> getAllService(QueryInfo queryInfo);
    int addService(com.example.g11_cw.Entity.Service service);
    int updateService(com.example.g11_cw.Entity.Service service);

}
