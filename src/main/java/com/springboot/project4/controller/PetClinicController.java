package com.springboot.project4.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.project4.model.Logins;
import com.springboot.project4.model.Pets;
import com.springboot.project4.model.Response;
import com.springboot.project4.repository.LoginRepository;
import com.springboot.project4.repository.PetRepository;

@RestController
@RequestMapping("/petClinic")
public class PetClinicController {
	@Autowired
	private LoginRepository loginRepository;
	
	@PostMapping(path="/register")
	public String addLogin(@RequestParam String name, @RequestParam String email, @RequestParam String password){
		Logins login=new Logins(name, email, password);
		System.out.println("Started creating login");
		
		try {
			loginRepository.save(login);
			Response response=new Response(101,"Login for "+name+" saved successfully");
			return "<h3>"+response+"</h3><p><a href='/login.html'>Click here to log in</a></p>";
		}catch(Exception e) {
			Response response=new Response(701,"Login for "+name+" not added successfully. Exception: "+e);
			return "<h3>"+response+"</h3>";
		}
	}
	@PostMapping(path="/verify")
	public String verifyLogin(@RequestParam String email, @RequestParam String password){
		System.out.println("Started verifying login");
		
		try {
			Logins credentials=loginRepository.findByEmailAndPassword(email, password);
			if(credentials!=null) {
				Response response=new Response(101,"Thanks for logging in, "+email+"!");
				return "<h3>"+response+"</h3><p>Choose from the following options:<br>"
						+ "<a href='/../add_pet.html'>Click here to add a pet</a><br>"
						+ "<a href='/petClinic/displayPets'>Click here to display all pets</a></p>";
			}else {
				Response response=new Response(501,"Email and password not a match. Please try again.");
				return "<h3>"+response+"</h3>";
			}
		}catch(Exception e) {
			Response response=new Response(701,"Login unsuccessful. Exception: "+e);
			return "<h3>"+response+"</h3>";
		}
	}
	@Autowired
	private PetRepository petRepository;
	
	@PostMapping(path="/addPet")
	public String addPet(@RequestParam String petName, @RequestParam String ownerName, @RequestParam String phone,
			@RequestParam String email, @RequestParam String address, @RequestParam String petType, @RequestParam String lastAppointment){
		Pets pet=new Pets(null, petName, ownerName, phone, email, address, petType, lastAppointment);
		System.out.println("Started creating pet entry");
		
		try {
			petRepository.save(pet);
			Response response=new Response(101,"Log for "+petName+" created successfully");
			return "<h3>"+response+"</h3><p>Select from an option below:<br>"
					+ "<a href='/../add_pet.html'>Click here to add another pet</a><br>"
					+ "<a href='displayPets'>Click here to see all pets</a></p>";
		}catch(Exception e) {
			Response response=new Response(701,"Log for "+petName+" not created successfully. Exception: "+e);
			return "<h3>"+response+"</h3>";
		}
	}
	
	@RequestMapping(path="/displayPets")
	public String displayPets() {	
		ArrayList<Pets> pets=petRepository.findAll();
		String display="<h3>Pet table</h3>"
				+ "<table><tr><th>Pet Id</th><th>Pet Name</th><th>Owner Name</th>"
				+ "<th>Phone</th><th>Email</th><th>Address</th><th>Pet Type</th>"
				+ "<th>Last Appointment</th><th>Edit Details?</th></tr>";
		int i=0;
		while(pets.size()>i) {
			display=display.concat("<tr><td>"+pets.get(i).getId()+"</td><td>"+pets.get(i).getPetName()+
					"</td><td>"+pets.get(i).getOwnerName()+"</td><td>"+pets.get(i).getPhone()+
					"</td><td>"+pets.get(i).getEmail()+"</td><td>"+pets.get(i).getAddress()+
					"</td><td>"+pets.get(i).getPetType()+"</td><td>"+pets.get(i).getLastAppointment()+
					"</td><td><a href='/petClinic/deletePet?id="+pets.get(i).getId()+"'>Delete</a>|<a href='updatePet?id="+pets.get(i).getId()+"+'>Update</a></td></tr>");
			i++;
		}
		return display;
	}
	@GetMapping(path="/deletePet")
	public @ResponseBody String deletePet(@RequestParam (value="id")int id) {
		Pets pet=petRepository.findById(id);
		petRepository.deleteById(id);
		return "Pet "+pet.getPetName()+" has been deleted.";
	}
	@GetMapping(path="/updatePet")
	public @ResponseBody String updatePet(@RequestParam (value="id")int id) {
		Pets pet=petRepository.findById(id);
		String display="<center><h3>Update Product Details</h3>"+
		"<form action='/petClinic/finishUpdate' method='post'>"+
		"<table>"+
		"<tr><td></td><td><input type='hidden' name='id' value='"+pet.getId()+"'></td></tr>"+
		"<tr><td>Pet Name:</td><td><input type='text' name='petName' value='"+pet.getPetName()+"'></td></tr>"+
		"<tr><td>Owner Name:</td><td><input type='text' name='ownerName' value='"+pet.getOwnerName()+"'></td></tr>"+
		"<tr><td>Phone:</td><td><input type='text' name='phone' value='"+pet.getPhone()+"'></td></tr>"+
		"<tr><td>Email:</td><td><input type='text' name='email' value='"+pet.getEmail()+"'></td></tr>"+
		"<tr><td>Address:</td><td><input type='text' name='address' value='"+pet.getAddress()+"'></td></tr>"+
		"<tr><td>Pet Type:</td><td><input type='text' name='petType' value='"+pet.getPetType()+"'></td></tr>"+
		"<tr><td>Last Appointment:</td><td><input type='text' name='lastAppointment' value='"+pet.getLastAppointment()+"'></td></tr>"+
		"<tr><td colspan='2'><input type='submit' value='Save Changes'></td></tr>"+
		"</table>"+
		"</form>"+
		"</center>";
		return display;
	}
	@PostMapping(path="/finishUpdate")
	public String finalizeUpdate(Pets pet) {
		try {
			petRepository.save(pet);
			String display="<h3>Update successful for "+pet.getPetName()+"!</h3><p>"
					+ "<a href='/../add_pet.html'>Click here to add a pet</a><br>"
					+ "<a href='displayPets'>Click here to see all pets</a></p>";
			return display;
		}catch(Exception e) {
			String display="<h3>Exception occurred:</h3><p>"+e;
			return display;
		}
	}
}
