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
>具体示例代码：**com.starfall.enumeration.test.StatusEnumTest**
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