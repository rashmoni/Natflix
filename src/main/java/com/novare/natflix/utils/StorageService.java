package com.novare.natflix.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

@Service
@Slf4j
public class StorageService {
    @Value("${s3.bucket.name}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3Client;
    public String uploadFile(byte[] image) {
        String FILEPATH = "image";
        File file = new File(FILEPATH);
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(image);
            os.close();
        } catch (Exception e) {
            log.error("Error converting byte to file", e);
        }
        String fileName = System.currentTimeMillis() + ".png";

        s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
        file.delete();
        URL url = s3Client.getUrl(bucketName, fileName);
        return url.toString();
    }
}