package com.novare.natflix.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;


@Service
public class ImageHandler {
    private final StorageService storageService;

    @Autowired
    public ImageHandler(StorageService storageService) {
        this.storageService = storageService;
    }

    public String getImageUrl(String stringData) {
        boolean isBase64 = isBase64(stringData);
        int trimAtIndex = 22;
        String AWSFileUrl = null;

        if (isBase64) {
            String trimmeLogodBase64String = stringData.substring(trimAtIndex);
            byte[] logoImageData = Base64.getDecoder().decode(trimmeLogodBase64String);
            AWSFileUrl = storageService.uploadFile(logoImageData);
        }

        if (AWSFileUrl == null)
            return stringData;
        else return AWSFileUrl;
    }

    private boolean isBase64(String stringData) {
        String initial_string = stringData.substring(0, 21);

        if (initial_string.equals("data:image/png;base64")) {
           return true;
        }else
        return false;
    }
}
