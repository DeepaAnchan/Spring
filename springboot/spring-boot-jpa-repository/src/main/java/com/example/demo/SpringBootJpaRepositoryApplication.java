package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.dao.ImageRepository;
import com.example.demo.entity.Album;
import com.example.demo.entity.Image;

@SpringBootApplication
public class SpringBootJpaRepositoryApplication {

	private AlbumRepository albumRepository;
	private ImageRepository imageRepository;
	
	public SpringBootJpaRepositoryApplication(AlbumRepository albumRepository, ImageRepository imageRepository) {
		super();
		this.albumRepository = albumRepository;
		this.imageRepository = imageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRepositoryApplication.class, args);
	}
	
	
	@Component
	class ImageCommand implements CommandLineRunner
	{

		@Override
		public void run(String... args) throws Exception {
			
			List<Image> list=new ArrayList<Image>();
			
			Album tempAlbum=new Album();
			
			Image tempImage1=new Image();
			Image tempImage2=new Image();

			
			tempAlbum.setAlbum_name("Album 1");
			
			tempImage1.setImage_url("Image url 1");
			list.add(tempImage1);			
			tempImage1.setAlbum(tempAlbum);
			
			tempImage2.setImage_url("Image url 2");
			list.add(tempImage2);			
			tempImage2.setAlbum(tempAlbum);
			
			tempAlbum.setImages(list);
			
			albumRepository.save(tempAlbum);
			
			imageRepository.save(tempImage1);
			imageRepository.save(tempImage2);

			
		}
		
	}
	

}
