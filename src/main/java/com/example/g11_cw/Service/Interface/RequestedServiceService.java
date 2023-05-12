package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.Entity.RequestedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestedServiceService {

    List<RequestedService> getAllRequestedServiceByCuId(int cuid);

    List<RequestedService> getAllRequestedServiceBySeId(int seid);

    int addRequestedService(RequestedService requestedService);

    //int updateRequestedStatusByReId(int reid, String sestatus, String sefinish_time);
    int updateRequestedStatusByReId(int reid, String sestatus);
}
