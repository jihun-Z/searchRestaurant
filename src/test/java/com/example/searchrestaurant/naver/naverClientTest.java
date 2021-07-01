package com.example.searchrestaurant.naver;

import com.example.searchrestaurant.naver.dto.SearchImageReq;
import com.example.searchrestaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class naverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest(){
        var search=new SearchLocalReq();
        search.setQuery("갈비집");

        var result=naverClient.localSearch(search);
        System.out.println(result);
        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());
    }
    @Test
    public void searchImageTest(){
        var search=new SearchImageReq();
        search.setQuery("갈비집");

        var result =naverClient.searchImage(search);
        System.out.println(result);
    }
}
