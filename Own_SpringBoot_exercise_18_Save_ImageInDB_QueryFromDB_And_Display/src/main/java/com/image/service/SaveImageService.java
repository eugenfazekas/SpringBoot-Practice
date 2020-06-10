package com.image.service;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.image.model.Image;
import com.image.repository.ImageRepository;

@Service
public class SaveImageService {
	
	@Autowired
	private ImageRepository imageRepository;

	public void  saveFile(MultipartFile file) throws IOException {
		
		Image image = new Image();
		image.setName(file.getOriginalFilename());
		image.setData(file.getBytes());
		imageRepository.save(image);
		
		}

	public String showImage(String name) throws Exception {
		Image  image = imageRepository.findByName(name);
		byte[] encodeBase64 = Base64.encodeBase64(image.getData());
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}
}

//String folder = System.getProperty("user.dir")+"/src/main/resources/images/John/";
//System.out.println(folder);
//byte[] bytes = file.getBytes();
//Path path = Paths.get(folder + file.getOriginalFilename());
//Files.write(path,bytes);