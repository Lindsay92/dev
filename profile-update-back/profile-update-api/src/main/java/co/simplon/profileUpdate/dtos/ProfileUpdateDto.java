package co.simplon.profileUpdate.dtos;

import org.springframework.web.multipart.MultipartFile;

import co.simplon.profileUpdate.customValidation.FileSize;
import co.simplon.profileUpdate.customValidation.FileType;

public class ProfileUpdateDto {

    private String description;

    @FileType
    @FileSize
    private MultipartFile avatar;

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public MultipartFile getAvatar() {
	return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
	this.avatar = avatar;
    }

    @Override
    public String toString() {
	return " {description=" + description + ", avatar=" + avatar + "}";
    }

}
