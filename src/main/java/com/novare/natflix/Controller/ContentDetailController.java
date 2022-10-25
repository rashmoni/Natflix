package com.novare.natflix.Controller;

import com.novare.natflix.Entity.ContentDetails;
import com.novare.natflix.Service.ContentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ContentDetailController {

    public final ContentDetailService contentDetailService;

    @Autowired
    public ContentDetailController(ContentDetailService contentDetailService) {
        this.contentDetailService = contentDetailService;
    }

    @GetMapping(path ="/content/details/"+"{id}")
    public Optional<ContentDetails> getContentsbyID(@PathVariable("id") Long id) {
        return contentDetailService.getContentDetailsByID(id);
    }

    @GetMapping(path ="/content/details")
    public List<ContentDetails> getContent() {
        return contentDetailService.getContentDetails();
    }
}
