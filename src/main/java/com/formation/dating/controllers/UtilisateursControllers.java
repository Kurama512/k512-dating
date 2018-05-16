package com.formation.dating.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formation.dating.entity.Utilisateur;
import com.formation.dating.services.UtilisateurService;

@Controller
public class UtilisateursControllers {
	
private final UtilisateurService utilisateurService;
	
	@Autowired
	public UtilisateursControllers(UtilisateurService utilisateurService){
		this.utilisateurService=utilisateurService;
	}
	
	//----------------------READ---------------------------------------
	
	@GetMapping("/dating/utilisateurs")
	public ModelAndView getUtilisateurs(ModelMap model){
		List<Utilisateur> users = (List<Utilisateur>) utilisateurService.findAll();
		model.addAttribute("users",users);
		return new ModelAndView ("pages/utilisateurs/users").addObject("users", users);
	}
	
	//----------------------CREATE--------------------------------------
	@GetMapping("/dating/utilisateurs/register")
	public ModelAndView createUser(ModelMap model){
		Utilisateur user = new Utilisateur();
		return new ModelAndView ("pages/utilisateurs/register").addObject("user", user);
	}
	
	@PostMapping("/dating/utilisateurs/register")
	public String postFromCreate(
			@Valid @ModelAttribute(name="user") Utilisateur user, BindingResult userResult,
			ModelMap model) throws IOException{
			
		if (userResult.hasErrors()){
			List<Utilisateur> users = (List<Utilisateur>) utilisateurService.findAll();
			model.addAttribute("users",users);
			return ("pages/utilisateurs/register");
		}else{
			model.addAttribute("user");
			utilisateurService.save(user);
			return "redirect:/dating/utilisateurs";
		}	
	}
	
}
