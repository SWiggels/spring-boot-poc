package com.tasc.golden.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasc.golden.poc.entity.Client;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long> {

}
