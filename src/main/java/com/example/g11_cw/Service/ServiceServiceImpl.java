package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.Service;
import com.example.g11_cw.Mapper.ServiceMapper;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Service.Interface.ServiceService;
import com.example.g11_cw.Utils.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceMapper serviceMapper;
    /**
     * @param queryInfo 里面的queryInfo 在这个方法中，可能会以,拼接为一个字符串，分别代表pvaddress 和 scname 城市名称和服务类别
     * */
    @Override
    public List<Service> getAllService(QueryInfo queryInfo) {
        String[] splitStrings = queryInfo.getQueryInfo().split(",");

        // List<com.g12.cw1.Entity.Service> allService = serviceMapper.getAllService(splitStrings[0], splitStrings[1], splitStrings[2]);
        List<Service> serviceList = (List<Service>) PagingUtil.pagingData(serviceMapper.getAllService(splitStrings[0], splitStrings[1]),queryInfo.getPageSize(),queryInfo.getPageNum());
        return serviceList;
    }

    @Override
    public int addService(Service service) {
        return 0;
    }

    @Override
    public int updateService(Service service) {
        return 0;
    }
}
