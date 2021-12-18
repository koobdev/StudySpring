package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class BeanLifeCycle{

    private String url;

    public BeanLifeCycle() {
        System.out.println("생성자 호출, url : " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void call(String message){
        System.out.println("call : " + url + ", message : " + message);
    }
    // 연결 : 초기화 콜백
    public void connect(){
        System.out.println("connect : " + url);
    }
    // 연결해제 : 소멸전 콜백
    public void disconnect(){
        System.out.println("disconnect : " + url);
    }


    // InitializingBean 인터페이스를 사용했을 때 override하여 사용하는 메서드
    // 의존관계 주입 직후 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("BeanLifeCycle.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }

    // Disposable 인터페이스를 사용했을 때 override하여 사용하는 메서드
    // 소멸 직전에 호출
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("BeanLifeCycle.destroy");
//        disconnect();
//    }


    @PostConstruct
    public void init(){
        System.out.println("BeanLifeCycle.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close(){
        System.out.println("BeanLifeCycle.close");
        disconnect();
    }
}
