package com.example.demo.dao;
//import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
	
	public Alien findByKhoji(String email);
	
	//  public Alien findByEmailAndPassword(String email, String password);
	
	public Alien findByFname(String fname);
	
	public Alien findByStatus(String status);
	
	//public Alien findByMname(String mname);
	
	public Alien findByLname(String lname);
	
	//public Alien findById(String id);
	
	//public Alien findByMobile(String mobno);
	
	public Alien findByAid(int aid);
	
	public void deleteByAid(int aid);
}
