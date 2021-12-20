package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class MyLoggerController {

    private final MyLoggerService myLoggerService;
    private final MyLogger myLogger;
//    Provider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
//        MyLogger provider = myLoggerProvider.get();

        String url = request.getRequestURL().toString();
        myLogger.setUrl(url);
        myLogger.log("controller test");

        myLoggerService.logic("testId");
        return "ok";
    }
}
