package com.maxnguyen.fooddelivery.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    boolean saveFile(MultipartFile file);
    Resource loadFile(String fileName);
}
