package com.stevex.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contact")
public class ContactController {
	
	public static List<Contact> list = new ArrayList<Contact>();
	
	static {
		Contact temp = new Contact(1, "Name1", "Name1", new Date());
		list.add(temp);
		 temp = new Contact(2, "Name2", "Name2", new Date());
		list.add(temp);
		 temp = new Contact(3, "Nam3", "Name3", new Date());
		list.add(temp);
	}
	

	@RequestMapping(value = "/listdata", method = RequestMethod.GET)
	@ResponseBody
	public Contacts listData() {
		return new Contacts(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Contact findContactById(@PathVariable Long id) {
		
		Contact existcontact = new Contact();
		for(Contact tempContact: list){
			if(tempContact.getId() == id){
				existcontact = tempContact;
				break;
			}	
		}
		
		return  existcontact;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public Contact create(@RequestBody Contact contact) {
		list.add(contact);
		return contact;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody Contact contact, @PathVariable Long id) {
		
		Contact existcontact = null;
		for(Contact tempContact: list){
			if(tempContact.getId() == id){
				existcontact = tempContact;
				
				existcontact.setId(id);
				existcontact.setFirstName(contact.getFirstName());
				existcontact.setLastName(contact.getLastName());
				existcontact.setBirthDate(contact.getBirthDate());
				break;
			}	
		}
		
		return "ok";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(@PathVariable Long id) {
		boolean deleteflag = false;
		int index = 0;
		for(Contact tempContact: list){
			if(tempContact.getId() == id){
				list.remove(index);
				deleteflag = true;
				break;
			}	
			index++;
		}
		return deleteflag;
	}
}
