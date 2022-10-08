package com.project_sms.studentapplication.repository;

import com.project_sms.studentapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByEmail(String email);
    List<Student> findByFirstName(String firstName);
    List<Student> findByLastName(String lastName);
    List<Student> findByRollNum(String id);
    List<Student> findByCity(String city);

    @Transactional
    @Modifying
    @Query("UPDATE Student SET city = :city WHERE rollNum = :rollNum")
    void updateCityByRollNum(String city, String rollNum);

    @Transactional
    @Modifying
    @Query("UPDATE Student SET firstName = :firstName WHERE rollNum = :rollNum")
    void updateFirstnameByRollNum(String firstName, String rollNum);

    @Transactional
    @Modifying
    @Query("UPDATE Student SET lastName = :lastName WHERE rollNum = :rollNum")
    void updateLastnameByRollNum(String lastName, String rollNum);

    @Transactional
    @Modifying
    @Query("UPDATE Student SET email = :email WHERE rollNum = :rollNum")
    void updateEmailByRollNum(String email, String rollNum);
}
