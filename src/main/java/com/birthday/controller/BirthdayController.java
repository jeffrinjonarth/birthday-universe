package com.birthday.controller;

import com.birthday.service.MemoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BirthdayController {
    @Value("${birthday.name:Someone Extraordinary}") private String name;
    @Value("${birthday.date:2026-12-31}") private String date;
    @Value("${birthday.age:}") private String age;
    @Value("${birthday.message:May this year bring you beautiful surprises, unforgettable adventures, and every happiness you deserve.}") private String message;
    private final MemoryService memoryService;
    public BirthdayController(MemoryService memoryService){this.memoryService=memoryService;}
    @GetMapping("/") public String home(Model model){
      model.addAttribute("birthdayName",name); model.addAttribute("birthdayDate",date); model.addAttribute("birthdayAge",age);
      model.addAttribute("birthdayMessage",message); model.addAttribute("memories",memoryService.memories()); model.addAttribute("gallery",memoryService.gallery());
      return "index";
    }
}
