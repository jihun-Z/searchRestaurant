package com.example.searchrestaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchLocalRes {

    private String lastBuildDate;//검색 결과를 생성한 시간이다.
    private int total;//검색 결과 문서의 총 개수를 의미한다.
    private int start;//검색 결과 문서 중, 문서의 시작점을 의미한다.
    private int display;//검색된 검색 결과의 개수이다.
    private String title;//검색 결과 이미지의 제목을 나타낸다.
   // private String category;
    private List<SearchLocalitem> items;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchLocalitem{
        private String title;//제목
        private String link;//하이퍼텍스트link제공
        private String description;//기관명에 대한 설명
        private String category;
        private String telephone;//빈문자열 반환 과거에 제공되던
        private String address;//주소
        private String roadAddress;//도로명 주소
        private int mapx;//지도 api연동을위한 x좌표값
        private int mapy;//지도 api연동을 위한 y좌표값값


    }
}
