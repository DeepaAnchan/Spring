package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AlbumRepository;
import com.example.demo.entity.Album;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;

	@Override
	public List<Album> getAllAlbums() {
		// TODO Auto-generated method stub
		return albumRepository.findAll();
	}

}
