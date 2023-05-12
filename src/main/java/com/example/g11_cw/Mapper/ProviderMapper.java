package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.Provider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProviderMapper {

    @Select("select * from provider where pvis_approved='0'")
    List<Provider> getAllProviderBy0();

    @Select("select * from provider where pvis_approved='1'")
    List<Provider> getAllProviderBy1();

    @Insert("insert into provider(pvname,pvaddress,pvemail,pvdescription,pvphone,pvis_approved,pvpassword) values(#{pvname},#{pvaddress},#{pvemail},#{pvdescription},#{pvphone},#{pvis_approved},#{pvpassword})")
    int addProvider(Provider provider);

    @Select("select * from provider where pvemail=#{pvemail}")
    Provider getProviderByEmail(String pvemail);

//    int updateProviderRating(int pvid,float service_provider_rating);
    @Update("update provider set pvis_approved=#{pvis_approved} where pvid=#{pvid}")
    int updateProviderStatus(String pvis_approved,int pvid);
    int deleteProvider(int pvid);
}
