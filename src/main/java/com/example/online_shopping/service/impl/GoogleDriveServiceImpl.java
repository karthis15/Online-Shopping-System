package com.example.online_shopping.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class GoogleDriveServiceImpl {

	private Drive drive;

	public void GoogleDriveService() throws Exception {
		InputStream credentialsStream = new ClassPathResource("credentials.json").getInputStream();

		GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream)
				.createScoped(Collections.singleton("https://www.googleapis.com/auth/drive"));

		this.drive = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(),
				new HttpCredentialsAdapter(credentials)).setApplicationName("DriveUploaderApp").build();
	}

	public String uploadFile(MultipartFile file) throws IOException {
		File fileMeta = new File();
		fileMeta.setName(file.getOriginalFilename());

		java.io.File tempFile = new java.io.File(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
		try (FileOutputStream fos = new FileOutputStream(tempFile)) {
			fos.write(file.getBytes());
		}

		FileContent content = new FileContent(file.getContentType(), tempFile);
		File uploadedFile = drive.files().create(fileMeta, content).setFields("id").execute();

		Permission permission = new Permission();
		permission.setType("anyone");
		permission.setRole("reader");
		drive.permissions().create(uploadedFile.getId(), permission).execute();

		return "https://drive.google.com/uc?id=" + uploadedFile.getId();
	}
}
