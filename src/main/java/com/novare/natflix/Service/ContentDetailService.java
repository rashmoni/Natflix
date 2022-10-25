package com.novare.natflix.Service;

import com.novare.natflix.Entity.ContentDetails;
import com.novare.natflix.Repository.ContentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
