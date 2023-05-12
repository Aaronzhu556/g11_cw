package com.example.g11_cw.Service.Interface;

import com.example.g11_cw.Entity.Provider;
import com.example.g11_cw.QueryInfo.QueryInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProviderService {
    public List<Provider> getAllProviderBy0(QueryInfo queryInfo);
    public List<Provider> getAllProviderBy1();
    public int addProvider(Provider provider);
    public String providerLoginByEmail(Provider provider);
//    public int updateServiceProviderRating(int service_provider_id,float service_provider_rating);
    public int deleteProvider(int pvid);

    public int updateProviderStatus(String pvis_approved,int pvid);



}
