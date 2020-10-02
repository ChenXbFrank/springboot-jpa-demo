package com.frank.shirojwt.web;

import com.frank.shirojwt.entity.User;
import com.frank.shirojwt.repository.UserRepository;
import com.frank.shirojwt.service.UserFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 小石潭记
 * @date 2020/6/20 21:38
 * @Description: ${todo}
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/save")
    public void save(){
        userRepository.save(new User("aa","aa123456","aa@126.com"));
        userRepository.save(new User("bb","bb123456","bb@126.com"));
        userRepository.save(new User("cc","cc123456","cc@126.com"));
    }

    @GetMapping("/getUserInfo")
    public User getUserInfo(@RequestParam("id") String id){
        return userRepository.getOne(Long.parseLong(id));
    }

    @GetMapping("/getUserList")
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @GetMapping("/getSuccessInfo")
    public Object getSuccessInfo(){
        return userFeignClient.getSuccessInfo();
    }

    @GetMapping("/getFailInfo")
    public Object getFailInfo(){
        return userFeignClient.getFailInfo();
    }
}
