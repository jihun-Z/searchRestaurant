package com.example.searchrestaurant.wishList.repository;

import com.example.searchrestaurant.wishList.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class wishListRepositoryTest {
    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishList=new WishListEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");

        wishList.setAddress("address");
        wishList.setRoadAddress("RoadAddress");
        wishList.setHomepageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisiDate(null);
        return wishList;
    }
    @Test
    public void saveTest(){
        var wishListEntity=create();
        var expected=wishListRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());

    }
    @Test
    public void updateTest(){
        var wishListEntity=create();
        var expected=wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity=wishListRepository.save(expected);
        Assertions.assertEquals("update Test",saveEntity.getTitle());
        Assertions.assertEquals(1,wishListRepository.listAll().size());


    }
    @Test
    public void findByIdTest(){
        var wishListEntity=create();
         wishListRepository.save(wishListEntity);
        var expected = wishListRepository.findById(1);
        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1, expected.get().getIndex());
    }
    @Test
    public void deleteTest(){
        var wishListEntity=create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);
        int count=wishListRepository.listAll().size();

        Assertions.assertEquals(0,count);
    }
    @Test
    public void listAllTest(){

        var wishListEntity=create();
        wishListRepository.save(wishListEntity);

        var wishListEntity2= create();
        wishListRepository.save(wishListEntity2);

        int count=wishListRepository.listAll().size();
        Assertions.assertEquals(2,count);
    }

}