package com.spring.dto;
import org.springframework.web.multipart.MultipartFile;

public class UserDto {

    private String username;
    private String description;
    private MultipartFile filename;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFilename() {
        return filename;
    }

    public void setFilename(MultipartFile filename) {
        this.filename = filename;
    }
}
