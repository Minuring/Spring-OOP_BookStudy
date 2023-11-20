/*
Car의 확장에 닫혀있다.
운전 방식이 확장됨에 따라 Driver를 변경해야한다.
변경에 열려있고, 확장에 닫혀있다.
 */
class Driver{
    Car car;
    void 운전하기(){
        if (car instanceof 수동기어차량){
            car.기어수동조작();
        }else{
            car.기어자동조작();
        }
    };
}
class 수동기어차량{
    void 기어수동조작(){};
}
class 자동기어차량{
    void 기어자동조작(){};
}

/*
운전 방식이 확장되어도 Driver를 수정할 필요가 없다.
Driver는 차량 종류가 바뀌어도 운전하기()만 하면 된다.
운전 방식의 확장에 열려있고, 수정에 닫혀있다.
 */

class Driver{
    Car car;
    void 운전하기() {
        car.기어조작();
    }
}
abstract class Car{
    abstract void 기어조작();
}
class 수동기어차량 extends Car{
    void 기어조작(){
        //기어수동조작
    }
}
class 자동기어차량 extends Car{
    void 기어조작(){
        //자동기어조작
    }
}