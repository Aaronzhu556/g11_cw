package com.example.g11_cw.Service;

import com.example.g11_cw.Entity.Provider;
import com.example.g11_cw.Mapper.ProviderMapper;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Service.Interface.ProviderService;
import com.example.g11_cw.Utils.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Override
    public List<Provider> getAll0Provider(QueryInfo queryInfo){
        List<Provider> all0ServiceProvider = providerMapper.getAll0Provider();
        List<Provider> list = (List<Provider>) PagingUtil.pagingData(all0ServiceProvider, queryInfo.getPageSize(), queryInfo.getPageNum());
        return list;
    }
    @Override
    public int addProvider(Provider provider){
        Provider p = providerMapper.getProviderByEmail(provider.getPvemail());
        if (p == null) return providerMapper.addProvider(provider);
        else return 0;
    }
    @Override
    public String providerLoginByEmail(Provider provider){
        Provider serviceProvider1 = providerMapper.getProviderByEmail(provider.getPvemail());
        if (serviceProvider1!=null&&serviceProvider1.getPvis_approved()=="1") {
            if (serviceProvider1.getPvpassword().equals(provider.getPvpassword())) return "200";
            else return "201";
        }else return "202";

    }

//    @Override
//    public int updateServiceProviderRating(int service_provider_id, float service_provider_rating) {
//        return serviceProviderMapper.updateServiceProviderRating(service_provider_id,service_provider_rating);
//    }

    @Override
    public int deleteProvider(int service_provider_id) {
        return providerMapper.deleteProvider(service_provider_id);
    }

    @Override
    public List<Provider> getAll1Provider() {
        return providerMapper.getAll1Provider();
    }

}
