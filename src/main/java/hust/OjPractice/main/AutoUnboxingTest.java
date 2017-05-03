package hust.OjPractice.main;
class AutoUnboxingTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);     //a 实际为指针地址，使用new关键字时，a指向一个新建的地址空间，而不是常量池空间
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
        
        //f1、f2指向同一常量池地址空间（-128-127），f3、f4分别需要使用 new一个新的堆空间
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }
}