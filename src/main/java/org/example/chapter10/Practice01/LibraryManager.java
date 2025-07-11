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
    public void listAll() {
        // 전체 조회: isEmpty()로 요소값 존재 여부 확인에 따라 로직 처리
        if(items.isEmpty()) {
            System.out.println("No Items is the library");
        } else {
            System.out.println(" == Library Items ==");
            for(Item item: items) {
                item.display();
            }
        }
    }

    @Override
    public void updateStock(String id, int quantity) {
        for(Item item: items) {
//            item.updateStock(quantity);
            if(item.getId().equals(id) && item instanceof Book) {
//                Book selectedBook = (Book)item;

                ((Book) item).updateStock(quantity);
//                selectedBook.updateStock(quantity);

                System.out.println("Stock updated for ID: " + id + ", Stock: " + ((Book)item).getStock());
//                System.out.println("Stock updated for ID: " + id + ", Stock: " + selectedBook.getStock());
            }
        }
    }

    @Override
    public void remove(String id) {
//        삭제 여부 확인용 boolean 데이터
        boolean removed = false;
        
//        인덱스 번호를 사용하여 요소 제거
//        : 일반 for문을 초기화 변수 == 인덱스 번호
        int size = items.size();
        for(int i = 0; i < size; i++) {
//            전체 items를 순회: 각 순번의 item의 id와 매개변수의 id가 일치한다면 해당 인덱스 요소를 제거
            if(items.get(i).getId().equals(id)) {
                items.remove(i);
                removed = true;
                System.out.println("Item with ID: " + id + " removed");
                break;
            }
        }

        if(!removed) {
            System.out.println("No Item found with ID: " + id);
        }
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
