package academy.learnprogramming.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    /**
     * Service layer contains the business logic. In this case, the business logic/service is to
     * retrieve messages aka this messages down bellow to display.
     */

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo Application";
    }

    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user;
    }
}
