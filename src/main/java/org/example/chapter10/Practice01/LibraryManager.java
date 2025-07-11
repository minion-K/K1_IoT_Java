package org.example.chapter10.Practice01;

import java.util.ArrayList;
import java.util.List;

// 실제 도서 관리 기능을 수행(관리할 행동을 실질적 구현)
public class LibraryManager implements Manageable{
//    책 저장 공간 (ArrayList - 중복 가능O, 순서 O / 빠른 조회 가능)
    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void updateStock(String id, int quantity) {

    }

    @Override
    public void listAll() {

    }

    @Override
    public List<Item> search(String keyword) {
        return List.of();
    }

    @Override
    public List<Item> searchByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Item> searchByPrice(int minPrice, int MaxPrice) {
        return List.of();
    }
}
