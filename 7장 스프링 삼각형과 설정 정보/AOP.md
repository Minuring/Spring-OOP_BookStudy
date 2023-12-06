# 7장 스프링 삼각형과 설정 정보

## 📝 정리 - AOP - 로직 주입

### 횡단 관심사

- 코드 = 핵심 관심사 + 횡단 관심사
- 횡단 관심사 : 다수의 모듈에 공통적으로 나타나는 부분
- **AOP는 횡단 관심사를 런타임에 주입한다.** 메서드는 핵심 관심사에만 신경쓰면 된다.

> AOP는 인터페이스 기반이다.<br>
> AOP는 프록시 기반이다.<br>
> AOP는 런타임 기반이다.<br>


- `@Aspect`  이 클래스를 이제 AOP에서 사용하겠다 (횡단 관심사 처리하는 클래스)
    의존 대상이 외부에 있도록(외부에서 의존 대상을 주입하도록) 하는 것이 목적이다.


- `Pointcut`  "어디에?" Aspect 적용 위치 지정자. 횡단 관심사를 적용할 타깃 메서드를 선택하는 지시자
  - ex) public void aop002.Boy.runSomething()
    : 접근제한자가 public이고, 리턴타입이 void이고, aop002 패키지의 Boy클래스 안에,
    파라미터가 없으며, 에러가 있든 없든, 이름이 runSomething()인 메서드(들)을 Pointcut으로 지정하라.
  
  - ex) * runSomething()
    : 접근제한자 *, 리턴타입 *, 모든패키지, 모든클래스, 파라미터 없으며, 에러가 있든없든,
    이름이 runSomething()인 메서드(들)을 Pointcut으로 지정하라.

  - JoinPoint의 부분 집합
  - Advice가 적용될 **위치** 필터


- `JoinPoint`  Aspect 적용이 가능한 모든 지점
  - 광의의 JoinPoint : 스프링이 관리하는 빈의 모든 **메서드**
  - 협의의 JoinPoint : 호출된 객체의 메서드 ( 실제 호출된 메서드 )


- `Advice`  "언제? 무엇을?"
  - Pointcut에 적용할 로직. 메서드. + "언제" 를 정의
  - `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around` (앞 4가지 다)
  - 실질적인 부가 기능 로직


- `Aspect`  "언제? 어디에? 무엇을?"
  - Aspect = Advice들 + Pointcut들 

    
### 요약
```
Spring AOP는 모든 JoinPoint들 중 Pointcut 으로 지정한 타겟 메서드에,
Advice (언제,무엇을) 를 결합하여 모듈화해서 Aspect로 정의한다.

런타임에 AOP Proxy를 통해 Aspect에서 정의된 동작을 수행한다.
(Pointcut에 해당하는 JoinPoint에서 Advice를 실행한다)
```