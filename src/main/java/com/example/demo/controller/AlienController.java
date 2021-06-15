package com.example.demo.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
import com.example.demo.service.RegistrationService;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@Autowired
	RegistrationService service;
	
	
	@PostMapping("/Alien")
	public Alien addAlien(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	
	@RequestMapping("/getuser/{aid}")
	//@ResponseBody
	public String getAliensbyID(@PathVariable ("aid") int aid) {
		
		return repo.findById(aid).toString();
	}
	
	
	@GetMapping("/aliens")
	public List<Alien> getAllaliensbyID() {
		return repo.findAll();
	}
	
	@PostMapping("/registeruser")
	public Alien registerUser(@RequestBody Alien alien) throws Exception {
		String tempemail = alien.getKhoji();
		if(tempemail!=null && !"".equals(tempemail)) {
			Alien alienobj = service.fetchUserByKhoji(tempemail);
			if(alienobj!= null) {
				throw new Exception("User with "+ tempemail+ "already exists");
			}
		}
		
		String tempfname = alien.getFname();
		service.fetchUserByFname(tempfname);
		
		
		String templname = alien.getLname();
		service.fetchUserByLname(templname);
		
		String tempstatus = alien.getLname();
		service.fetchUserByStatus(tempstatus);
		
		/*String tembmobile= alien.getMobile();
		service.fetchUserByMobile(tembmobile);*/
		
		
		Alien obj;
		obj = service.saveAlien(alien);
		return obj;
	}
	
	@DeleteMapping("/deletebyid/{aid}")
	public void deleteUser(@PathVariable ("aid") int aid) {
		service.deleteId(aid);
	}
	
	@DeleteMapping("/deleteall")
	public void deleteAllUsers() {
		service.deleteAllUsers();
	}
	
	@PutMapping("/updateuser")
	public Alien updateProduct(@RequestBody Alien alien) {
		return service.updateUser(alien);
	}
	
	
	
	
}





