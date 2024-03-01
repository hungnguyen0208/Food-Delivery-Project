package com.maxnguyen.fooddelivery.service;

import com.maxnguyen.fooddelivery.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceImp {
    @Value("${fileUpload.rootPath}")
    private String rootPath;
    private Path root;
    private void init(){
        try{
            root = Paths.get(rootPath);
            if(Files.notExists(root)){
                Files.createDirectories(root);
            }
        }catch (Exception e){
            System.out.println("Fail to create folder root: " + e.getMessage());
        }
    }
    @Override
    public boolean saveFile(MultipartFile file) {
        try{
            init();
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        }catch (Exception e){
            System.out.println("Fail to save file: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource loadFile(String fileName) {
        try{
            init();
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()){
                return resource;
            }
        }catch (Exception e){
            System.out.println("Fail to load file: " + e.getMessage());
        }
        return null;
    }
}
