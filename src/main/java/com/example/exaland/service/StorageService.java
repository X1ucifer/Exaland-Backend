package com.example.exaland.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.amazonaws.AmazonServiceException;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
@Slf4j
public class StorageService {
	
//	@Autowired
//	private AmazonS3Client awsS3Client;

    @Value("${application.bucket.name}")
    private String bucketName;
    
    @Value("${application.endpointUrl}")
    private String endpointUrl;

    @Autowired
    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) {
    	String fileUrl = "";
	
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
    	
        fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
        
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        
        s3Client
        .setObjectAcl(
          "zoho-xscc",
          fileName,
          CannedAccessControlList.PublicRead
        );
        
       
        fileObj.delete();
        
        URL url = s3Client.getUrl("zoho-xscc", fileName);
        return  url.toString();
    }

    
    public String uploadimage(MultipartFile multipartFile) {
    	String fileUrl = "";
    	String  status = null;
    	try {

    		//converting multipart file to file
    		File file = convertMultiPartToFile(multipartFile);

    		//filename
    		String fileName = multipartFile.getOriginalFilename();

    		fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;

    		status = uploadFileTos3bucket(fileName, file);
    		
    		 s3Client
 	        .setObjectAcl(
 	          "zoho-xscc",
 	          fileName,
 	          CannedAccessControlList.PublicRead
 	        );
 	      

    		file.delete();

    	} catch (Exception e) {

    		return "UploadController().uploadFile().Exception : " + e.getMessage();

    	}

    	return status + "" +s3Client.getUrl("zoho-xscc",  multipartFile.getOriginalFilename());
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
    	File convFile = new File(file.getOriginalFilename());
    	FileOutputStream fos = new FileOutputStream(convFile);
    	fos.write(file.getBytes());
    	fos.close();
    	return convFile;
    }


    private String uploadFileTos3bucket(String fileName, File file) {
    	try {
    		s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
    		 
    	       
    	}catch(AmazonServiceException e) {
    		return "uploadFileTos3bucket().Uploading failed :" + e.getMessage(); 
    	}
    	return "";
    }
    



    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }


    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }
        return convertedFile;
    }
}