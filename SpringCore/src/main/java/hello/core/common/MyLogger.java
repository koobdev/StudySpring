package hello.core.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Scope(value = "request")
@Component
@RequiredArgsConstructor
public class MyLogger {

    private String uuid;
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public void log(String msg){
        System.out.println("[" + uuid + "]" + "[" + url +"] " + msg);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("[" + uuid + "] request scope bean close");
    }
}
