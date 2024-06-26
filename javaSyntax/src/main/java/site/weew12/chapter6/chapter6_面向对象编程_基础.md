## 第06章 面向对象编程（基础）

---
**学习面向对象内容的三条主线**

- Java类以及类的成员：`属性`、`方法`、`构造器`；`代码块`、`内部类`
- 面向对象的特征：`封装`、`继承`、`多态`、（抽象）
- 关键字的使用：`this`、`super`、`package`、`import`、`static`、`final`、`interface`、`abstract`等

---

### 1. 面向对象编程思想的理解

#### 程序设计方法

面向对象是软件开发中的一种编程风格、开发范式。     
除了面向对象，还有面向过程、指令式编程、函数式编程。

#### 面向过程与面向对象设计思想

**面向过程的程序设计思想（Process-Oriented Programming） POP**       
`过程`就是操作数据的步骤，如果某个过程的实现代码重复出现，那么可以把这个过程`抽取封装为一个函数`，这样可以大大简化冗余的代码、便于维护。
典型的代表就是`C语言`，代码结构：`以函数为组织单位`，是一种`“执行者思维”`
、适合解决简单问题，但是`拓展能力差、后期维护难度较大`。

**面向对象的程序设计思想（Object-Oriented Programming） OOP**             
关注的焦点是`类`，计算机程序设计过程中，参照现实世界的事务，`将事务的属性特征、行为特征抽象出来`，用类来表示。       
典型的代表有：`Java、C#、C++、Python`等，代码结构：`以类为组织单位`，每种事物都具备自己的`属性`和`行为/功能`
，是一种`“设计者思维”`，`适合解决复杂的问题，代码扩展性强、可维护性高。`

**从实际问题考虑如何程序设计**

*1. 用面向过程的思维思考如何开车的问题？*        
首先思考“怎么按步骤实现？”，并将步骤对应成方法，一步接着一步，到最终完成，适合简单、不需要协作的事务，重点关注如何执行，如下图：      
![img.png](img.png)

*2. 用面向对象的思维思考如何造车的问题？*             
造车很复杂，需要很多协作才能完成，首先思考“车是怎么设计的？”，而不是“怎么按照特定的步骤造车”。

分析车的构成，然后再分析各个构成的细节以及他们之间的关系/交互（即：对应类的属性和方法），这其中也包含了面向过程的思维。      
![img_1.png](img_1.png)

面向对象可以帮助我们从宏观上把握、从整体上分析整个系统，但是具体到实现部分的微观操作（一个个方法），仍然需要面向过程的思路去处理，面向对象与面向过程是相辅相成的。

#### OOP的基本元素：类、对象

**什么是类？**       
具有相同特征的事物的抽象描述，是抽象的、概念上的定义。

**什么是对象？**          
实际存在的该类事物的每个个体，是具体的，也称为实例（instance）。

*举例：*
用人类做比方：类-》抽象的人 对象-》具体的某个人      
![img_2.png](img_2.png)

### 2. 类的成员与实例化

#### 理解类的成员：属性、方法

Java中用`类class`来描述事务。类是一组相关`属性`和`行为`的集合，这也是类最基本的两个成员。

- 属性
    - 该类`事物的状态信息`，对应类中的`成员变量`。
    - 成员变量 -- 属性 -- `field`
- 行为
    - 该类事物要`做什么操作`或基于事物的状态`能做什么`，对应类中的`成员方法`。
    - （成员）方法 -- 函数 -- `method`

![img_3.png](img_3.png)

#### 类的定义

使用的关键字：`class`      
格式：

```java
[修饰符]

class 类名 {
    属性声明;
    方法声明;
}
```     

代码举例：

```java
public class Person {
    //声明属性age
    int age;

    //声明方法showAge()
    public void eat() {
        System.out.println("人吃饭");
    }
}
```     

#### 类的实例化/对象的创建

创建对象，使用关键字：`new`        
创建对象的语法：

- ```java
    // 把创建对象的引用赋值给一个类变量，后面就可以通过这个变量反复使用这个对象了
    类名 对象名 = new 类名();
  ```
- ```java
    // 又称为匿名对象
    new 类名();
  ```

代码举例：

```java
class PersonTest {
    public static void main(String[] args) {
        //创建Person类的对象
        Person per = new Person();
        //创建Dog类的对象
        Dog dog = new Dog();
    }
}
```     

#### 对象调用属性或方法

对象是类的一个实例，必然具备该类事物的属性和行为（方法）。       
使用：“`对象名.属性`”或“`对象名.方法`”的方式访问对象成员（包括属性和方法）。

代码举例：

```java
//声明Animal类
public class Animal {
    //动物类
    public int legs;

    public void eat() {
        System.out.println("Eating.");
    }

    public void move() {
        System.out.println("Move.");
    }
}

//声明测试类
public class AnimalTest {
    public static void main(String args[]) {
        //创建对象
        Animal xb = new Animal();
        //访问属性
        xb.legs = 4;
        System.out.println(xb.legs);
        //访问方法
        xb.eat();
        //访问方法
        xb.move();
    }
}
```             

图示：     
![img_4.png](img_4.png)

#### 匿名对象

我们可以`不定义对象的句柄`，new 实例化这个类对象然后直接调用这个对象的方法，这样的对象叫做匿名对象。

例如：

```java
new Person().shout()
```

使用情况：

- 如果一个`对象只需要进行一次方法调用`，那么就可以使用匿名对象。
- 经常`将匿名对象作为实参`传递给一个方法调用。

### 3. 对象的内存解析

#### JVM内存结构划分

`HotSpot Java虚拟机`的架构图如下所示，关于内存划分主要关注的是`运行时数据区`部分（Runtime-Data Area）。

![img_5.png](img_5.png)

其中：     
`堆（Heap）`，此内存区域的唯一目的就是存放对象实例，几乎所有对象实例都是在这里分配内存。Java虚拟机规范中的相关描述：“**
所有的对象实例以及数组都要在堆上分配。**”        
`栈（Stack）`，指`虚拟机栈`
，其用于存储局部变量等。局部变量表存放了编译期可知长度的各种基本数据类型、对象引用（reference，不等同于对象本身，是对象在堆内存的首地址），方法执行完后自动释放。       
`方法区（Method Area）`，`用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器（JIT）编译后的代码等数据`。

#### 对象内存解析

测试代码：

```java
//类：人
class Person {
    String name;
    int age;
    boolean isMale;
}

//测试类
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "赵同学";
        p1.age = 20;
        p1.isMale = true;

        Person p2 = new Person();
        p2.age = 10;

        Person p3 = p1;
        p3.name = "郭同学";
    }
}
```     

内存解析：

![img_6.png](img_6.png)

**注意：**

- 凡是`new`出来的结构（`对象、数组`）都存放在`堆空间`中。
- `对象的属性`存放在`堆空间`中。
- 创建一个`类的多个对象`（p1、p2），则每个对象都拥有当前类的一套`“副本”`（即属性），当通过一个对象修改其属性时，不会影响其他对象的此属性的值。
- 当声明一个新的变量使用现有的对象进行赋值时（p3 =
  p1），此时并未在对空间中创建新的对象，而是`两个变量共同指向了堆空间中同一个对象`，当通过p3修改对象的属性时，会影响另外一个对象此属性的值。

**面试题：对象名存储的是什么？**      
答案：对象地址。

解析：直接打印对象名或数组名都是显示`“类型@对象的hashCode值”`
，因此类、数组都是引用数据类型，`引用数据类型的变量中存储的是对象的地址`，或者说是指向`堆中对象的首地址`。

![img_7.png](img_7.png)

### 4. 类的成员之一：成员变量

#### 声明成员变量

语法格式：

```java
[修饰符1]

class 类名 {
    [修饰符2]
    数据类型 成员变量名[ = 初始化值];
}
```     

**说明：**

- 声明位置要求：必须在类中，方法外。
- 修饰符2
    - 常用的权限修饰符有：`private`、缺省、`protected`、`public`
    - 其他修饰符：`static`、`final`
- 数据类型
    - 任何基本数据类型或任何引用数据类型
- 成员变量名
    - 属于标识符、符合命名规则和规范即可。
- 初始化值
    - 显式赋值或不赋值使用默认值

代码样例：

```java
public class Person {
    //声明private变量 age
    private int age;
    //声明public变量 name
    public String name = “Lila”;
}
```

#### 成员变量与局部变量的对比

**变量的分类：**

- `成员变量`
    - 在方法体外，类体内声明的变量
- `局部变量`
    - 在方法体内部等位置声明的变量

![img_8.png](img_8.png)

**static修饰的变量可以将成员变量分为两大类：**

- 静态变量
    - 又称为类变量
- 非静态变量
    - 又称为实例变量或属性

![img_9.png](img_9.png)

**成员变量与局部变量的对比**

- 相同点
    - 声明格式相同：`数据类型 变量名 = 初始化值;`
    - 变量先声明、后初始化、再使用
    - *变量都有其对应的作用域，只在其作用域有效。*
- 不同点
    - **声明位置和方式**
      -
            1. 实例变量 在类方法外
        -
            2. 局部变量 在方法体{}中或方法的形式参数、代码块中
    - **在内存中存储的位置**
      -
            1. 实例变量 堆
        -
            2. 局部变量 栈
    - **生命周期**
      -
            1. 实例变量 随对象的创建而存在，随着对象被GC回收而消亡，每个对象的实例变量是独立的。
        -
            2. 局部变量 每一次方法调用而存在，随着方法执行的结束而消亡，每一次方法调用都是独立的。
    - **作用域**
      -
            1. 实例变量 通过对象就可以使用，本类中直接调用，其他类中“对象.实例变量”
        -
            2. 局部变量 除了作用域就不能使用
    - **修饰符**
      -
            1. 实例变量 public、protected、private、final、volatile、transient等
        -
            2. 局部变量 final
    - **默认值**
      -
            1. 实例变量 有默认值
        -
            2. 局部变量 没有，必须手动初始化，其中形参必须靠实参给它初始化

**对象属性的默认初始化值**       
当一个对象被创建时，会对其中各种类型的成员变量自动进行初始化赋值。       
![img_10.png](img_10.png)

### 5. 类的成员之二：方法

#### 方法（methods、函数）的理解

方法是类或对象`行为特征的抽象`，用来`完成每个功能操作`，在某些语言中也称为`函数`或`过程`。       
将功能封装为方法的`目的`：实现`代码重用`、`减少冗余`、`简化代码`。         
*Java中的方法不能独立存在，所有的方法必须定义在类里。*

#### 方法声明的语法

**语法格式**

```java
[修饰符]返回值类型 方法名([形参列表])[throws 异常列表]{
        方法体的功能代码
        }
```       

**一个完整的方法 = 方法头 + 方法体**

- 方法头
    - `方法头`即：`[修饰符] 返回值类型 方法名([形参列表])[throws 异常列表]`，也称为`方法签名`
      ，通常调用方法时只需要关注方法头就可以，从方法头可以看出这个方法的功能和调用格式。
    - 方法头可能包含的5个部分
        - 修饰符（可选），有：public、protected、private、static、abstract、native、final、synchronized等。
        - 返回值类型，表示方法运行的结果的数据类型，方法执行后将结果返回到调用者。
            - 无返回值，则声明为：void
            - 有返回值，则声明出返回值类型（可以是任意类型），与方法体中的`return 返回值`搭配使用。
        - 方法名，属于标识符，命名时遵循标识符命名规则和规范，见名知意。
        - 形参列表，表示完成方法体功能时需要外部提供的参数列表，可以包含零个、一个或多个参数。
            - 无论是否有参数，`()`不能缺省。
            - 如果有参数，每个参数都要指定数据类型和参数名，多个参数之间使用逗号分隔
            - 参数类型可以是基本数据类型、引用数据类型
        - throws异常列表：可选，主要是指定抛出的异常类型。
- 方法体
    - `方法体`就是方法被调用之后需要执行的代码。
    - 用`{}`括起来，在其中编写完成功能的代码。
    - `return`语句
        - return语句的作用是结束方法的执行，并将方法的结果返回去
        - 如果返回值不是void，方法体中必须保证一定有return返回值，并且要求该返回值结果的类型与声明的返回值类型一致或兼容。
        - 如果返回值是void时，方法体中可以没有return语句，如果需要提前结束方法的执行，那么可以直接使用return，这回是的方法在此结束，此后的语句将不再执行。

#### 方法的调用方式

通过方法名被调用，只有被调用才会执行方法体中的代码。

**方法调用语法格式**

```java
对象.方法名([实参列表])
```   

代码样例：

```java
//1、创建Scanner的对象
//System.in默认代表键盘输入
Scanner input=new Scanner(System.in);

//2、提示输入xx
//对象.非静态方法(实参列表)
        System.out.print("请输入一个整数：");

//3、接收输入内容
//对象.非静态方法()
        int num=input.nextInt();  
```     

*方法使用的注意点：*

- 先声明后使用，方法必须定义在类的内部
- 调用一次就执行一次，不调用不执行
- 方法中可以调用类中的方法或属性，不可以在方法内部定义方法。

#### return关键字

return关键字在方法中的作用：

- 结束一个方法
- 结束一个方法的同时，返回数据给方法的调用者

#### 方法调用的内存分析

- **方法没有被调用的时候，都在方法区中的字节码文件（.class）中存储。**
- 方法被调用时，需要进入`栈内存`中运行，`方法每调用一次就会在栈中有一个入栈和出栈的动作`
  ：给当前方法`开辟一块独立的内存区域，用于存储当前方法的局部变量的值`。
- 方法执行结束之后，会释放该内存，成为`出栈`，如果该方法有返回值，就会把结果返回调用出；如果没有返回值，则直接结束，回到调用处继续执行下一条指令。
- 栈结构：先进后出，后进先出。

代码样例：

```java
public class Person {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

    }

    public static void eat() {
        sleep();
        System.out.println("人：吃饭");
    }

    public static void sleep() {
        System.out.println("人：睡觉");
        doSport();
    }

    public static void doSport() {
        System.out.println("人：运动");
    }
}
```     

上面代码对应的内存分析：        
![img_11.png](img_11.png)

### 6. 对象数组的使用

数组的元素可以是基本数据类型，也可以是引用数据类型。当元素是引用类型中的类时，我们称为对象数组。

代码样例：

```java
/*
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 */
public class Student {
    //学号
    int number;
    //年级
    int state;
    //成绩
    int score;


    public void info() {
        System.out.println("number : " + number
                + ",state : " + state + ",score : " + score);
    }

}

public class StudentTest {
    public static void main(String[] args) {
        // 数组的创建
        Student[] students = new Student[20];
        // 通过循环结构给数组的属性赋值
        for (int i = 0; i < students.length; i++) {
            // 数组元素的赋值
            students[i] = new Student();
            // 数组元素是一个对象，给对象的各个属性赋值
            students[i].number = (i + 1);
            // [1,6]
            students[i].state = (int) (Math.random() * 6 + 1);
            // [0,100]
            students[i].score = (int) (Math.random() * 101);
        }
    }
}
```

内存解析：       
![img_12.png](img_12.png)

**注意点：**        
**对象数组，首先要创建数组对象本身，即：确定数组的长度，然后再创建每一个元素对象，如果不创建，数组元素的默认值就是`null`
，很容易出现使用不当导致`空指针异常：NullPointerException`。**

### 7. 方法的重载

**方法重载**      
同一个类中，允许`存在一个以上的同名方法`，只要它们的`参数列表不同`即可。        
*参数列表不同，意味着参数个数或者参数的类型的不同。*

#### 重载的特点

与修饰符、返回值类型无关，`只看参数列表`，且`参数列表必须不同`。（参数个数或参数类型），调用时根据参数列表的不同来区别。

#### 重载方法调用

JVM通过方法的参数列表，调用匹配的方法。

-
    1. **先找个数、类型最匹配的**
-
    2. **再找个数和类型可以兼容的，如果同时满足多个方法可以兼容将会报错。**

代码示例：

-
    1. `System.out.println()`方法就是典型的重载方法，其内部声明的形式如下：

```java
public class PrintStream {
    public void println(byte x)

    public void println(short x)

    public void println(int x)

    public void println(long x)

    public void println(float x)

    public void println(double x)

    public void println(char x)

    public void println(double x)

    public void println()
}

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(3);
        System.out.println(1.2f);
        System.out.println("hello!");
    }
}
```

-
    2. 返回整数的和

```java
//返回两个整数的和
public int add(int x,int y){
        return x+y;
        }

//返回三个整数的和
public int add(int x,int y,int z){
        return x+y+z;
        }

//返回两个小数的和
public double add(double x,double y){
        return x+y;
        }
```

### 8. 可变个数形参的方法

在JDK5中提供了Varargs(variable number of arguments)即：可变个数的参数机制。        
当定义一个方法时，**形参的类型可以确定，但是参数的个数不确定**，那么可以考虑使用可变个数的形参。

*使用格式*

```java
方法名(参数的类型名...参数名)
```

*代码举例*

```java
//JDK 5.0以前：采用数组形参来定义方法，传入多个同一类型变量
public static void test(int a,String[]books);

//JDK 5.0：采用可变个数形参来定义方法，传入多个同一类型变量
public static void test(int a,String...books);
```

**特点**

- 可变参数：方法参数部分指定类型的参数个数是可变多个：0个、1个或多个
- 可变参数形参的方法与同名的方法之间，彼此构成重载
- **可变参数方法的使用与方法参数部分使用数组是一致的，二者不能同时声明，否则报错。**
- 方法的参数部分有可变形参，需要放在形参声明的最后
- 在一个方法的形参中，最多只能声明一个可变个数的形参

*代码样例*

```java
// n个整数求和
public class NumberTools {
    public int total(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int sum(int... nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

public class TestVarParam {
    public static void main(String[] args) {
        NumberTools tools = new NumberTools();
        //0个实参
        System.out.println(tools.sum());
        //1个实参
        System.out.println(tools.sum(5));
        //4个实参
        System.out.println(tools.sum(5, 6, 2, 4));
        //传入数组实参
        System.out.println(tools.sum(new int[]{5, 6, 2, 4}));
        
        System.out.println("------------------------------------");
        //0个元素的数组
        System.out.println(tools.total(new int[]{}));
        //1个元素的数组
        System.out.println(tools.total(new int[]{5}));
        //传入数组实参
        System.out.println(tools.total(new int[]{5, 6, 2, 4}));
    }
}
```

### 9. 方法的值传递机制             

#### 形参与实参              

*形参（formal parameter）*              
在定义方法时，方法名后面括号`()`中声明的变量称为形式参数，简称：形参。

*实参（actual parameter）*              
在调用方法时，方法名后面括号`()`中使用的值/变量/表达式称为实际参数，简称：实参。

#### 参数传递机制：值传递         

Java里方法的参数传递方式只有一种：*值传递*。即：将实际参数值的副本（复制品）传入方法中，而参数本身不受影响。           

- `形参是基本数据类型`，将实参基本数据类型变量的“`数据值`”传递给形参。
- `形参是引用数据类型`，将实参引用数据类型变量的“地址值”传递给形参。

*代码举例：形参是基本数据类型*        
```java
// 案例：编写方法，交换两个整型变量的值
// 注意：此处的交换是无效的，并不会变更原有的变量的值
public class Test {
	public static void main(String[] args) {
        int m = 10;
        int n = 20;
        
        System.out.println("m = " + m + ", n = " + n);
        
        //交换m和n的值
        //		int temp = m;
        //		m = n;
        //		n = temp;
        
        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m, n);
        
        System.out.println("m = " + m + ", n = " + n);
	}
	
	public void swap(int m,int n){
		int temp = m;
		m = n;
		n = temp;
	}
	
}
```         
内存解析：       
![img_13.png](img_13.png)           

*代码举例：形参是引用数据类型*        
```java
public class Test {
	public static void main(String[] args) {
            Data d1 = new Data();
            d1.m = 10;
            d1.n = 20;
            
            System.out.println("m = " + d1.m + ", n = " + d1.n);
            
            //实现 换序
            ValueTransferTest2 test = new ValueTransferTest2();
            test.swap(d1);	
            System.out.println("m = " + d1.m + ", n = " + d1.n);
	}
	public void swap(Data data){
            int temp = data.m;
            data.m = data.n;
            data.n = temp;
	}
}

class Data{
	int m;
	int n;
}
```         
内存解析：       
![img_14.png](img_14.png)           

*练习题：*              
![img_15.png](img_15.png)       

*题解：*
- 法一
    ```java
    public static void method(int a, int b) {
        // 在不改变原本题目的前提下，如何写这个函数才能在main函数中输出a=100，b=200？ 
        a = a * 10;
        b = b * 20;
        System.out.println(a);
        System.out.println(b);
        System.exit(0);
    }
    ```

- 法二
```java
    public static void method(int a, int b) {

        PrintStream ps = new PrintStream(System.out) {
            @Override
            public void println(String x) {

                if ("a=10".equals(x)) {
                    x = "a=100";
                } else if ("b=10".equals(x)) {
                    x = "b=200";
                }
                super.println(x);
            }
        };

        System.setOut(ps);

    }
```

### 10. 递归方法        

**递归方法调用**          
方法自己调用自己的现象就称为`递归`。         

**递归的分类**       
- 直接递归
  - 方法自己调用自己
    ```java
     public void methodA(){
        methodA();
     }
    ```
- 简介递归
  - 可以理解为A()方法调用B()方法，B()方法调用C()方法，C()方法调用A()方法。
    ```java
     public static void A(){
        B();
     }
     
     public static void B(){
        C();
     }
     
     public static void C(){
        A();
     }
    ```

**说明**          
- 递归方法包含了一种隐式的循环
- 递归方法会重复的执行某段代码，但这种重复执行无须循环控制
- **递归一定要向已知方向递归，否则这种递归就变成了无穷递归，停不下来，类似于死循环，最终会导致*栈内存溢出***

**代码举例（计算1~n的和）：**           
```java
public class RecursionDemo {
	public static void main(String[] args) {
            RecursionDemo demo = new RecursionDemo();
            //计算1~num的和，使用递归完成
            int num = 5;
            // 调用求和的方法
            int sum = demo.getSum(num);
            // 输出结果
            System.out.println(sum);
	}
    
  	/*
  	  通过递归算法实现.
  	  参数列表:int 
  	  返回值类型: int 
  	*/
	public int getSum(int num) {
            /* 
               num为1时,方法返回1,
               相当于是方法的出口,num总有是1的情况
            */
            if(num == 1){
                return 1;
            }
            /*
              num不为1时,方法返回 num +(num-1)的累和
              递归调用getSum方法
            */
            return num + getSum(num-1);
	}
}
```         
*上述代码的执行图解：*        
![img_16.png](img_16.png)               

**说明：**             
- 递归调用会占用大量的系统堆栈，内存消耗大，在递归调用层次多时速度要比循环慢的多，所以需要谨慎使用。
- 在要求高性能的情况下尽量避免使用递归，递归调用即花费时间又消耗内存，考虑使用循环迭代。

### 11. package与import关键字       

#### package(包)             

`package`称为包，用于指明该文件中定义的类、接口等结构所在的包。            

*语法格式*          
`package 顶层报名.子包名;`         

*举例：pack1\pack2\PackageTest.java*               
```java
//指定类PackageTest属于包pack1.pack2
package pack1.pack2;    

public class PackageTest{
    public void display(){
        System.out.println("in  method display()"); 
    }
}
```             

**说明**              
- `一个源文件只能有一个`声明包的package语句
- package语句作为Java源文件的第一条语句出现，若缺省该语句，则自定为无报名。
- 包名属标识符，满足标识符命名的规则和规范（全部小写）、见名知意
  - 包通常使用所在公司的域名的倒置：com.XXX.xxx
  - **取包名时不要使用`java.xx`作为包名**
- 包对应于文件系统的目录，package语句中用`“.”`来指明包（目录）的层次，每`.`一次就表示一层文件目录。
- 同一个包下可以声明多个结构（类、接口），但是不能定义同名的结构（类、接口），不同的包下可以定义同名的结构（类、接口）。

**包的作用**        
- 包可以包含类和子包，划分项目层次，便于管理
- 帮助管理大型软件系统：将功能相近的类划分到同一个包中。
- 解决类命名冲突的问题。
- 控制访问权限

**JDK中主要的包介绍**      
- `java.lang`
  - 包含一些Java语言的核心类，如：`String`、`Math`、`Integer`、`System`、`Thread`等等。
- `java.net`
  - 包含执行与网络相关的操作的类和接口。
- `java.io`
  - 包含提供多种输入、输出功能的类。
- `java.util`
  - 包含一些使用工具类，如定义：系统特性、接口的集合框架类、使用与日期时间日历相关的函数。
- `java.text`
  - 包含了一些Java格式化相关的类。
- `java.sql`
  - 包含了Java进行JDBC数据库编程的相关类、接口。
- `java.awt`
  - 包含了构成抽象窗口工具集的多个类，这些类被用来构建和管理应用程序的图形界面（GUI）。

#### import(导入)             

为了使用定义在其他包中的Java类，需用**import语句来显示引入指定包下所需要的类，相当于import语句告诉编译器到哪里去寻找这个类。**           

**语法格式**        
```java
import 包名.类名;
```
**代码举例**        
```java
//import pack1.pack2.*;表示引入pack1.pack2包中的所有结构
import pack1.pack2.Test;   

public class PackTest{
	public static void main(String args[]){
            //Test类在pack1.pack2包中定义
            Test t = new Test();          
            t.display();
	}
}
```     

**注意事项**        
- import语句，声明在包的声明和类的声明之间
- 如果需要导入多个类或接口，那么就并列声明多个import语句即可
- 如果使用import a.*导入结构，表示可以导入a包下的所有的结构。
- **如果导入的类或接口是java.lang包下的，或者是当前包下的，则可以省略此import语句**
- **如果已经导入java.a包下的类，那么如果需要使用a包的子包下的类的话，任然需要导入**
- **如果在代码中使用不同包下的同名的类，那么就需要使用类的全类名方式指定调用的是哪个类**
- **`import static`组合的使用：调用指定类或接口下的静态的属性或方法**

### 12. 面向对象特征之一：封装性（encapsulation）             

**为什么需要封装？**        
随着软件系统越来越复杂，类会越来越多，类之间的访问边界必须把握好，面向对象的开发原则要遵循“高内聚、低耦合”。         
- **内聚**，指一个模块内各个元素彼此结合的紧密程度。
- **耦合**，值一个软件结构内不同模块之间互连程度的度量。

内聚意味着重用和独立，耦合意味着多米诺效应牵一发动全身。        

“高内聚，低耦合”的体现之一：             
- 高内聚：类的内部数据操作细节自己完成，不允许外部干涉
- 低耦合：仅暴露少量的方法给外部使用，尽量方便外部调用

**何为封装性？**      
就是将客观事物封装成抽象概念的类，并且类可以把自己的数据和方法只向可信的类或者对象开放，向没必要开放的类或者对象隐藏信息。               
通俗地理解就是：把该隐藏的就隐藏起来，该暴露的暴露出来，这就是封装性的设计思想。            

**Java如何实现数据封装？**       
- 实现封装就是`控制类或成员的可见性范围`，这就需要依赖访问控制修饰符/`权限修饰符`来控制。
- 权限修饰符：public、protected、缺省、private，具体访问范围如下：

    |    修饰符    |本类内部|本包内|其他包的子类|其他包的非子类|
    |:---------:|:---:|:---:|:---:|:---:|
    |  private  |√|×|×|×|
    |    缺省     |√|√|×|×|
    | protected |√|√|√|×|
    |  public   |√|√|√|√|

- 权限修饰符具体修饰的结构：
  - 外部类：public、缺省
  - 成员变量、成员方法、构造器、成员内部类：public/protected/缺省/private

    ![img_17.png](img_17.png)    

**封装性的体现**              

*成员变量/属性私有化*        

私有化类的成员变量，提供公共的get和set方法，对外暴露获取和修改属性的功能。
1. 使用private修饰成员变量
  ```java
  public class Person {
      private String name;
      private int age;
      private boolean marry;
  }
  ```
2. 提供getXxx方法/setXxx方法，可以访问成员变量
  ```java
  public class Person {
      private String name;
      private int age;
      private boolean marry;
        
      public void setName(String n) {
          name = n;
      }
        
      public String getName() {
          return name;
      }
        
      public void setAge(int a) {
          age = a;
      }
        
      public int getAge() {
          return age;
      }
        
      public void setMarry(boolean m){
          marry = m;
      }
        
      public boolean isMarry(){
          return marry;
      }
  }
  ```
3. 测试
  ```java
  public class PersonTest {
      public static void main(String[] args) {
          Person p = new Person();
    
          //实例变量私有化，跨类是无法直接使用的
          /* p.name = "张三";
          p.age = 23;
          p.marry = true;*/
    
          p.setName("张三");
          System.out.println("p.name = " + p.getName());
    
          p.setAge(23);
          System.out.println("p.age = " + p.getAge());
    
          p.setMarry(true);
          System.out.println("p.marry = " + p.isMarry());
      }
  }
  ```

**成员变量封装的好处**           
- 让使用者只能通过事先预定的方法访问数据，从而可以在该方法里面加入控制逻辑，限制对成员变量的不合理访问；还可以进行数据检查，从而有利于保证对象信息的完整性。
- 便于修改，提高代码的可维护性。主要是指的隐藏的部分，在内部修改了，如果其对外提供的访问方式不变的话，外部根本感觉不到它的修改。


*私有化方法*         

// TODO 略       

### 13. 类的成员之三：构造器（Constructor）         

当我们new完对象时，所有成员变量都是默认值，如果我们需要赋别的值，需要挨个为它们赋值，比较麻烦，因此Java提供了构造器（Constructor）/构造方法，让我们在new对象时，直接为当前对象的某个或所有成员变量直接赋值。       

#### 构造器的作用、格式              

new对象，并在new对象的时候为实例变量赋值。        
例如：`Person p = new Person("Peter", 15)`             

**语法格式**            
```java
[修饰符] class 类名{
    [修饰符] 构造器名(){
    	// 实例初始化代码
    }
    [修饰符] 构造器名(参数列表){
        // 实例初始化代码
    }
}
```         

**说明**          
- 构造器名必须与它所在的类名必须相同
- 构造器没有返回值，所以不需要返回值类型，也不需要void
- 构造器的修饰符只能是权限修饰符，不能被其他任何修饰。

**代码样例：**       
```java
public class Student {
    private String name;
    private int age;

    // 无参构造
    public Student() {}

    // 有参构造
    public Student(String n,int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int a) {
        age = a;
    }

    public String getInfo(){
        return "姓名：" + name +"，年龄：" + age;
    }
}

public class TestStudent {
    public static void main(String[] args) {
        //调用无参构造创建学生对象
        Student s1 = new Student();

        //调用有参构造创建学生对象
        Student s2 = new Student("张三",23);

        System.out.println(s1.getInfo());
        System.out.println(s2.getInfo());
    }
}
```         

**重点注意:**           

![img_18.png](img_18.png)       

- **当我们没有显示的声明类中的构造器时，系统会默认提供一个无参的构造器并且该构造器的修饰符默认和类的修饰符相同。**              
- **当我们显示的定义类的构造器以后，系统就不再提供默认的无参构造器了。**       
- **在类中，至少会存在一个构造器**
- **构造器时可以重载的**


### 14. 补充知识        

#### 在类中属性赋值的位置与过程     

在类的属性中，可以有哪些**位置**给属性赋值？        
1. 默认初始化
2. 显示初始化
3. 构造器中初始化
4. 通过“对象.属性”或“对象.方法”的方式，给属性赋值

上述赋值位置的**执行先后顺序**是怎么样的？     
`1 2 3 4`       

*说明*        
上述中的1、2、3在对象的创建过程中，只执行一次，4是在对象创建后执行的，可以根据需求多次执行。        

#### 何为JavaBean             

*JavaBean是一种Java语言写成的可重用组件。*                

*所谓JavaBean，是指符合如下标准的Java类*             
- 类是公共的
- 有一个无参的公共的构造器
- 有属性，且有对应get、set方法

*样例代码：*             
```java
 public class JavaBean {
    // 属性一般定义为private
    private String name; 
    private int age;
    
    public JavaBean() {
    }
    
    public int getAge() {
     return age;
    }
    
    public void setAge(int a) {
     age = a;
    }
    
    public String getName() {
     return name;
    }
    
    public void setName(String n) {
     name = n;
    }
 }
```             

#### 解读UML类图            
// TODO

![img_19.png](img_19.png)       

![img_20.png](img_20.png)           



