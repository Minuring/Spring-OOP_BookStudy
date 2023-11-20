/*
정사각형은 사각형이므로 정사각형을 사각형을 상속받는 형태로 설계했다.

이 때, 높이만 5를 증가시키는 행위를 하면, Square는 그 동작을 수행하지 못한다.
높이와 너비 모두 증가해버리기 때문이다.

즉 하위 클래스 Square는 상위 클래스 Rectangle의 역할 수행에 문제가 있다.

직사각형은 너비,높이를 독립적으로 설정할 수 있지만 정사각형은 항상 같아야한다.
즉 둘의 특성이 다르다.
따라서 정사각형은 직사각형의 자식이 되어서는 안된다.
 */
class Rectangle {
    private int width;
    private int height;
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return this.height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return this.width;
    }
    public int getArea() {
        return this.width * this.height;
    }
}
class Square extends Rectangle {
    @Override
    public void setHeight(int value) {
        this.width = value;
        this.height = value;
    }
    @Override
    public void setWidth(int value) {
        this.width = value;
        this.height = value;
    }
}
