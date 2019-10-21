import org.junit.Test;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream的中间操作测试
 */
public class StreamTest {
    List<Employee> emps = Arrays.asList(
            new Employee(101, "林青霞", 28, 9889.99),
            new Employee(102, "东方不败", 29, 4329.85),
            new Employee(103, "周星驰", 40, 1233.88),
            new Employee(104, "大圣", 500, 5000.44),
            new Employee(105, "张无忌", 15, 3000.09),
            new Employee(102, "东方不败", 29, 4329.85)
    );


    /************************中间操作 筛选和过滤************************************/

    @Test
    public void test() {
        List<String> ageList = emps.stream().map(Employee::getName).collect(Collectors.toList());
        String name = String.join(",", ageList);
        System.out.println(name);
    }

    /**
     * filter 中间操作,过滤
     */
    @Test
    public void filterTest() {

        //中间操作不做任何处理
        Stream<Employee> stream = emps.stream()
                .filter((e) -> {
                    System.out.println("惰性求值");
                    return e.getAge() < 30;
                });

        System.out.println("--------------------");

        // 终止操作，一次性执行全部功能， 称为 "惰性求值"
        stream.forEach(System.out::println);

        List<Integer> newList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> oldList = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> list = newList.stream().filter(e -> {
            return !oldList.contains(e);
        }).collect(Collectors.toList());

        list.stream().forEach(System.out::println);

    }


    /**
     * 中间操作，截断流
     */
    @Test
    public void limitTest() {
        emps.stream()
                .filter(c -> c.getAge() < 30) // 过滤年龄小于30的人
                .limit(1) // 截取一个
                .forEach(System.out::println);
    }

    /**
     * 中间操作，跳过
     */
    @Test
    public void skipTest() {

        emps.stream()
                .filter(employee -> employee.getAge() < 30)
                .skip(2) //前面的跳过，截取后两个 和limit互补
                .forEach(System.out::println);
    }

    /**
     * 中间操作，去重
     */
    @Test
    public void distinctTest() {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }


    /************************中间操作 映射************************************/

    /**
     * map(Function f)	 接受一个函数作为参数，该函数被应用到每个元素上，并将其映射成一个新元素
     * mapToDouble(ToDoubleFunction f)	接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 DoubleStream。
     * mapToInt(ToIntFunction f)	接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 IntStream
     * mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 LongStream。
     * flatMap(Function f)	接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流案例
     */
    @Test
    public void mapTest() {
        List<String> list = Arrays.asList("hello", "world", "i", "love", "it");
        list.stream()
                .map((x) -> x.toUpperCase()) //中间操作，返回一个流，该流映射到另外的值
                .forEach(System.out::println);

        System.out.println("************************");

        emps.stream()
                .map(Employee::getAge)
                .forEach(System.out::println);

        System.out.println("************************");

    }


    /*floatMap 将一个流中的每个值都转为一个流*/
    @Test
    public void floatMapTest() {
        List<String> strings = Arrays.asList("hello", "world");
        List<String> list = strings
                .stream() //集合转为流
                .map(s -> s.split("")) //转换成['H','e','l','l','o'], ['W','o','r','l','d'] 两个数组
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /************************中间操作 排序************************************/
    @Test
    public void sortTest() {
        emps.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder()) //倒序，默认升序
                .forEach(System.out::println);

    }

    /************************终止操作（终止操作会从流的流水线产生结果）************************************/


    /************************终止操作 匹配************************************/

    /**
     * allMatch 检查是否匹配所有元素
     * <p>
     * anyMatch(Predicate p) 检查是否至少匹配一个元素
     * <p>
     * noneMatch(Predicate p) 检查是否没有匹配所有元素
     */
    @Test
    public void matchTest() {
        boolean allMatch = emps.stream()
                .allMatch(e -> e.getName().equals("林青霞"));
        System.out.println(allMatch);
        System.out.println("-----------------");

        boolean anyMatch = emps.stream()
                .anyMatch(e -> e.getName().equals("林青霞"));
        System.out.println(allMatch);
        System.out.println("-----------------");

        boolean noneMatch = emps.stream()
                .noneMatch(e -> e.getName().equals("林青霞"));
        System.out.println(allMatch);
        System.out.println("-----------------");

    }

    /**
     * Optional,容器，可为空
     */
    @Test
    public void optionTest() {

        Optional<Integer> optional = Optional.of(1);
        Integer i = optional.get();
        System.out.println(i);


        Optional<Integer> optional1 = Optional.ofNullable(null);
        Integer op = optional1.get();
        System.out.println(op);

    }


    /**
     * Collectors,将流转为集合
     */
    @Test
    public void CollectorsTest() {
        List<Employee> employees = emps.stream().filter(c -> c.getAge() > 30).collect(Collectors.toList());

        Map<Integer, Employee> employeeMap = emps.stream().collect(Collectors.toMap(Employee::getId, k -> {
            return k;
        }));
    }


    /**
     * reduce:从stream按照给定的类型生成值，聚合操作 sum()、max()、min()、count()调用的都是reduce
     */
    @Test
    public void reduceTest() {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        //无默认值求和
        Optional<Integer> sum = stream.reduce((a, b) -> a + b);
        System.out.println(sum);

        //有默认值求和
        Integer result = stream.reduce(100, Integer::sum);
        System.out.println(result);

        stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
//        stream.reduce((i,j)->i+j).ifPresent(System.out::println);
        int result2 = stream.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
        System.out.println(result2);


    }

    /**
     * List集合填充另一个list
     */
    @Test
    public void listToList() {

    }




}
