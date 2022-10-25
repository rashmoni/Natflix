package com.novare.natflix.Controller;

import com.novare.natflix.Entity.ContentDetails;
import com.novare.natflix.Service.ContentDetailService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:3000/content/details/update/")
    @PutMapping(path ="/content/details/update")
    public ContentDetails updateContent(@RequestBody JSONObject payload) {
        return contentDetailService.updateContentDetail(payload);
    }
}
