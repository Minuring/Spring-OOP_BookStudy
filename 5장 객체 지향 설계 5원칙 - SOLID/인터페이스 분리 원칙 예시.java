/*
Car 클래스에 자동 주행 기능이 있다.
Tesla는 자동 주행 기능을 자신에 맞게 구현하면 되지만,
Matiz는 자동 주행 기능이 없음에도 상속관계에 의해 강제적으로 구현해야한다.
Matiz는 사용하지 않는 autoDrive()메서드를 가지고 있다.
 */
abstract class Car{
    abstract void autoDrive();
    void drive(){
        //일반 주행
    }
}
class Tesla extends Car{
    @Override
    void autoDrive() {
        //자동 주행
    }
}
class Matiz extends Car{
    @override
    void autoDrive() {
        //자동 주행 기능이 없지만 상속에 의해 구현해야만함
    }
}

/*
자동 주행 기능을 인터페이스로 만들고, 자동주행이 가능한 차량만
인터페이스를 구현하도록 제한한다.
Matiz는 사용하지도 않는 자동 주행 기능을 구현할 필요가 없어진다.
 */

abstract class Car{
    void drive(){
        //일반 주행
    }
}
interface autoDrivable{
    void autoDrive();
}
class Tesla extends Car implements autoDrivable{
    void autoDrive(){
        //자동 주행
    }
}
class Matiz extends Car{

}