package com.example.g11_cw.Controller;

import com.example.g11_cw.Entity.Provider;
import com.example.g11_cw.QueryInfo.QueryInfo;
import com.example.g11_cw.Response.Response;
import com.example.g11_cw.Service.Interface.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProviderService providerService;

    @RequestMapping("/getall0provider")
    @ResponseBody
    public Response getAll0Provider(@RequestBody QueryInfo queryInfo) {
        return new Response("200", "查询成功", providerService.getAll0Provider(queryInfo));
    }

    @RequestMapping("/addprovider")
    @ResponseBody
    public Response addProvider(@RequestBody Provider serviceProvider) {
        int i = providerService.addProvider(serviceProvider);
        if (i != 0) return new Response("200", "注册成功,请等待管理员审核", null);
        else return new Response("201", "该邮箱已经注册了账号", null);
    }

    @RequestMapping("/providerlogin")
    @ResponseBody
    public Response providerLogin(@RequestBody Provider provider) {
        String code = providerService.providerLoginByEmail(provider);
        if (code == "200") return new Response(code, "登录成功", null);
        else if (code == "201") return new Response(code, "密码错误,请重试", null);
        else return new Response(code, "用户不存在或者已注册管理员还未审核或者账号被删除", null);
    }

    @RequestMapping("/deleteprovider")
    @ResponseBody
    public Response deleteProvider(@RequestParam int service_provider_id) {
        try {
            int i = providerService.deleteProvider(service_provider_id);
            if (i != 0) return Response.builder().res_code("200").res_msg("删除成功").res_object(null).build();
            else return Response.builder().res_code("201").res_msg("删除失败").res_object(null).build();
        } catch (Exception e) {
            logger.info("===系统出错" + e.toString());
            return Response.builder().res_code("202").res_msg("系统出错").res_object(null).build();
        }
    }

    @RequestMapping("/getall1provider")
    @ResponseBody
    public Response getAll1Provider() {
        try {
            List<Provider> all1ServiceProvider = providerService.getAll1Provider();
            if (all1ServiceProvider.size() != 0)
                return Response.builder().res_code("200").res_msg("查询已激活的serviceProvider成功").res_object(all1ServiceProvider).build();
            else return Response.builder().res_code("201").res_msg("没有查到数据").res_object(null).build();
        } catch (Exception e) {
            logger.info("=====系统出错" + e.toString());
            return Response.builder().res_code("202").res_msg("系统出错").res_object(null).build();
        }

    }
}