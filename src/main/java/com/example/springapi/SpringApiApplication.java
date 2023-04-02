package com.example.springapi;
import com.example.springapi.entity.User;
import com.example.springapi.entity.UserProfile;
import com.example.springapi.enums.Gender;
import com.example.springapi.repository.EmployeeRepository;
import com.example.springapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Calendar;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        employeeRepository.save(new Employee(null,"habib","wahid","manager"));
//        employeeRepository.save(new Employee(null,"hasan","mahmud","employee"));

//        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach((name)-> System.out.println("Name " + name));

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1998,12,18);
        User user = new User(null,"habib","wahid",null);
        UserProfile userProfile = new UserProfile(null,"01626794207", Gender.MALE,"Sylhet","Bangladesh", dateOfBirth.getTime(),null);
        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);
    }
}
