package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Offers;
@Repository
public interface OffersRepository extends JpaRepository<Offers, Integer>{

}
