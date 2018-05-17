package com.formation.dating.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dating.entity.Utilisateur;
import com.formation.dating.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	
	private final UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public Iterable<Utilisateur> findAll(){
		return utilisateurRepository.findAll();
	}

	public void save(@Valid Utilisateur user) {
		utilisateurRepository.save(user);
		
	}
	
	public Utilisateur findUtilisateurByEmailAndPassword(String email, String password){
		return utilisateurRepository.findUtilisateurByEmailUtilisateurAndMotDePasse(email, password);
	}
	
	public static String get_SHA_512_SecurePassword(String passwordToHash) {
        String generatedPassword = null;
        String salt = "olprog";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
