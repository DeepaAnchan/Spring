package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Image;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	private ImageRepository imageRepository;
	
	@Override
	public List<Image> getAllImages() {
		// TODO Auto-generated method stub
		return imageRepository.findAll();
	}

}
