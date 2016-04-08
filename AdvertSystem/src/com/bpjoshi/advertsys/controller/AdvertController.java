package com.bpjoshi.advertsys.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bpjoshi.advertsys.model.Advert;
import com.bpjoshi.advertsys.service.AdvertService;
/**
 * @author Bhagwati Prasad - write2bpj@gmail.com
 * 
 *  */

@Controller
public class AdvertController {
	
	private AdvertService advertService;
	
	@Autowired
	public void setAdvertService(AdvertService advertService) {
		this.advertService = advertService;
	}

	//Method to Show Current Advertisements Present in the System
	@RequestMapping("/currentAdverts")
	public String getCurrentAdverts(Model model){
		model.addAttribute("adverts", advertService.getCurrentAdverts());
		return "currentAdverts";
	}
	
	//Method to show create Advert page
	@RequestMapping("/createAdvert")
	public String createAdvert(Model model, Principal principal){
		Advert advert=null;
		if(principal!=null){
			String username=principal.getName();
			advert= advertService.getAdvert(username);
		}
		if(advert==null){
		model.addAttribute("advert", new Advert());
		}
		else{
			model.addAttribute("advert", advert);
		}
		return "createAdvert";
	}
	
	//Method Responsible to Make Entry of Advert in DB
	@RequestMapping(value="/doCreateAdvert", method=RequestMethod.POST)
	public String doCreateAdvert(Model model, @Valid Advert advert, BindingResult result, Principal principal,
			@RequestParam(value="delete", required=false) String delete){
		if(result.hasErrors()){
			return "createAdvert";
		}
		if(delete==null){
			String username=principal.getName();
			advert.getUser().setUsername(username);
			advertService.saveOrUpdate(advert);
		}
		else{
			advertService.delete(advert.getId());
			return "advertDeleted";
		}
		
		return "createdAdvert";
	}
}
