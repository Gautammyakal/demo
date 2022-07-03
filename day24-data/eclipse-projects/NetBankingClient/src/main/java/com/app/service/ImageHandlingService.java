package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.EmployeeDTO;

public interface ImageHandlingService {

	EmployeeDTO storeImage(int empId, MultipartFile imageFile) throws IOException;

	byte[] restoreImage(int empId) throws IOException;

}
