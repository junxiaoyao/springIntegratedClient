package com.jxy.controller;

import com.jxy.remoteService.HessionRemoteService;
import com.jxy.remoteService.RmiRemoteService;
import com.jxy.security.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ybl
 * @Date: 2018/12/14 0014 11:07
 * @Description:
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private RmiRemoteService rmiRemoteService;

   /* @Autowired
    private HessionRemoteService hessionRemoteService;*/

    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        Map<String, Object> user = new HashMap<>();
        user.put("userName", "jxy");
        model.addAttribute("user", user);
        return "homePage";
    }

    @RequestMapping("login")
    public String loginGet(HttpServletRequest request) {
//        UserDetail userDetail = getUserDetail();
//        UserDetail userDetaildx = getUserInfodx();
//        ResponseEntity responseEntity = getUserInfoResponseEntity();
        // hessionRemoteService.say();
        String say = rmiRemoteService.say();
        // System.out.println("rpc:" + say);
        return "login";
    }

    public ResponseEntity<UserDetail> getUserInfoResponseEntity() {
        RestTemplate template = new RestTemplate();
        return template.getForEntity("http://127.0.0.1:8080/rpc/getUserInfo", UserDetail.class);
    }

    public UserDetail getUserInfodx() {
        RestTemplate r = new RestTemplate();
      /*  UserDetail userDetail = new UserDetail();
        userDetail.setUserPass("13213131");
        userDetail.setRole("asdsad ");
        userDetail.setUserName("客户端发烧");*/
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("userName", "sss");

        return r.postForObject("http://127.0.0.1:8080/rpc/getUserInfodx", paramMap, UserDetail.class);
    }

    public UserDetail getUserDetail() {
        RestTemplate template = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("userName", "乱写的");
        return template.getForObject("http://127.0.0.1:8080/rpc/getUserInfo?userName={userName}", UserDetail.class, map);
    }
}
