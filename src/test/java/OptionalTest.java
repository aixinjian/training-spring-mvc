import org.junit.Test;

import java.util.Optional;

/**
 * java8添加的容器对象，在一些场景下避免使用null检查而设定的类，尽可能避免的 NullPointerException。
 */
public class OptionalTest {

    /*创建空的optional实例*/
    @Test
    public void emptyTest() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }

    @Test
    public void ofTest()  {
        Optional<Object> optional = Optional.ofNullable(null);
        System.out.println(optional.get()); //抛空指针异常
        Optional<Object> optional1 = Optional.ofNullable("test");
        System.out.println(optional1.get());
    }

    public static void main(String[] args) {

    }
}
