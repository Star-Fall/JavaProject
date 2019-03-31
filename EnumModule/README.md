# JAVA——枚举
#### 详情参看（右键打开）：[blog](https://blog.csdn.net/shaohe18362202126/article/details/86766999)
## 一、枚举基本用法
### 1、枚举示例
>具体示例代码：**com.starfall.enumeration.StatusEnum**
+ 自定义属性
```java
    /**
     * 状态代码
     */
    private final Integer code;
    
    /**
     * 状态信息
     */
    private final String msg;
```
---
+ 自定义构造函数
```java
    /**
     * 自定义的构造函数，传入属性
     *
     * @param code 状态代码
     * @param msg  状态信息
     */
    private StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
```
---
+ 抽象方法
```java
    /**
     * 自定义的抽象方法
     *
     * @return
     */
    public abstract String getStatusInfo();
```
---
+ 终极枚举对象形式
```java
    /**
     * 登录状态
     */
    LOGIN(100, "登录") {
        /**
         * 自定义的抽象方法需要在枚举对象中重写
         * @return
         */
        @Override
        public String getStatusInfo() {
            return this.getCode() + ":" + this.getMsg();
        }
    },
```
### 2、常用API
>具体测试代码：**com.starfall.enumeration.test.StatusEnumTest**
#### 2.1、API说明
+ **int compareTo(E o) ：** 比较此枚举与指定对象的顺序。
+ **Class<E> getDeclaringClass() ：** 返回与此枚举常量的枚举类型相对应的 Class 对象。
+ **boolean equals(Object other)：** 当指定对象等于此枚举常量时，返回true
+ **String name() ：** 返回此枚举常量的名称，在其枚举声明中对其进行声明。
+ **int ordinal() ：** 返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
+ **String toString()：** 返回枚举常量的名称，它包含在声明中。
+ **static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) ：** 返回带指定名称的指定枚举类型的枚举常量。
+ **Enum<E>[] values()：** 获取枚举类中的所有变量，并作为数组返回
+ **Enum<E> valuesOf(String arg)：** 据名称获取枚举变量

#### 2.2、获取所有的枚举对象
>+ values()方法和valueOf(String name)方法是我们具体实现的枚举StatusEnum中所包含的静态方法，在java.lang.Enum中是不包含values()方法的。
>+ 如果我们将枚举实例向上转型为Enum，那么values()方法将无法被调用
```java
    /**
     * 测试向上转型Enum，获取所以Enum对象
     */
    @Test
    public void testValues() {
        // 向上转型Enum
        Enum<StatusEnum> e = StatusEnum.LOGIN;
        // 获取class对象引用
        Class<?> clasz = e.getDeclaringClass();
        // Class<?> clasz = StatusEnum.class;
        if (clasz.isEnum()) {
            // 返回该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
            StatusEnum[] status = (StatusEnum[]) clasz.getEnumConstants();
            System.out.println(Arrays.toString(status));
        }
    }
```
#### 2.3、自定义的抽象方法
```java
    /**
     * 测试自定义的抽象方法
     */
    @Test
    public void testAbstract() {
        // 先获取所有枚举对象
        StatusEnum[] values = StatusEnum.values();
        // 遍历枚举对象
        for (StatusEnum en : values) {
            System.out.println(en.getStatusInfo());
        }
    }
```
## 二、枚举高级用法
>参考: https://blog.csdn.net/javazejian/article/details/71333103
### 1、枚举与接口
#### 示例
>具体示例代码：com.starfall.enumeration.interfaces.Food

+ 对一组数据进行分类总的食物菜单为Food类型，菜单下面一级分类为：appetizer(开胃菜)、mainCourse(主菜)、dessert(点心)、Coffee
+ 对于接口来说，枚举中的对象就是声明在接口中，各个枚举只是起到了分组的作用

#### 使用
>具体测试代码：com.starfall.enumeration.test.FoodTest


### 2、对接口的再次封装
对Food接口进一步的封装
>具体示例代码：com.starfall.enumeration.interfaces.Meal

>具体测试代码：com.starfall.enumeration.test.MealTest

## 三、EnumSet&&EnumMap
### 1、EnumSet
+ EnumSet是与枚举类型一起使用的专用 Set 集合，EnumSet 中所有元素都必须是枚举类型。与其他Set接口的实现类HashSet/TreeSet(内部都是用对应的HashMap/TreeMap实现的)不同的是，EnumSet在内部实现是位向量。
+ 注意EnumSet不允许使用 null 元素。试图插入 null 元素将抛出 NullPointerException，但试图测试判断是否存在null 元素或移除 null 元素则不会抛出异常，与大多数collection 实现一样，EnumSet不是线程安全的，因此在多线程环境下应该注意数据同步问题
>具体测试代码：com.starfall.enumeration.test.EnumPlusTest.testEnumSet()

### 2、EnumMap
+ EnumMap作为枚举的专属的集合，EnumMap要求其Key必须为Enum类型，EnumMap与HashMap相比效率更高，因为其内部是通过数组实现的。
+ EnumMap的key值不能为null，虽说是枚举专属集合，但其操作与一般的Map差不多。它只能接收同一枚举类型的实例作为键值且不能为null，由于枚举类型实例的数量相对固定并且有限，所以EnumMap使用数组来存放与枚举类型对应的值，毕竟数组是一段连续的内存空间，根据程序局部性原理，效率会相当高。

>具体测试代码：com.starfall.enumeration.test.EnumPlusTest.testEnumMap()