package com.birthday.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Wish {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank @Size(max=40) private String name;
    @NotBlank @Size(max=400) private String message;
    @Size(max=8) private String emoji = "✨";
    private LocalDateTime createdAt = LocalDateTime.now();
    public Wish() {}
    public Wish(String name, String message, String emoji) { this.name=name; this.message=message; this.emoji=(emoji == null || emoji.isBlank()) ? "✨" : emoji; }
    public Long getId(){return id;} public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getMessage(){return message;} public void setMessage(String message){this.message=message;}
    public String getEmoji(){return emoji;} public void setEmoji(String emoji){this.emoji=emoji;}
    public LocalDateTime getCreatedAt(){return createdAt;}
}
