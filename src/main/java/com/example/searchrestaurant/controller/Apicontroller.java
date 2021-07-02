package com.example.searchrestaurant.controller;

import com.example.searchrestaurant.wishList.dto.WishListDto;
import com.example.searchrestaurant.wishList.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/restaurnat")
@RequiredArgsConstructor
public class Apicontroller {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestParam WishListDto wishListDto){
        log.info("{}",wishListDto);
        return wishListService.add(wishListDto);
    }
    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }
    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
      wishListService.delete(index);

    }
    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }

}
