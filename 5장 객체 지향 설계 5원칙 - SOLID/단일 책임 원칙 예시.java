/*
Person 클래스는 말하기, 출근하기, 사격하기, 데이트하기의
여러가지 책임을 지고있다.
군인의 수정사항, 직장. 일에서의 수정사항, 연인에서의 수정사항이 있을 때
모두 Person클래스를 수정하게 된다.
 */
class Person {
    void 말하기(){};
    void 출근하기(){};
    void 사격하기(){};
    void 데이트하기(){};
}

/*
Person의 책임을 분리한다.
Worker는 일과 관련된 이유로만 Worker클래스를 수정하게되고,
Soldier는 사격하기, Boyfriend는 데이트하기의 책임만을 진다.
 */

abstract class Person {
    void 말하기(){
        // Speaking
    }
}
class Worker extends Person {
    void 일하기(){
        //일
    }
}
class Solider extends Person {
    void 사격하기(){
        //사격
    };
}
class Boyfriend extends Person {
    void 데이트하기(){
        //데이트
    }
}