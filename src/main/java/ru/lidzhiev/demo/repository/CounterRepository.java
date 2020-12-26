package ru.lidzhiev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lidzhiev.demo.entity.Counter;

import javax.transaction.Transactional;

@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update Counter SET counter=?2 WHERE id = ?1",nativeQuery = true)
    void setCounter(Integer id, Integer addressId);
}
