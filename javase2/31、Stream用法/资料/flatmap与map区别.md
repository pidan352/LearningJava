理解
map：map方法返回的是一个object，map将流中的当前元素替换为此返回值；

flatMap：flatMap方法返回的是一个stream，flatMap将流中的当前元素替换为此返回流拆解的流元素；

官方解释
map:Returns a stream consisting of the results of applying the given function to the elements of this stream.

返回一个流，包含给定函数应用在流中每一个元素后的结果

flatmap:Returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element.

返回一个流，包含将此流中的每个元素替换为通过给定函数映射应用于每个元素而生成的映射流的内容

举例说明
有二箱鸡蛋，每箱5个，现在要把鸡蛋加工成煎蛋，然后分给学生。

map做的事情：把二箱鸡蛋分别加工成煎蛋，还是放成原来的两箱，分给2组学生；

flatMap做的事情：把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生；

~~~ java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Map_FlatMap {


    List<String[]> eggs = new ArrayList<>();

    public void init() {
        // 第一箱鸡蛋
        eggs.add(new String[]{"鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1", "鸡蛋_1"});
        // 第二箱鸡蛋
        eggs.add(new String[]{"鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2", "鸡蛋_2"});
    }

    // 自增生成组编号
    static int group = 1;
    // 自增生成学生编号
    static int student = 1;

    /**
     * 把二箱鸡蛋分别加工成煎蛋，还是放在原来的两箱，分给2组学生
     */
    public void map() {
        eggs.stream()
                .map(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("组" + group++ + ":" + Arrays.toString(x.toArray())));
        /*
        控制台打印：------------
        组1:[煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1, 煎蛋_1]
        组2:[煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2, 煎蛋_2]
         */
    }

    /**
     * 把二箱鸡蛋分别加工成煎蛋，然后放到一起【10个煎蛋】，分给10个学生
     */
    public void flatMap() {
        eggs.stream()
                .flatMap(x -> Arrays.stream(x).map(y -> y.replace("鸡", "煎")))
                .forEach(x -> System.out.println("学生" + student++ + ":" + x));
        /*
        控制台打印：------------
        学生1:煎蛋_1
        学生2:煎蛋_1
        学生3:煎蛋_1
        学生4:煎蛋_1
        学生5:煎蛋_1
        学生6:煎蛋_2
        学生7:煎蛋_2
        学生8:煎蛋_2
        学生9:煎蛋_2
        学生10:煎蛋_2
         */
    }

}

~~~

