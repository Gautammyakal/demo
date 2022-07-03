package com.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeRepository;
import com.app.dto.EmployeeDTO;
import com.app.entities.Employee;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	@Value("${file.upload.location}")
	private String baseFolder;
	// dep : emp dao i/f
	@Autowired
	private EmployeeRepository empRepo;
	// dep : Model mapper
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDTO storeImage(int empId, MultipartFile imageFile) throws IOException {
		// get emp dtls from emp id
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp Id"));
		// emp => persistent
		// get complete path to the file , to be stored
		String completePath = baseFolder + File.separator + imageFile.getOriginalFilename();
		System.out.println("complete path " + completePath);
		System.out.println("Copied no of bytes "
				+ Files.copy(imageFile.getInputStream(), Paths.get(completePath), StandardCopyOption.REPLACE_EXISTING));
		// save complete path to the image in db
		
		//In case of saving file in db : simply call : imageFile.getBytes() --> byte[] --call setter on emp !
		emp.setImagePath(completePath);// save complete path to the file in db
		return mapper.map(emp, EmployeeDTO.class);
	}

	@Override
	public byte[] restoreImage(int empId) throws IOException{
		// get emp dtls from emp id
		Employee emp = empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Emp Id"));
		// emp => persistent
		// get complete img path from db --> extract image contents n send it to the
		// caller
		String path = emp.getImagePath();
		System.out.println("img path " + path);
		//API of java.nio.file.Files class : public byte[] readAllBytes(Path path)
		return Files.readAllBytes(Paths.get(path));
		//in case of BLOB in DB --simply call emp.getImage() --> byte[] --> ret it to the caller!
	}

}
