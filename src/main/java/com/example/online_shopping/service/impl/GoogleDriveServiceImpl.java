package com.example.online_shopping.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class GoogleDriveServiceImpl {

	private static final GsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

//	@Value("${google.drive.folder.id}")
	private String folderId = "1KU_Qv4Z_6moYNGvcp_NWTKFnAnjzs7u6"; 
//	@Value("${google.drive.credentials.path}")
	private String credentialsPath = "crud.json"; 
	public String uploadImageToDrive(MultipartFile file) {
		try {
			// Convert MultipartFile to temporary file
			Path tempFile = Files.createTempFile("drive-upload-", file.getOriginalFilename());
			Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

			Drive drive = createDriveService();

			// Use fully qualified class name for Drive's File
			com.google.api.services.drive.model.File fileMetadata = new com.google.api.services.drive.model.File();
			fileMetadata.setName(file.getOriginalFilename());
			fileMetadata.setParents(Collections.singletonList(folderId)); // Use injected folderId

			FileContent mediaContent = new FileContent(file.getContentType(), tempFile.toFile());

			com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetadata, mediaContent)
					.setFields("id").execute();

		//	String imageUrl = "https://drive.google.com/uc?export=view&id=" + uploadedFile.getId();

			Files.deleteIfExists(tempFile);
			return uploadedFile.getId();

		} catch (Exception e) {
			return "Error uploading file: " + e.getMessage();
		}
	}

	public String deleteImageFromDrive(String imageUrl) {
		try {
			String fileId = extractFileIdFromUrl(imageUrl);
			Drive drive = createDriveService();
			drive.files().delete(fileId).execute();
			return "File deleted successfully";
		} catch (Exception e) {
			return "Error deleting file: " + e.getMessage();
		}
	}

//	private Drive createDriveService() throws IOException, GeneralSecurityException {
//		// Use injected credentialsPath
//		GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(credentialsPath))
//				.createScoped(Collections.singletonList(DriveScopes.DRIVE));
//
//		return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY,
//				new HttpCredentialsAdapter(credentials)).build();
//	}
	
	private Drive createDriveService() throws IOException, GeneralSecurityException {
	    try (FileInputStream fis = new FileInputStream(credentialsPath)) {
	        GoogleCredentials credentials = GoogleCredentials
	                .fromStream(fis)
	                .createScoped(Collections.singletonList(DriveScopes.DRIVE));
	        return new Drive.Builder(
	                GoogleNetHttpTransport.newTrustedTransport(),
	                JSON_FACTORY,
	                new HttpCredentialsAdapter(credentials))
	                .build();
	    }
	}

	private String extractFileIdFromUrl(String url) {
		String[] parts = url.split("id=");
		if (parts.length < 2) {
			throw new IllegalArgumentException("Invalid Google Drive URL");
		}
		String fileId = parts[1];
		if (fileId.contains("&")) {
			fileId = fileId.substring(0, fileId.indexOf("&"));
		}
		return fileId;
	}
}
