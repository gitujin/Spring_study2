package hello.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드
    public void order(String name, int price){
        //주문할때 가격을 저장
        System.out.println("name = " + name + "price = " + price);
        this.price = price; //여기가 문제
    }

    public int getPrice(){
        return price;
    }
}
