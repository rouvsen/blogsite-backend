package com.rouvsen.blogwebsitebackend.image_upload.service;

import com.rouvsen.blogwebsitebackend.exception.ContextRuntimeException;
import com.rouvsen.blogwebsitebackend.exception.ImageFileNotFoundException;
import com.rouvsen.blogwebsitebackend.image_upload.domain.Image;
import com.rouvsen.blogwebsitebackend.image_upload.repository.ImageRepository;
import com.rouvsen.blogwebsitebackend.image_upload.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.zip.DataFormatException;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public String uploadImage(MultipartFile imageFile) throws IOException {
        String randomImageName = UUID.randomUUID().toString();
        var imageToSave = Image.builder()
                .name(randomImageName)
                .type(imageFile.getContentType())
                .imageData(ImageUtils.compressImage(imageFile.getBytes()))
                .build();
        imageRepository.save(imageToSave);
        return randomImageName;
    }

    public byte[] downloadImage(String imageName) {
        Optional<Image> dbImage = imageRepository.findByName(imageName);

        if (dbImage.isEmpty()) {
            throw new ImageFileNotFoundException("This image doesn't exist..");
        }

        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextRuntimeException(HttpStatus.NO_CONTENT.name(), exception);
            }
        }).orElse(null);
    }

}
