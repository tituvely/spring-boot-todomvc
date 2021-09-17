package guide.springboot.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private Long id = 1L;

    public String generateId() {
        id = id++;
        return id.toString();
    }

}
