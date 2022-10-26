package com.novare.natflix.Service;

import com.novare.natflix.Entity.Content;
import com.novare.natflix.Repository.ContentRepository;
import com.novare.natflix.utils.ImageHandler;
import com.novare.natflix.utils.StorageService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {
    public final ImageHandler imageHandler;
    private final ContentRepository contentRepository;
    private StorageService storageService;

    @Autowired
    public ContentService(ContentRepository contentRepository, StorageService storageService) {
        this.contentRepository = contentRepository;
        this.storageService = storageService;
        imageHandler = new ImageHandler(storageService);
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

    private List<Content> getItems(String category) {
        List<Content> AllContents = getContents();
        Long contentId;
        if (category == "movies") {
            contentId = 2L;
        } else if (category == "series") {
            contentId = 1L;
        } else contentId = 3L;

        return AllContents.stream()
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
        String logoBase64String = ((String) payload.get("logo_url"));
        String logoURL = imageHandler.getImageUrl(logoBase64String);

        String bannerBase64String = ((String) payload.get("banner_url"));
        String bannerURL = imageHandler.getImageUrl(bannerBase64String);

        String thumbnailBase64String = ((String) payload.get("thumbnail_url"));
        String thumbNailURL = imageHandler.getImageUrl(thumbnailBase64String);

        Content content = Content.builder()
                .title(title)
                .summary(summary)
                .logo_url(logoURL)
                .banner_url(bannerURL)
                .thumbnail_url(thumbNailURL)
                .category_id(Long.valueOf(contentCategory))
                .type_id(Long.valueOf(contentType))
                .build();
        contentRepository.save(content);
    }

    public void deleteContent(Long id) {
        boolean exists = contentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("id does not exists");
        }
        contentRepository.deleteById(id);
    }

    @Transactional
    public void updateContent(JSONObject payload) {

        Long id = ((Integer) payload.get("id")).longValue();

        Content content = contentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Content with id" + id + "does not exist"));

        //Normal data
        String title = (String) payload.get("title");
        String summary = (String) payload.get("summary");
        long contentCategory = ((Integer) payload.get("category_id")).longValue();
        long contentType = ((Integer) payload.get("type_id")).longValue();

        //Image data
        String logoBase64String = ((String) payload.get("logo_url"));
        String logoURL = imageHandler.getImageUrl(logoBase64String);

        String bannerBase64String = ((String) payload.get("banner_url"));
        String bannerURL = imageHandler.getImageUrl(bannerBase64String);

        String thumbnailBase64String = ((String) payload.get("thumbnail_url"));
        String thumbNailURL = imageHandler.getImageUrl(thumbnailBase64String);

        content.setTitle(title);
        content.setSummary(summary);
        content.setCategory_id(contentCategory);
        content.setType_id(contentType);

        content.setLogo_url(logoURL);
        content.setBanner_url(bannerURL);
        content.setThumbnail_url(thumbNailURL);

    }
}



