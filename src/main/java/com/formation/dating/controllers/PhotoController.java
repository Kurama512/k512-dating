package com.formation.dating.controllers;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.stereotype.Controller;

@Controller
public class PhotoController {
	
    public static String UPLOAD_FOLDER = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";

    public static Boolean checkIfImage(String file) {
        File f = new File(file);
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        return type.equals("image");
    }
}
