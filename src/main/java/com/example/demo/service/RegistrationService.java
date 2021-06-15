package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Service
public class RegistrationService {

	@Autowired
	private AlienRepo repo;
	
	public Alien saveAlien(Alien alien ) {
		
		return repo.save(alien);
	}
	
	public Alien fetchUserByKhoji(String email) {
		return repo.findByKhoji(email);
		
	}
	
	public Alien fetchUserByAid(int aid) {
		return repo.findByAid(aid);
	}
	
/*	public Alien fetchUserByEmailAndPassword(String email, String pass) {
		return repo.findByEmailAndPassword(email, pass);
	}
*/
	
	public Alien fetchUserByFname(String fname) {
		return repo.findByFname(fname);
	}
	
	public Alien fetchUserByStatus(String status) {
		return repo.findByStatus(status);
	}
	
	/*public Alien fetchUserByMname(String mname) {
		return repo.findByMname(mname);
	}*/
	
	public Alien fetchUserByLname(String lname) {
		return repo.findByLname(lname);
	}
	
	
	/*public Alien fetchUserByMobile(String mobNo) {
		return repo.findByMobile(mobNo);	
	}*/
	
	public Alien updateUser(Alien alien) {
		Alien existingAlien = repo.findByAid(alien.getAid());
		existingAlien.setKhoji(alien.getKhoji());
		existingAlien.setStatus(alien.getStatus());
		existingAlien.setFname(alien.getFname());
		existingAlien.setLname(alien.getLname());
		return repo.save(existingAlien);
	}
	
	public void deleteAllUsers() {
		repo.deleteAll();
	}
	
	public void deleteId(int aid) {
		repo.deleteById(aid);
	}
}
