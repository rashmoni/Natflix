package com.novare.natflix.Service;

import com.novare.natflix.Entity.Content;
import com.novare.natflix.Repository.ContentRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {
    private final ContentRepository contentRepository;
    private final StorageService storageService;
    @Autowired
    public ContentService(ContentRepository contentRepository, StorageService storageService) {
        this.contentRepository = contentRepository;
        this.storageService = storageService;
    }
    public List<Content> getContents() {
        return contentRepository.findAll();
    }
    public List<Content> getMovies() {
        return getItems("movies");
    }
    public List<Content> getSeries() {
        return getItems("series");
    }
    public List<Content> getDocumentaries() {
        return getItems("documentaries");
    }
    private List<Content> getItems(String category){
        List<Content> AllContents = getContents();
        Long contentId;
        if (category=="movies")
        {
            contentId = 2L;
        } else if (category=="series") {
            contentId = 1L;
        }
        else  contentId = 3L;

        return  AllContents.stream()
                .filter(content -> contentId.equals(content.getType_id()))
                .collect(Collectors.toList());
    }
    public void addNewContent(JSONObject payload) {

        //Normal data
        String title = (String) payload.get("title");
        String summary = (String) payload.get("summary");
        Integer contentCategory = (Integer) payload.get("category_id");
        Integer contentType = (Integer) payload.get("type_id");


        //Base64 encoded Image
        int trimAtIndex = 22;
        String logoBase64String = ((String) payload.get("logo_url"));
        String trimmeLogodBase64String = logoBase64String.substring(trimAtIndex);
        byte[] logoImageData = Base64.getDecoder().decode(trimmeLogodBase64String);
        String AWSlogoFileUrl = storageService.uploadFile(logoImageData);

        String bannerBase64String = ((String) payload.get("banner_url"));
        String trimmedBannerBase64String = bannerBase64String.substring(trimAtIndex);
        byte[] bannerImageData = Base64.getDecoder().decode(trimmedBannerBase64String);
        String AWSbannerFileUrl = storageService.uploadFile(bannerImageData);

        String thumbnailBase64String = ((String) payload.get("thumbnail_url"));
        String trimmedThumbnailBase64String = thumbnailBase64String.substring(trimAtIndex);
        byte[] thumbnailImageData = Base64.getDecoder().decode(trimmedThumbnailBase64String);
        String AWSthumbnailFileUrl = storageService.uploadFile(thumbnailImageData);

        Content content = Content.builder()
                .title(title)
                .summary(summary)
                .logo_url(AWSlogoFileUrl)
                .banner_url(AWSbannerFileUrl)
                .thumbnail_url(AWSthumbnailFileUrl)
                .category_id(Long.valueOf(contentCategory))
                .type_id(Long.valueOf(contentType))
                .build();

        contentRepository.save(content);
    }

}
