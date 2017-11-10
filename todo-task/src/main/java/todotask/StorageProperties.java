package todotask;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.jayway.jsonpath.internal.Path;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "/home/artursbm/GitHub/todo-spring/todo-task/src/main/resources/static/Images";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
