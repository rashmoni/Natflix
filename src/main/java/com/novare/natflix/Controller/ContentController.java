package com.novare.natflix.Controller;

import com.novare.natflix.Entity.Content;
import com.novare.natflix.Service.ContentService;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api")
public class ContentController {

    public final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/content")
    public List<Content> getContents() {
        return contentService.getContents();
    }
    @GetMapping("/content/movies")
    public List<Content> getMovies() {
        return contentService.getMovies();
    }

    @GetMapping("/content/series")
    public List<Content> getSeries() {
        return contentService.getSeries();
    }


    @GetMapping("/content/documentaries")
    public List<Content> getDocumentaries() {
        return contentService.getDocumentaries();
    }

    @CrossOrigin(origins = "http://localhost:3000/admin-content/movies")
    @PostMapping(path = "/create")
    public String createMovie(@RequestBody JSONObject payload )  {
        contentService.addNewContent(payload);
        return "Successfully created new movie";
    }



}
