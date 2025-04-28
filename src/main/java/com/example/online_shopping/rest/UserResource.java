package com.example.online_shopping.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.online_shopping.service.UserService;
import com.example.online_shopping.service.dto.AppUserDTO;
import com.example.online_shopping.service.dto.UserDTO;
import com.example.online_shopping.util.JwtTokenUtil;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping("/api")
public class UserResource {
	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	UserService userService;
	

	@PostMapping("/register/tbl-users")
	public UserDTO createTblUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
		log.debug("REST request to save User : {}", userDTO);
		UserDTO result = userService.save(userDTO);
		return result;
	}
	
//	@PostMapping("/tbl-users")
//	public UserDTO createTblUser(
//	    @RequestPart("userDTO") UserDTO userDTO,
//	    @RequestPart(value = "profileImage", required = false) MultipartFile profileImage
//	) throws URISyntaxException, IOException {
//	    log.debug("REST request to save User : {}", userDTO);
//	    
//	    if (profileImage != null && !profileImage.isEmpty()) {
//	        // Upload to Google Drive and get URL
//	        String imageUrl = googleDriveService.uploadFile(profileImage);
//	        userDTO.setProfileImage(imageUrl);
//	    }
//	    
//	    UserDTO result = userService.save(userDTO);
//	    return result;
//	}

	@PutMapping("/tbl-users")
	public UserDTO updateTblUser(@RequestBody UserDTO userDTO) throws URISyntaxException {
		log.debug("REST request to update User : {}", userDTO);
		UserDTO result = userService.save(userDTO);
		return result;
	}

	@GetMapping("/tbl-users")
	public List<UserDTO> getAllTblUsers() {
		log.debug("REST request to get all Users");
		return userService.findAll();
	}

	@GetMapping("/tbl-users/{id}")
	public Optional<UserDTO> getTblUser(@PathVariable String id) {
		log.debug("REST request to get TblUser : {}", id);
		return userService.findOne(id);
	}

	@DeleteMapping("/tbl-users/{id}")
	public void deleteUser(@PathVariable String id) {
		log.debug("REST request to delete TblUser : {}", id);
		userService.delete(id);
	}
	
	 @PostMapping("/upload")
	    public String uploadFile(@RequestParam("file") MultipartFile file ,@PathVariable String id ) throws Exception {
	        userService.imageUploadFileUser(file,id);
	        return "File uploaded successfully. Google Drive File ID: " ;
	    }
	

}
