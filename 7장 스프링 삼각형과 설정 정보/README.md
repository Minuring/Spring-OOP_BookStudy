# 7장 스프링 삼각형과 설정 정보

## 📝 정리 - IoC/DI - 제어의 역전 / 의존성 주입

### 의존성
> **프로그램에서 의존 관계는 new로 표현된다!**
<pre>
ex)
-- 의사 코드 --                              -- 자바 코드 --
운전자가 자동차를 생산한다.                     new Car();
자동차는 내부적으로 타이어를 생산한다.           new Tire();
</pre>
<small>자동차가 내부적으로 어떤 타이어를 사용할 지 고민한다.<br></small>
- **new**를 실행하는 Car와 Tire 사이에서 **Car가 Tire에 의존한다.**
- Car는 구체적인 Tire를 알아야 해당 객체를 생성할 수 있다.
- 의존성은 **new**다.

- "의존성이 있다."
- = 클래스 간에 의존 관계가 있다
- = 한 클래스가 바뀔 때 다른 클래스가 영향을 받는다
- &plus; 사실 변수에 값을 할당하는 모든 순간에 의존이 생긴다.<br>
    의존 대상이 외부에 있도록(외부에서 의존 대상을 주입하도록) 하는 것이 목적이다.

### 의존성 주입
**모듈(클래스) 외부에서 의존성을 주입한다**<br>
<small>ex) 자동차 내부에서 타이어를 생산하지 않고, 외부에서 생산한 타이어를 장착한다.<br>
운전자는 자동차를 구매하면서 어떤 타이어를 장착할 까 고민하고, 자동차는 타이어에 대한 고민을 하지 않는다.<br>
- Car는 그저 Tire인터페이스를 구현한 어떤 객체가 들어오기만 하면 정상적으로 작동한다.
- Car는 Tire에 대해 정확히 알지 않아도되고, 알지도 않는다.
- Tire의 확장에 열려있다.
</small>

1. 생성자를 통한 의존성 주입
- 객체 생성자의 파라미터로 객체를 주입한다.
2. 속성을 통한 의존성 주입
- 설정자 메서드를 통해 객체를 주입한다.
3. 스프링을 통한 의존성 주입 - XML 파일 사용
<pre>
ex)
-- 의사 코드 --                            -- 자바 코드 --
종합쇼핑몰 context                           ApplicationContext context = new ClassPathXmlApplicationContext("~.xml", Driver.class);
운전자가 종합 쇼핑몰에서 타이어를 구매한다.     Tire tire = (Tire)context.getBean("tire");
운전자가 종합 쇼핑몰에서 자동차를 구매한다.     Car car = (Car)context.getBean("car");       
운전자가 자동차에 타이어를 장착한다.           car.setTire(tire);
</pre>
- 종합 쇼핑몰 = 스프링 프레임워크
- 종합 쇼핑몰에 입점된 상품 정보 = XML파일 (bean태그)
  - `<bean id="tire" class="~~.KoreaTire"></bean>`
  - : "KoreaTire" 상품이 "tire"라는 이름으로 진열 되어있고, 구매(getBean)할 수 있다. 

<b>자동차의 타이어 브랜드를 변경할 때 그 무엇도 재컴파일/재배포하지 않아도 XML파일만 수정하면 된다.</b><br>
4. 스프링을 통한 의존성 주입 - XML에서 속성 주입
<pre>
ex)
-- 의사 코드 --
운전자가 종합 쇼핑몰에서 자동차를 구매 요청한다.       
종합 쇼핑몰은 자동차를 생산한다.
종합 쇼핑몰은 타이어를 생산한다.
종합 쇼핑몰은 자동차에 타이어를 장착한다.
종합 쇼핑몰은 운전자에게 자동차를 전달한다.
-- XML --
&lt;bean id="tire" class="~~Tire"&gt;&lt;/bean&gt;
&lt;bean id="car" class="Car"&gt;
    &lt;property name="tire" ref="tire"&gt;&lt;/property&gt;
&lt;/bean&gt;
-- 자바 코드 --
Car car = context.getBean("car", Car.class);
</pre>
- XML 파일의 bean태그 내에서 property 태그를 통해 속성을 주입
5. 스프링을 통한 의존성 주입 - **@Autowired**를 통한 속성 주입
<pre>의사 코드는 4번과 동일</pre>
- 설정자 메서드를 이용하지 않고도 설정 파일(XML)을 통해 스프링 프레임워크가 대신 속성을 주입
6. 스프링을 통한 의존성 주입 - **@Resource**를 통한 속성 주입
<pre>의사 코드는 4번과 동일</pre>
- 역할은 `@Autowired` 와 같지만 자바 표준 어노테이션

- **@Autowired** vs **@Resource**
<table>
    <tr><th>구분</th><th>@Autowired</th><th>@Resource</th></tr>
    <tr><td>출처</td><td>스프링 프레임워크</td><td>표준 자바</td></tr>
    <tr><td>검색방식</td><td>Type, Name</td><td>Name, Type</td></tr>
    <tr><td>특이사항</td><td>@Qualifier("") 협업</td><td>name 어트리뷰트</td></tr>
    <tr><td>byName 강제하기</td><td>@Autowired<br>@Qualifier("")</td><td>@Resource(name="")</td></tr>
</table>

- 저자는 자바 표준인 **@Resource**를 권장
- **@Resource** 는 bean 태그의 property 태그로 대체 권장
