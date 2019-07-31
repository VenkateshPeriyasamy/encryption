package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Model;
import com.example.demo.repo.Repo;

@RequestMapping("")
@Controller

public class Control  {
	
	@Autowired     
	
	Repo repo;
	
	@RequestMapping(value="sign",method=RequestMethod.POST)
	
	@ResponseBody
	public String model(String username,String password)  throws NullPointerException{
		
		if(username!=null) {
			
	
		
		String encoded = new BCryptPasswordEncoder().encode(password);
		
		repo.save(new Model (username,encoded));
		
		return "signup";
		}
		return "login";
		   
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Model login(String username, String password) throws NullPointerException {
		
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        
        
        Model loginclass = repo.findByUsername(username);
        
        
        if ((loginclass.getUsername().equals(username)) && (bCryptPasswordEncoder.matches(password, loginclass.getPassword()))) {
            return loginclass;
        }
        return loginclass;
    }
	

}
