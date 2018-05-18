package com.formation.dating.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.formation.dating.entity.Login;
import com.formation.dating.entity.Photo;
import com.formation.dating.entity.Situation;
import com.formation.dating.entity.Utilisateur;
import com.formation.dating.enums.Orientation;
import com.formation.dating.services.ApparenceService;
import com.formation.dating.services.PhotoService;
import com.formation.dating.services.UtilisateurService;
import com.formation.dating.services.SituationService;
import com.formation.dating.services.AdresseService;

@Controller
public class UtilisateursControllers {
	
	private final UtilisateurService utilisateurService;
	private final ApparenceService apparenceService;
	private final AdresseService adresseService;
	private final SituationService situationService;
	private final PhotoService photoService;
	
	
	@Autowired
	public UtilisateursControllers(UtilisateurService utilisateurService, ApparenceService apparenceService, 
			AdresseService adresseService, SituationService situationService, PhotoService photoService){
		this.utilisateurService=utilisateurService;
		this.apparenceService=apparenceService;
		this.adresseService=adresseService;
		this.situationService=situationService;
		this.photoService=photoService;
	}
	
	//----------------------READ---------------------------------------
	
	@GetMapping("/dating/utilisateurs")
	public ModelAndView getUtilisateurs(ModelMap model, HttpSession httpSession){
		List<Utilisateur> users = (List<Utilisateur>) utilisateurService.findAll();
		model.addAttribute("users",users);
		model.addAttribute("session",httpSession);
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
	
	@PostMapping("/dating/utilisateurs/register")
	public String postFromCreate(
			@Valid @ModelAttribute(name="user") Utilisateur user, BindingResult userResult,
			@Valid @ModelAttribute(name="adresse") Adresse adresse, BindingResult adresseResult,
			@Valid @ModelAttribute(name="situation") Situation situation, BindingResult situationResult,
			@Valid @ModelAttribute(name="apparence") Apparence apparence, BindingResult apparenceResult,
			ModelMap model,
			@RequestParam(value="uploadingFiles")MultipartFile[] uploadingFiles, RedirectAttributes redirectAttributes) throws IOException{
			
		if (userResult.hasErrors()||adresseResult.hasErrors()||situationResult.hasErrors()||
				apparenceResult.hasErrors()){
			List<Utilisateur> users = (List<Utilisateur>) utilisateurService.findAll();
			model.addAttribute("users",users);
			model.addAttribute("orientation", Orientation.values());
			return ("pages/utilisateurs/register");
		}else{
			
			apparenceService.save(apparence);
			user.setApparence(apparence);
			adresseService.save(adresse);
			user.setAdresse(adresse);
			situationService.save(situation);
			user.setSituation(situation);
			user.setMotDePasse(UtilisateurService.get_SHA_512_SecurePassword(user.getMotDePasse()));
			model.addAttribute("user", user);
			utilisateurService.save(user);
			
			for (MultipartFile uploadedFile : uploadingFiles) {
				if(PhotoController.checkIfImage(uploadedFile.getOriginalFilename())){
					File file = new File(PhotoController.UPLOAD_FOLDER + uploadedFile.getOriginalFilename());
					uploadedFile.transferTo(file);
					 Photo photo=new Photo();
					 photo.setUtilisateurPhoto(user);
					 photo.setLien(uploadedFile.getOriginalFilename());
					 System.out.println(photo);
					 photoService.saveOne(photo);
				}  
			}
			List<Photo> photos = photoService.findByUtilisateurPhoto(user);
			user.setPhotos(photos);
			utilisateurService.save(user);
			return "redirect:/dating/utilisateurs/login";
		}	
	}
	
	//-------------------------------LOGIN-------------------------------------------
	
	@GetMapping("/dating/utilisateurs/login")
	public String connexion(ModelMap model){
		Login login=new Login();
		model.addAttribute("login", login);
		return ("pages/utilisateurs/login");
	}
	
	@PostMapping("/dating/utilisateurs/login")
	public String connexionPost(@Valid @ModelAttribute(name="login") Login login,
								BindingResult bindingResult,
								ModelMap model,
								HttpSession httpSession){
		Utilisateur user = utilisateurService.findUtilisateurByEmailAndPassword(login.getEmail(), login.getPassword());
		if(bindingResult.hasErrors() || user == null){
			model.addAttribute("message", "Veuillez vérifier vos informations !");
			return ("pages/utilisateurs/login");
		}
		httpSession.setAttribute("user", user);
		httpSession.setMaxInactiveInterval(360);
		return "redirect:/dating/utilisateurs";
	}
	
	@GetMapping("/dating/utilisateurs/logout")
	public String logout(HttpSession httpSession){
		httpSession.invalidate();
		return "redirect:/dating/utilisateurs/login";
	}
}
