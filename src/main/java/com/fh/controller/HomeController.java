package com.fh.controller;

import com.alibaba.fastjson.JSONObject;
import com.fh.entity.vo.Home;
import com.fh.service.HomeService;
import com.fh.util.RedisUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping("finAllHome")
    public List<Home> finAllHome(){
        List<Home> list = homeService.finAllHome();
        for (int i = 0; i <list.size() ; i++) {
            String j=String.valueOf(list.get(i).getId());
            String homeObjet= JSONObject.toJSONString(list.get(i));
            RedisUse.hset("allHome",j,homeObjet);
        }
        return list;
    }
}
