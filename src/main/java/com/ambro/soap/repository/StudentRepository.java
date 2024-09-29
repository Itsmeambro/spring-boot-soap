package com.ambro.soap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ambro.soap.entity.Student;

import jakarta.persistence.Query;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByName(String name);
	
	

}
