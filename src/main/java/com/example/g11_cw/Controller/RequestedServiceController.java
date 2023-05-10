package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.Response;
import com.example.g11_cw.Service.Interface.RequestedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/requestcontroller")
public class RequestedServiceController {
    @Autowired
    private RequestedServiceService requestedServiceService;
    // 获取当前时间
    LocalDateTime now = LocalDateTime.now();

    // 定义时间格式
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 将当前时间转换为字符串
    String currentTimeString = now.format(formatter);

    @RequestMapping("/addrequestservice")
    public Response addRequest(@RequestBody RequestedService requestedService){
        requestedService.setSesubmit_time(currentTimeString);
        try {
            int i = requestedServiceService.addRequestedService(requestedService);
            if (i!=0) return Response.builder().res_code("200").res_msg("新增request成功").res_object(null).build();
            else return Response.builder().res_code("201").res_msg("新增request失败").res_object(null).build();
        }catch (Exception e){
//            logger.info("========"+e.toString()+"==========");
            return Response.builder().res_code("202").res_msg("系统出错").res_object(null).build();

        }
    }

    @RequestMapping("/getallrequestbyid")
    public Response getAllRequestService(@RequestBody QueryInfo queryInfo){
        try{
            List<RequestedService> allRequest = requestedServiceService.getAllRequestedServiceByCuId(Integer.parseInt(queryInfo.getQueryInfo()));
            if (allRequest.size()!=0) return Response.builder().res_code("200").res_msg("获取所有该用户的订单成功").res_object(allRequest).build();
            else return Response.builder().res_code("201").res_msg("没有评论").res_object(null).build();
        }catch (Exception e){
//            logger.info("=====系统出错"+e.toString());
            return Response.builder().res_code("202").res_msg("系统出错").res_object(null).build();
        }
    }

    @RequestMapping("/updaterequeststatus")
    @ResponseBody
    public Response updateServiceProviderStatus(@RequestParam String sestatus, @RequestParam int reid){
        int i = requestedServiceService.updateRequestedServiceByReId(reid, sestatus, currentTimeString);
        if (i!=0) return new Response("200","修改serviceProvider状态成功",null);
        else return new Response("201","修改serviceProvider状态失败",null);

    }


}
