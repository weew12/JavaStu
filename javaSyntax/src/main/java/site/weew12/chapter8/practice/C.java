package site.weew12.chapter8.practice;

interface A {
    int x = 0;
}
class B {
    int x = 1;
}
class C extends B implements A {
    public void pX() {
//        System.out.println(x);//错误含糊不清
        System.out.println(A.x);
    }
    public static void main(String[] args) {
        new C().pX();
    }
}