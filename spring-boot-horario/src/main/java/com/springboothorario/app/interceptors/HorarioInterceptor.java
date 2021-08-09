package com.springboothorario.app.interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

@Component("horario")
public class HorarioInterceptor implements HandlerInterceptor {

    @Value("${config.horario.apertura}")
    private Integer apertura;
    @Value("${config.horario.cierre}")
    private Integer cierre;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);

        if (hora >= apertura && hora < cierre) {
            StringBuilder stringBuilder = new StringBuilder("Bienvenido al horario de atencion al cliente");
            stringBuilder.append(" , atendemos desde las ");
            stringBuilder.append(apertura);
            stringBuilder.append("hrs. ");
            stringBuilder.append("hasta las ");
            stringBuilder.append(cierre);
            stringBuilder.append("hrs. ");
            stringBuilder.append("Gracias por su visita");
            request.setAttribute("mensaje", stringBuilder.toString());
            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/cerrado"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String mensaje = (String) request.getAttribute("mensaje");
        if (modelAndView != null && handler instanceof HandlerMethod) {
            modelAndView.addObject("horario", mensaje);
        }
    }
}
