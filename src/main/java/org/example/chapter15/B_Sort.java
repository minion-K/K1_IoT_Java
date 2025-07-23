package org.example.chapter15;

/*
* 1. 불변성 데이터: Stream API 정렬 사용
*   목적) 원본 데이터 변경 X, 정렬된 새로운 리스트만 필요 시
*   EX) 클라이언트 응답용 DTO 리스트 정렬
* 
* 2. 원본 리스트 자체 정렬
*   - List.sort() || Collections.sort()
*   목적) 원본 리스트를 직접 수정해서 정렬 순서를 유지해야 하는 경우
*   EX) 캐시된 리스트, 재사용 리스트, 통계 계산용 리스트 등
*       >> 데이터베이스나 외부 API 에서 자주 조회되는 데이터를 미리 리스트에 저장해두고
*           , 필요 시 다시 원본을 가져오지 않고 빠르게 읽어오는 용도
* */


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
class Product {
    private int price;
}

@AllArgsConstructor
class Post {
    private String title;
}

class ProductRepository {
    List<Product> findAll() {
        return new ArrayList<>(List.of(
                new Product(15),
                new Product(10),
                new Product(20),
                new Product(21),
                new Product(9)
        ));
    }
}

class PostRepository {
//    DB SQL을 통해 정렬된 데이터를 반환하여 가져옴
    List<Post> cachedPopularPosts() {
        return new ArrayList<>(List.of(
            new Post("인기1"),
            new Post("인기2"),
            new Post("인기3"),
            new Post("인기4"),
            new Post("인기5")
        ));
    }
}

// 제품과 관련된 비즈니스 로직을 수행하는 클래스
// CRUD + 필터링/통계
// : 가격 기준으로 정렬 조회
class ProductService {
    ProductRepository productRepository = new ProductRepository();
//    생성
    void createProduct() {}
//    수정
    void updateProduct() {}
//    가격 기준으로 정렬된 새로운 리스트 반환(원본 Products는 변경되지 않음)
    List<Product> getProductsSortedByPrice() {
        List<Product> products = productRepository.findAll();
        
//        stream.sorted()는 중간 연산
//        : 원본을 그대로 두고, 가공된 결과를 생성
//        - 불변 데이터 처리에 유리, 클린 코드 작성에도 적합
        return products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}

class PostService {
    PostRepository postRepository = new PostRepository();
    private List<Post> cachedPopularPosts;
    
    public List<Post> getPopularPosts() {
        if(cachedPopularPosts == null) {
//            DB 에서 인기 게시글 조회
            cachedPopularPosts = postRepository.cachedPopularPosts();
        }
//        한 번 불러온 후 매번 DB 조회를 하지 않고 재사용
        return cachedPopularPosts;
    }
    
    public void refreshPopularPostsCache() {
//        필요할 때 갱신
        cachedPopularPosts = postRepository.cachedPopularPosts();
    }
}

public class B_Sort {
    public static void main(String[] args) {
        
    }
}
