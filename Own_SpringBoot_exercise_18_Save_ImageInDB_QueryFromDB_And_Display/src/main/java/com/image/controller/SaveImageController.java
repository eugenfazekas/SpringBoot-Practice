package com.image.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.image.service.SaveImageService;

@Controller
public class SaveImageController {
	
	@Autowired
	private SaveImageService saveImageService;
	
	@GetMapping("/")
	 public String index() {
	 return "saveimage";
	 }
	 
	@PostMapping("/upload") 
	 public String singleFileUpload(@RequestParam("file") MultipartFile file,Model model,RedirectAttributes redirectAttributes) throws Exception {
			
	 if (file.isEmpty()) {
		 redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	 		return "redirect:/";
	 }
	 	try {
		  		saveImageService.saveFile(file);
		  		model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
				model.addAttribute("image", saveImageService.showImage(file.getOriginalFilename()));
					  		
	 	} catch (IOException e) {
	 			e.printStackTrace();
	 	}
	 		return "/returnimage";
	 }
}
