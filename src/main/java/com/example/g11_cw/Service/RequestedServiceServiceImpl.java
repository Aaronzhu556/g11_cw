package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.Mapper.RequestedServiceMapper;
import com.example.g11_cw.Service.Interface.RequestedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestedServiceServiceImpl implements RequestedServiceService {
    @Autowired(required = false)
    private RequestedServiceMapper requestedServiceMapper;
    @Override
    public List<RequestedService> getAllRequestedServiceByCuId(int cuid) {
        return requestedServiceMapper.getAllRequestedServiceByCuId(cuid);
    }

    @Override
    public int addRequestedService(RequestedService requestedService) {
        return requestedServiceMapper.addRequestedService(requestedService);
    }

    @Override
    public int updateRequestedServiceByReId(int reid, String sestatus, String sefinish_time) {
        return requestedServiceMapper.updateRequestedServiceByReId(reid, sestatus, sefinish_time);
    }
}
