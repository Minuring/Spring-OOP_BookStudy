/*
Book 클래스 : 책과 관련된 정보
책에 관한 정보와 Print 기능을 책임짐. (두 가지의 액터. 클래스 변경 요인이 책과 프린트)
Print 기능이 확장될 경우 Book클래스를 수정해야함
== Print 기능의 확장에 닫혀있음 (ORP까지 위반)
 */
public class Book {
    public String getTitle() {
        return "A Great Book";
    }

    public String getAuthor() {
        return "John Doe";
    }

    public void printCurrentPage() {
        System.out.println("current page content");
        //html 프린터를 넣고자 한다.
    }
}
/*
Book 클래스의 책임을 나눈다.
이제 다양한 출력 옵션이 생겨도 Book 클래스를 수정할 필요가 없어진다.
Printer 인터페이스를 각기 다르게 구현하면 되기때문
 */
public class Book {

    public String getTitle() {
        return "A Great Book";
    }

    public String getAuthor() {
        return "John Doe";
    }

    public void getCurrentPage() {
        System.out.println("current page content");
    }

}

public interface Printer {
    void printPage();
}

public class PlainTextPrinter implements Printer {

    public void printPage() {
        System.out.println("this is plain text printer");
    }

}

public class HtmlPrinter implements Printer {

    public void printPage() {
        System.out.println("this is html printer");
    }

}

