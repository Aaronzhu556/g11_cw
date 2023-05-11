package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.Service;
import com.example.g11_cw.Mapper.ServiceMapper;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Service.Interface.ServiceService;
import com.example.g11_cw.Utils.PagingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired(required = false)
    private ServiceMapper serviceMapper;
    /**
     * @param queryInfo 分别代表sename seaddress 和 scname  服务名称，城市名称和服务类别
     * */
    @Override
    public List<Service> getAllService(QueryInfo queryInfo) {

        String[] splitStrings = new String[3];

        String[] strs = queryInfo.getQueryInfo().split(",");


        for (int j=0;j<strs.length;j++) splitStrings[j] = strs[j];
        logger.info("string有"+splitStrings.length+"个");
        for (String s:splitStrings
        ) {
            logger.info("str有:"+s);
        }
        List<com.example.g11_cw.Entity.Service> allService = serviceMapper.getAllService(splitStrings[0], splitStrings[1],splitStrings[2]);


        return allService;
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
