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

import com.formation.dating.entity.Adresse;
import com.formation.dating.entity.Apparence;
import com.formation.dating.entity.Situation;
import com.formation.dating.entity.Utilisateur;
import com.formation.dating.enums.Orientation;
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
		model.addAttribute("orientation", Orientation.values());
		Utilisateur user = new Utilisateur();
		Situation situation = new Situation();
		Apparence apparence = new Apparence();
		Adresse adresse= new Adresse();
		return new ModelAndView ("pages/utilisateurs/register").addObject("user", user)
				.addObject("situation",situation)
				.addObject("adresse", adresse)
				.addObject("apparence",apparence);
	}
	
	@PostMapping("/register")
	public String postFromCreate(
			@Valid @ModelAttribute(name="user") Utilisateur user, BindingResult userResult,
			@Valid @ModelAttribute(name="adresse") Adresse adresse, BindingResult adresseResult,
			@Valid @ModelAttribute(name="situation") Situation situation, BindingResult situationResult,
			@Valid @ModelAttribute(name="apparence") Apparence apparence, BindingResult apparenceResult,
			ModelMap model) throws IOException{
			
		if (userResult.hasErrors()||adresseResult.hasErrors()||situationResult.hasErrors()||
				apparenceResult.hasErrors()){
			List<Utilisateur> users = (List<Utilisateur>) utilisateurService.findAll();
			model.addAttribute("users",users);
			return ("pages/utilisateurs/register");
		}else{
			user.setApparence(apparence);
			user.setAdresse(adresse);
			user.setSituation(situation);
			model.addAttribute("user", user);
			utilisateurService.save(user);
			return "redirect:/dating/utilisateurs";
		}	
	}
}
