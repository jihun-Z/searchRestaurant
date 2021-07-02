package com.example.searchrestaurant.wishList.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishListServiceTest {
    @Autowired
    private WishListService wishListService;

    @Test
    public void searchTest(){
        var result=wishListService.search("분식집");
        System.out.println(result);
        Assertions.assertNotNull(result); //검색 결과가 null이면 안된다는 조건을 달아줌
    }

}