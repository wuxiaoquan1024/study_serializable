# study_serializable
Android 序列化

1.序列化与反序列化

2.Android 序列化的几种方式
    2.1 Serializable
        2.1.1 Serializable 介绍与使用
            Serializable 在Java中称为标记接口，并不需要实现任何方法。
            使用： 只需要实现Serializable 接口就可以实现序列化
            public class Man implements People, Serializable {

                public String name;

                private String fun;

                public Man() {
                    fun = "BB";
                }

            }
        2.1.2 原理


        2.1.3 注意事项及问题
            2.1.3.1 注意事项
                a. 对象如果有父类，并且父类没有实现Serializable. 那父类中的变量将不能被序列化
                b. 父类中非可见的变量不能够被序列化
                c. 对象中的static, transient修饰的变量将不会被序列化。 所有，如果希望变量不能被序列化，可以用transient修饰
                d. 对象中的变量除了基本数据类型，String， Enum, 数组类型外，必须也要实现Serializable。 不然抛出java.io.NotSerializableException异常
                e. 手动提供serialVersionUID. 不然在对象变量、方法、构造方法，发生变化后，无法进行反序列化，将抛出java.lang.IllegalStateException 异常。
                    serialVersionUID 保证对象不同版本之间的兼容，如果对象中没有提供，在序列化的时候，将根据变量、方法的生成. 手动设置后，变量，方法等发生变化
                    将兼容，不会影响反序列化
                f. 父类实现了Serializable 接口，子类自动可以序列化

            2.1.3.2 问题
                a. 效率底，速度慢。 根据2.1.2原理介绍的可以知道，序列化是通过反射与递归获得变量与父类后，再转换成二进制.
                b. 占用内存大

    2.2 Externalizable
        Externalizable 外部序列化接口，继承Serializable 接口. 定义了writeExternal与readExternal 方法用于实现自定义序列化。
        与Serializable 对比更加灵活，效率更高，占用内存底等特点。

        2.2.1 示例
        public class Wife extends Woman implements Externalizable {

            private final static long serialVersionUID = 1L;

            private int childCount;

            private String face;

            public int age;

            public boolean open;

            public Wife() {

            }

            public Wife(int childCount, String face, int age) {
                this.childCount = childCount;
                this.face = face;
                this.age = age;
                this.ban = 3;
            }

            @Override
            public void writeExternal(ObjectOutput out) throws IOException {
                out.writeInt(childCount);
                out.writeObject(face);
        //        out.writeInt(age);
                out.writeInt(ban);
            }

            @Override
            public void readExternal(ObjectInput in) throws ClassNotFoundException, IOException {
                this.childCount = in.readInt();
                this.face = (String) in.readObject();
        //        this.age = in.readInt();
                this.ban = in.readInt();
            }

            @Override
            public String toString() {
                return "Wife{" +
                        "childCount=" + childCount +
                        ", face='" + face + '\'' +
                        ", age=" + age +
                        ", ban=" + ban +
                        '}';
            }
        }

        writeExternal与readExternal 中写入与读取变量的顺序要保持一致，不然将抛出异常
        2.2.2 原理

        2.2.3 注意点
            a. 必须提供空构造方法。 在反序列化时，将反射空的构造方法创建对象
            b. 同Serializable需要提供serialVersionUID ,保证版本兼容
            c. 类中的变量类型需要实现Serializable 或者Externalizable 接口

    2.3 Parcelable
        2.3.1 基本使用

        2.3.2 原理


        参考：https://www.jianshu.com/p/32a2ec8f35ae
    2.4 JSON
