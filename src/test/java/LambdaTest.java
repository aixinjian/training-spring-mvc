
import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    class Person{
        private String username;
        private int age;

        public String getUsername(){
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public int getPassword() {
            return age;
        }
        public void setPassword(String password) {
            this.age = age;
        }


    }
    public static void main(String[] args){
        List<Person> list = new ArrayList<>();

        list.stream().forEach(k->System.err.println(k));
    }

}
