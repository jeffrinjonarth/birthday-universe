package com.birthday.controller;
import com.birthday.service.MemoryService;
import com.birthday.model.Memory;
import com.birthday.model.GalleryItem;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class MemoryController {
 private final MemoryService service;
 public MemoryController(MemoryService service){this.service=service;}
 @GetMapping("/memories") public List<Memory> memories(){return service.memories();}
 @GetMapping("/gallery") public List<GalleryItem> gallery(){return service.gallery();}
}
