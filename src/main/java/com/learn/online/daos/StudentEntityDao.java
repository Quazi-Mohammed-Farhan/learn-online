package com.learn.online.daos;

import java.util.Optional;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.learn.online.beans.StudentEntity;

@Repository 
public interface StudentEntityDao extends JpaRepository<StudentEntity, Long> {
	
  @Modifying(flushAutomatically = true)	
  @Query(nativeQuery = true,   value = "update com.learn.online.beans.StudentEntity s set s.firstName= :studentEntity.firstName, "
  		+ "s.lastName= :studentEntity.lastName, s.email= :studentEntity.email, "
  		+ "s.encryptedPassword= :studentEntity.encryptedPassword, s.phone= :studentEntity.phone, "
  		+ "s.country= :studentEntity.country, s.state= :studentEntity.state, "
  		+ "s.active= :studentEntity.active where s.email = :studentEntity.email"
  	)	
  public Optional<StudentEntity> updateStudent(StudentEntity studentEntity);

  public Optional<StudentEntity> findByEmail(String email); 
  public Optional<StudentEntity> findByStudentKey(String sudentKey);
}
 