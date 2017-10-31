package com.example.mpatm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mpatm.mapper.UserMapper;

@Controller
public class HelloController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        userMapper.insert("AA", 20);
        return "index";  
    }

}
