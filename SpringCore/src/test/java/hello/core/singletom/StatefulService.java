package hello.core.singletom;

public class StatefulService {

    // 상태를 유지하는 필드가 필요가 없다!!
//    private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;

        return price;
    }

    // 이건 필요가 없다.
//    public int getPrice(){
//        return price;
//    }
}

