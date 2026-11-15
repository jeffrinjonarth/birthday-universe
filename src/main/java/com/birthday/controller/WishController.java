package com.birthday.controller;

import com.birthday.model.Wish;
import com.birthday.service.WishService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WishController {
    private final WishService wishes;
    public WishController(WishService wishes){this.wishes=wishes;}
    @GetMapping("/wishes") public List<Wish> all(){return wishes.all();}
    @PostMapping("/wishes") @ResponseStatus(HttpStatus.CREATED) public Wish add(@Valid @RequestBody Wish wish){
      if(wish.getName()==null || wish.getMessage()==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name and message are required");
      return wishes.add(wish);
    }
}
