package com.birthday.service;

import com.birthday.model.Memory;
import com.birthday.model.GalleryItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemoryService {
    public List<Memory> memories(){return List.of(
      new Memory("THE BEGINNING", "A beautiful beginning", "Every unforgettable story starts with a moment worth keeping.", "/images/memory-1.jpg"),
      new Memory("THE LITTLE THINGS", "Moments that matter", "The laughter, the adventures, and the memories that became treasures.", "/images/memory-2.jpg"),
      new Memory("TODAY", "A new chapter", "Here's to everything wonderful still waiting to happen.", "/images/memory-3.jpg")
    );}
    public List<GalleryItem> gallery(){return List.of(
      new GalleryItem("https://images.unsplash.com/photo-151198-only?auto=format&fit=crop&w=900&q=80", "A moment to remember"),
      new GalleryItem("https://images.unsplash.com/photo-1511895426328-dc8714191300?auto=format&fit=crop&w=900&q=80", "Beautiful days"),
      new GalleryItem("https://images.unsplash.com/photo-1511632765486-a01980e01a18?auto=format&fit=crop&w=900&q=80", "Together in the moment")
    );}
}
