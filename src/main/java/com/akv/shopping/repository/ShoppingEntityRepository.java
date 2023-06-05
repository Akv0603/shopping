package com.akv.shopping.repository;

import com.akv.shopping.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingEntityRepository extends JpaRepository<ShoppingItem, Integer> {
}
