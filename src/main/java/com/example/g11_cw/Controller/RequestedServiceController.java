package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.RequestedService;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.RequestedServiceService;
import com.example.g11_cw.Utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requestcontroller")
public class RequestedServiceController {
    @Autowired
    private RequestedServiceService requestedServiceService;

    @RequestMapping("/addrequestservice")
    public MyResponse addRequest(@RequestBody RequestedService requestedService){
        requestedService.setSesubmit_time(TimeUtils.getCurrentDateTime());
        try {
            int i = requestedServiceService.addRequestedService(requestedService);
            if (i!=0) return MyResponse.builder().code("200").msg("新增request成功").info(null).build();
            else return MyResponse.builder().code("201").msg("新增request失败").info(null).build();
        }catch (Exception e){
//            logger.info("========"+e.toString()+"==========");
//            System.out.println(e);
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();

        }
    }

    @RequestMapping("/getallrequestbyid")
    public MyResponse getAllRequestService(@RequestBody QueryInfo queryInfo){
        try{
            List<RequestedService> allRequest = requestedServiceService.getAllRequestedServiceByCuId(Integer.parseInt(queryInfo.getQueryInfo()));
            if (allRequest.size()!=0) return MyResponse.builder().code("200").msg("获取所有该用户的订单成功").info(allRequest).build();
            else return MyResponse.builder().code("201").msg("没有订单").info(null).build();
        }catch (Exception e){
//            logger.info("=====系统出错"+e.toString());
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }
    }

    @RequestMapping("/updaterequeststatus")
    @ResponseBody
    public MyResponse updateRequestedStatus(@RequestParam String sestatus, @RequestParam int reid){
        try{
            //int i = requestedServiceService.updateRequestedStatusByReId(reid, sestatus, TimeUtils.getCurrentDateTime());
            int i = requestedServiceService.updateRequestedStatusByReId(reid, sestatus);
            if (i!=0) return new MyResponse("200","修改serviceProvider状态成功",null);
            else return new MyResponse("201","修改serviceProvider状态失败",null);
        } catch (Exception e){
            System.out.println(e);
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }


    }


}
