public class Example {
    //1. JVM은 Example 클래스를 로드하며, java.lang패키지와
    //static 메서드인 main()메서드도 같이 로드한다.
    public static void main(String[] args){
        //main()메서드의 스택 프레임이 생기고 args 변수의 공간이 할당된다.
        int i = 10;
        //int i;
        //i = 10; 과 같다.
        //main()메서드 스택 프레임에 i의 저장공간이 할당되고 10이 들어간다.
        int k = 20;
        //main()메서드 스택 프레임에 k의 저장공간이 할당되고 20이 들어간다.

        if(i == 10) {
            //if(true)블럭의 스택프레임이 형성된다.
            int m = k + 5;
            //if(true)블럭 내에서의 흐름에서는 k변수가 존재하고, 접근이 가능하다.
            //if(true)블럭에 m의 저장공간이 할당되고 25가 들어간다.
            k = m;
            //변수 k에 25가 들어간다.
        } else {
            //스택프레임이 형성되지 않고, 메모리의 변화 상에서는
            //이 else블럭은 등장조차 하지 않는다.
            int p = k + 10;
            k = p;
        }
        //if(true)블럭의 스택프레임이 소멸된다.

        //k = m + p;
        //위 코드의 주석을 해제하면 에러가 난다.
        //if(true)블럭에서 만들었던 m변수는 if(true)블럭의
        //스택프레임이 소멸하면서 없어졌기 때문이다.
    }
}