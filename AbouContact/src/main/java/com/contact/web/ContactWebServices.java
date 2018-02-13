package com.contact.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contact.DAO.ContactRepersitory;
import com.contact.model.Contact;

@RestController
public class ContactWebServices {
	@Autowired
	private ContactRepersitory contactRepersitory;
	
	@RequestMapping(value="/contacts",method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return contactRepersitory.findAll();
		
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		return contactRepersitory.findOne(id);
	}
	
	//API REST FULL
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public Page<Contact> chercher(
		@RequestParam(name="mc",defaultValue="")
		String mc,
		@RequestParam(name="page",defaultValue="0")
		int page,
		@RequestParam(name="size",defaultValue="5")
		int size){
	return contactRepersitory.chercher("%"+mc+"%", new PageRequest(page, size));
		
	}
	
	@RequestMapping(value="/contacts",method=RequestMethod.POST)
	public Contact save(@RequestBody Contact c){
		return contactRepersitory.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.PUT)
	public Contact save(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);
		return contactRepersitory.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}",method=RequestMethod.DELETE)
	public boolean supContact(@PathVariable Long id){
		contactRepersitory.delete(id);
		return true;
	}
	
	
	

}
