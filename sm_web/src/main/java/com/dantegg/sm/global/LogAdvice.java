package com.dantegg.sm.global;


import com.dantegg.sm.entity.Log;
import com.dantegg.sm.entity.Staff;
import com.dantegg.sm.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author dantegg
 */
@Component
@Aspect
public class LogAdvice {
    @Autowired
    private LogService logService;
    @After("execution(* com.dantegg.sm.controller.*.*(..)) && !execution(* com.dantegg.sm.controller.SelfController.*(..))" +
            "&& !execution(* com.dantegg.sm.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint) {
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff = (Staff) obj;
        log.setOperator(staff.getAccount());
        log.setResult("成功");
        logService.addOperationLog(log);
    }

    @AfterThrowing(throwing ="e", pointcut = "execution(* com.dantegg.sm.controller.*.*(..)) && !execution(* com.dantegg.sm.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint, Throwable e) {
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        Staff staff = (Staff) obj;
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }

    @After("execution(* com.dantegg.sm.controller.SelfController.login(..))")
    public void loginLog(JoinPoint joinPoint) {
        log(joinPoint);
    }

    @Before("execution(* com.dantegg.sm.controller.SelfController.login(..))")
    public void logout(JoinPoint joinPoint) {
        log(joinPoint);
    }

    private void log(JoinPoint joinPoint) {
        Log log = new Log();
        log.setModule(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("USER");
        if (obj == null) {
            log.setOperator(request.getParameter("account"));
            log.setResult("失败");
        } else {
            Staff staff = (Staff) obj;
            log.setOperator(staff.getAccount());
            log.setResult("成功");
        }

        logService.addLoginLog(log);
    }
}
