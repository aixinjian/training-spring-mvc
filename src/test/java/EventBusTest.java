import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

public class EventBusTest {

    @Test
    public void test(){
        EventBus bus = new EventBus();
        bus.register(new EventBusTest(){

            @Subscribe
            public void lister (Integer i){
                System.out.printf("%s from int%n",i);
            }

        });


        bus.post(1);
    }

}
