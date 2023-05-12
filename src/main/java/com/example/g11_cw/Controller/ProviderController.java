package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Provider;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.MyResponse;
import com.example.g11_cw.Service.Interface.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/getallproviderby0")
    @ResponseBody
    public MyResponse getAllProviderBy0(@RequestBody QueryInfo queryInfo) {
        return new MyResponse("200", "查询成功", providerService.getAllProviderBy0(queryInfo));
    }

    @RequestMapping("/addprovider")
    @ResponseBody
    public MyResponse addProvider(@RequestBody Provider serviceProvider) {
        serviceProvider.setPvis_approved("0");
        int i = providerService.addProvider(serviceProvider);
        if (i != 0) return new MyResponse("200", "注册成功,请等待管理员审核", null);
        else return new MyResponse("201", "该邮箱已经注册了账号", null);
    }

    @RequestMapping("/providerlogin")
    @ResponseBody
    public MyResponse providerLogin(@RequestBody Provider provider) {
        String code = providerService.providerLoginByEmail(provider);
        if (code == "200") return new MyResponse(code, "登录成功", null);
        else if (code == "201") return new MyResponse(code, "密码错误,请重试", null);
        else return new MyResponse(code, "用户不存在或者已注册管理员还未审核或者账号被删除", null);
    }

    @RequestMapping("/deleteprovider")
    @ResponseBody
    public MyResponse deleteProvider(@RequestParam int service_provider_id) {
        try {
            int i = providerService.deleteProvider(service_provider_id);
            if (i != 0) return MyResponse.builder().code("200").msg("删除成功").info(null).build();
            else return MyResponse.builder().code("201").msg("删除失败").info(null).build();
        } catch (Exception e) {
            logger.info("===系统出错" + e.toString());
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }
    }

    @RequestMapping("/getallproviderBy1")
    @ResponseBody
    public MyResponse getAll1Provider() {
        try {
            List<Provider> all1ServiceProvider = providerService.getAllProviderBy1();
            if (all1ServiceProvider.size() != 0)
                return MyResponse.builder().code("200").msg("查询已激活的serviceProvider成功").info(all1ServiceProvider).build();
            else return MyResponse.builder().code("201").msg("没有查到数据").info(null).build();
        } catch (Exception e) {
            logger.info("=====系统出错" + e.toString());
            return MyResponse.builder().code("202").msg("系统出错").info(null).build();
        }

    }

    @RequestMapping("/updateproviderstatus")
    @ResponseBody
    public MyResponse updateProviderStatus(@RequestParam String pvis_status, @RequestParam int pvid){
        int flag = providerService.updateProviderStatus(pvis_status, pvid);
        if (flag!=0){
            return new MyResponse("200","修改成功",null);
        } else {
            return new MyResponse("201", "修改失败", null);
        }
    }

    @RequestMapping("checkprovider")
    @ResponseBody
    public MyResponse checkProvider(@RequestParam int id,@RequestParam String approve){
        int i = providerService.updateProviderStatus(approve, id);
        if (i==1) return new  MyResponse("200","修改状态成功",null);
        else return new MyResponse("201", "修改状态失败", null);
    }
}