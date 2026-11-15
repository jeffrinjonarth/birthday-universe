package com.birthday.service;

import com.birthday.model.Wish;
import com.birthday.repository.WishRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishService {
    private final WishRepository repository;
    public WishService(WishRepository repository){this.repository=repository;}
    public List<Wish> all(){return repository.findAll(Sort.by(Sort.Direction.DESC,"createdAt"));}
    public Wish add(Wish wish){wish.setName(wish.getName().trim()); wish.setMessage(wish.getMessage().trim()); return repository.save(wish);}
}
