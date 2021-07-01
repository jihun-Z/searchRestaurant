package com.example.searchrestaurant.wishList.repository;

import com.example.searchrestaurant.db.MemoryDbRepositoryAbstract;
import com.example.searchrestaurant.wishList.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}
