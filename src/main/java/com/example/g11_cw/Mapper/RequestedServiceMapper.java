package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.RequestedService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestedServiceMapper {

    List<RequestedService> getAllRequestedServiceByCuId(int cuid);

    List<RequestedService> getAllRequestedServiceBySeId(int seid);

    int addRequestedService(RequestedService requestedService);

    int updateRequestedStatusByReId(int reid, String sestatus);

}
