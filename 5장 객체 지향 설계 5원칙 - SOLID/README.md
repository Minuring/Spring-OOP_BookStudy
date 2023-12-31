# 5장 객체 지향 설계 5원칙 - SOLID

## 📝 정리

### 1. SRP - 단일 책임 원칙
> **어떤 클래스를 변경해야하는 이유는 오직 하나 뿐이어야 한다.**
- = 하나의 클래스는 하나의 역할과 책임을 진다.
- = 한 가지 책임에 관한 변경사항이 있을때만 코드를 수정하도록 설계한다.
- 관련된 동작(하나의 책임)을 묶어 응집도를 높이고, 결합도는 낮춘다.

### 2. OCP - 개방 폐쇄 원칙
> **소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에 대해서는 열려 있고 변경에 대해서는 닫혀있어야 한다.**
- **확장** : 새로운 변경 사항이 있을 때 유연하게 확장이 가능함
- **변경** : 직접 클래스 수정하는 것을 제한. 변경사항이 있어도 클래스 수정 X
- **추상화** 를 잘 해두었으면 OCP를 지킨 것

1. 변경(확장)될 것과 변하지 않을 것을 엄격히 구분한다.
2. 이 두 모듈이 만나는 지점에 추상화(추상클래스 or 인터페이스)를 정의한다.
3. 구현체에 의존하기보다 정의한 추상화에 의존하도록 코드를 작성 한다.

#### 3. LSP - 리스코프 치환 원칙
> **서브 타입은 언제나 자신의 기반 타입으로 교체할 수 있어야 한다.**
- 하위 클래스의 인스턴스는 상위 클래스의 인스턴스 역할을 하는 데 문제가 없어야한다.
- 계층도/조직도가 아닌 분류도 형태로(상속을 올바르게 활용해서) 설계하면 LSP를 지킨 것

### 4. ISP - 인터페이스 분리 원칙
> **클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안된다.**
- SRP와 ISP는 같은 문제에 대한 두 가지 다른 해결책
- 상위 클래스는 풍성할 수록 좋고, **인터페이스는 작을 수록 좋다.**
- 인터페이스는 그 역할에 충실한 최소한의 기능만 공개

### 5. DIP - 의존 역전 원칙
> **자신보다 변하기 쉬운 것에 의존하지 마라.**
- 구체적인 것이 추상화된 것에 의존해야한다.
- 추상화(추상클래스, 인터페이스)에 의존하도록 설계한다.
- 추상적인 것에 의존한다 = 확장에 열려있다. 이렇게 OCP와 함께 녹아있다.

### 6. 정리 - 객체 지향 세계와 SOLID
- 도구를 용도에 맞지 않게 사용할 수도 있다. 하지만 그 작업은 고될 수 밖에 없다.
- 도구를 용도에 맞게 올바르게 사용하는 법
  - = 객체 지향 언어를 이용해 객체 지향 프로그램을 올바르게 설계하는 것

- **결합도는 낮추고 응집도는 높이자**
  - 다른 모듈(클래스)간 상호 의존 정도. 관계의 끈끈함을 낮춘다.
  - 즉 다른 모듈에 대한 의존도라고 할 수도 있다.

  - 클래스의 메서드가 인스턴스 변수를 많이 사용하면 할수록 메서드와 클래스는 응집도가 높아진다.
  - 즉 한 클래스에서 서로 연관된 하나의 책임만을 위해 동작하는가? 와 비례함.

- **SoC** : 관심사의 분리
  - 한 모듈에는 **하나의 관심사**만 들어있어야 한다.

--- 

## 🎞 회고

지금까지 짜 왔던 코딩습관을 완전히 바꿔야겠다고 생각했다.

원칙 하나하나를 읽으면서 이때까지 작성했던 코드들이 정직하게 떠올랐다.

내가 짠 모든 코드들은 객체지향의 특성을 단 하나도 살리지 못했던 것 같다.

그리고, 이 원칙들을 잘 지킨 코드와 못 지킨 코드의 예시를 보면서 든 생각이,
5원칙은 서로서로 연관되어 있다는 것이다. 하나를 지키면 다른 원칙도 지킨 것이 되고, 그런 것 같다.

지금 당장 5원칙을 어떻게 지키며 짜야할 지 어렵겠지만, 이제부터 짜는 모든 코드는 SOLID원칙을 지키면서
짜야겠다고 다짐했다.
