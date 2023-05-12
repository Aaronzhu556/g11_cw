package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Service;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.ServiceService;
import com.example.g11_cw.Service.Model.InfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/service")
public class ServiceController {
    @Autowired(required = false)
    private ServiceService serviceService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getallservice")
    public MyResponse getAllService(@RequestBody InfoModel infoModel){

        try {
            //QueryInfo queryInfo = QueryInfo.builder().queryInfo(queryInfoModel.getQueryName()+","+queryInfoModel.getQueryArea()+","+queryInfoModel.getQueryCategory()).pageNum(queryInfoModel.getPageNum()).pageSize(queryInfoModel.getPageSize()).build();
            //List<Service> allService = serviceService.getAllService(queryInfo);

            QueryInfo info = QueryInfo.builder().queryInfo(infoModel.getQueryName()+","+infoModel.getQueryArea()+","+infoModel.getQueryCategory()).pageNum(infoModel.getPageNum()).pageSize(infoModel.getPageSize()).build();

            List<Service> allService = serviceService.getAllService(info);

            if (allService.size() != 0) return new MyResponse("200","查询成功",allService);
            else return new MyResponse("201","没有数据",null);
        }catch (Exception e) {
            return new MyResponse("202","查询出错",null);
        }


    }
    @RequestMapping("/addservice")
    public MyResponse addService(@RequestBody Service service){
        try{
            int i = serviceService.addService(service);
            if (i!=0) return new MyResponse("200","新增service成功",null);
            else return new MyResponse("201","新增service失败,请重试",null);
        }
        catch (Exception e){
            return new MyResponse("202","系统出错",null);
        }
    }
    @RequestMapping("/updateservice")
    public MyResponse updateService(@RequestBody Service service){
        try {
            int i = serviceService.updateService(service);
            if (i!=0) return new MyResponse("200","修改service成功",null);
            else return new MyResponse("201","修改service失败",null);
        }catch (Exception e){
            System.out.println(e);
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }
    }

}
