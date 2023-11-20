/*
PayService는 구체적인 Pay인 SamsungPay에 의존한다.
SamsungPay가 고장나거나, 새로운 Pay인 KakaoPay가 추가되는 등의 변경이 있을때
PayService는 Pay에 큰 영향을 받고있다.
또, SamsungPay는 어떠한 것에도 의존하지 않고있고 오히려 PayService가 Pay에 의존중이다.
 */
class PayService{
    private SamsungPay pay;
    void setPay(SamsungPay pay){
        this.pay = pay;
    }
    void payment(){
        pay.payment();
    }
}
class SamsungPay{
    void payment(){
        //samsungPay pay
    }
}

/*
PayService는 Pay인터페이스에 의존한다.
(구체적인)SamsungPay에 의존하지 않고 (추상적인)인터페이스에 의존한다.
SamsungPay에서 KakaoPay,,로 변경되어도 PayService는 영향을 받지 않는다.
그 무엇에도 의존하지 않던 구체적인Pay는 인터페이스에 의존하게 되었다.
 */

class PayService{
    private Pay pay;
    void setPay(Pay pay){
        this.pay = pay;
    }
    void payment(){
        pay.payment();
    }
}
interface Pay{
    void payment();
}
class SamsungPay implements Pay{
    void payment(){
        //samsungPay pay
    }
}
class KakaoPay implements Pay{
    void payment(){
        //kakaoPay pay
    }
}