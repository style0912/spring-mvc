package x3.benjamin.playground.apiserver.intercepter;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by benjamin on 2017. 2. 18..
 */
public class LoggingHandlerIntercepter extends HandlerInterceptorAdapter {

    private Map<String, Long> elapseTimeMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String sessionId = request.getSession().getId();
        Long currentTime = System.currentTimeMillis();

        elapseTimeMap.put(sessionId, currentTime);

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        String sessionId = request.getSession().getId();
        long beginTime = elapseTimeMap.remove(sessionId);
        String uri = request.getRequestURI();
        String method = request.getMethod();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(method).append("] ");
        stringBuilder.append(uri).append(" ");
        stringBuilder.append(System.currentTimeMillis() - beginTime);
        stringBuilder.append(" ms");

        System.out.println(stringBuilder.toString());

        super.postHandle(request, response, handler, modelAndView);
    }
}
