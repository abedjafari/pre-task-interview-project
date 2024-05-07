package com.factory.warehouse.repository;

import com.factory.warehouse.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    Deal findByUniqueId(Long uniqueId);

}