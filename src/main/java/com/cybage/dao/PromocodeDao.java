package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Promocode;

public interface PromocodeDao extends JpaRepository<Promocode, Integer> {

}
