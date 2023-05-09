package com.example.g11_cw.Mapper;

import com.example.g11_cw.Entity.ToBeVerified;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ToBeVerifiedMapper {

    @Update("update to_be_verified set tvstatus=#{tvstatus} where service_provider_id=#{service_provider_id}")
    int updateToBeVerifiedStatus(String tvstatus,int pvid);

    @Update("update to_be_verified set tvstatus=#{tvstatus} where service_provider_id=#{service_provider_id}")
    int addToBeVerified(ToBeVerified toBeVerified);
}
