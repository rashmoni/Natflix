package com.novare.natflix.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Date;
/**
 * This class is not used anymore but keeping the code for future reference
 *
 */
public class FileHandler {
    public static String saveData(String base64Value, String type){
        String base64Image = base64Value.substring(22);
        byte[] imageData = Base64.getDecoder().decode(base64Image);
        String fileName = new Date().getTime()+".png";
        String imageUrl = "/images/"+type+"/"+fileName;

        String filepath = "/Users/rashmonidey/Desktop/Natflix-frontend-main/public/images/"+type+"/"+fileName;
        try
        {
            FileOutputStream fos = new FileOutputStream(new File(filepath));
            fos.write(imageData);
        }
        catch (Exception e)
        {
            System.err.println("Couldn't write to file..."+e);
        }
        return imageUrl;
    }
}
