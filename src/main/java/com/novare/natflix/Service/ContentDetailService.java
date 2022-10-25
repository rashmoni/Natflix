package com.novare.natflix.Service;

import com.novare.natflix.Entity.ContentDetails;
import com.novare.natflix.Repository.ContentDetailRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContentDetailService {
    private final ContentDetailRepository contentDetailRepository;

    @Autowired
    public ContentDetailService(ContentDetailRepository contentDetailRepository) {
        this.contentDetailRepository = contentDetailRepository;
    }

    public Optional<ContentDetails> getContentDetailsByID(Long id) {
        return contentDetailRepository.findById(id);
    }

    public List<ContentDetails> getContentDetails() {
         return contentDetailRepository.findAll();
    }

    @Transactional
    public ContentDetails updateContentDetail(JSONObject payload) {
        Long id = ((Integer) payload.get("id")).longValue();
        Long content_id = ((Integer) payload.get("content_id")).longValue();
        String video_code = ((String) payload.get("video_code"));
        System.out.println(content_id);
        ContentDetails contentDetails = contentDetailRepository.findById(content_id)
                .orElseThrow(() -> new IllegalStateException("Content with id" + content_id + "does not exist"));

        contentDetails.setId(id);
        contentDetails.setVideo_code(video_code);
        return contentDetails;

    }
}
