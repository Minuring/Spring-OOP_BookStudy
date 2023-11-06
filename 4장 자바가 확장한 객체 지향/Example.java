/*
예시 : 상품에 쿠폰을 적용해서 할인되는 액수를 구해주는 기능을 구현하는 상황
Coupon 클래스에서 Item클래스의 값을 구한 뒤 할인되는 금액을 계산 할 수 있다.
 */
public class Coupon {
    public int calculateDiscountAmount(Item item){
        return item.getPrice() * discountRate;
    }
}
/*
그런데 할인이 절대 적용되지 않는 특수한 아이템이 생겼다.
그래서 아이템이 그 특수한 아이템인지 판별하는 코드를 넣었다고 하면,
아래 경우가 대표적인 LSP 위반 사례이다.

왜냐하면 하위타입인 SpecialItem이 상위타입인 Item을 완벽하게 대체하고있지 않기 때문이다.
SpecialItem같은 하위타입이 생길 때마다 수정해야할 가능성이 생긴다.
결국 개방 폐쇄 원칙(클래스는 오직 한 가지 이유만으로 수정해야한다.) 또한 어기게 된다.

이는 Item에대한 추상화가 덜 되었기 때문이다.
이 상황에서 변화되는 부분은 >>상품의 가격 할인 가능 여부<< 이다.
이를 Item 클래스에서 추상화하면 해결할 수 있다.
 */
public class Coupon {
    public int calculateDiscountAmount(Item item){
        if(item instanceof SpecialItem){
            return 0;
        }

        return item.getPrice() * discountRate;
    }
}
/*
Item 클래스에서 isDiscountAvailable()을 true를 반환한다.
SpecialItem 클래스는 isDiscountAvailable()을 false를 반환하도록 오버라이딩한다.
그러면 SpecialItem 클래스 외에도 특별한 할인처리가 필요한 클래스가 오더라도
item클래스에서 변화되는 부분을 처리하면 LSP를 지킬 수 있게 된다.
 */
public class Item{
    public boolean isDiscountAvailable() {
        return true;
    }
}
public class SpecialItem extends Item{
    public boolean isDiscountAvailable(){
        return false;
    }
}
public class Coupon{
    public int calculateDiscountAmount(Item item){
        if(! item.isDiscountAvailable() ){
            return 0;
        }
        return item.getPrice() * discountRate;
    }
}