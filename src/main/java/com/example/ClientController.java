package com.example;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClientController {
	

	@RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public String userForm() {
        return "users/form";
    }
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("username") String username, Model model) {
		byte[] encodedBytes = null;
		try {
			encodedBytes = Base64.getEncoder().encode(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imageBase64 = new String(encodedBytes);
		System.out.println("encodedBytes " + imageBase64);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = new String("http://localhost:8080/users");
		User user  = new User(username, imageBase64);
		
		String status = "";
		String message = "";
		
		try {
			ResponseEntity entity = restTemplate.postForEntity(url, user, ResponseEntity.class);
			status  = entity.getStatusCode().toString();
			message = entity.getHeaders().getLocation().toString();
		} catch (HttpClientErrorException e) { 
			status  = e.getStatusCode().toString();
			message = e.getMessage();
		}

		System.out.println("Message: " + message);
		System.out.println("Status Code: " + status);

        model.addAttribute("message", message);
        model.addAttribute("code", status);
		
		return "users/result";
	}
}
