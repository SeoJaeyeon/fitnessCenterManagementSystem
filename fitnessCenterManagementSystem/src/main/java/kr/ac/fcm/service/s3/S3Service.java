package kr.ac.fcm.service.s3;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
	public String getFileURL(String bucketName, String fileName);
	public String upload(MultipartFile multipartFile, String dirName, String tr_id) throws IOException;
	public void deleteFile(String filename);
	public String getBucket();
}
