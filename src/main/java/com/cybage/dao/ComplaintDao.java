package com.cybage.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cybage.model.Complaint;

public interface ComplaintDao extends JpaRepository<Complaint, Integer>  {

}

