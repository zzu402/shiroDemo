package com.htkfood.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.htkfood.util.ResultHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
public class CommonExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler({CommonException.class,CommonRuntimeException.class,Exception.class})
    @ResponseBody
    public Object handle(HttpServletRequest request, Exception e) {
        String errorMsg = null;
        String code = "";
        if (e instanceof CommonException) {
            CommonException exception = (CommonException) e;
            errorMsg = exception.getMessage();
            code = exception.getCode();
            logger.error(ResultHelper.formatException(exception), exception);
        } else if (e instanceof CommonRuntimeException) {
            CommonRuntimeException exception = (CommonRuntimeException) e;
            errorMsg = exception.getMessage();
            code = exception.getCode();
            logger.error(ResultHelper.formatException(exception), exception);
        }else if(e instanceof UnauthorizedException){
			ModelAndView mv = new ModelAndView("example/unauthorized");
			return mv;
		}
	
        
        else{
            code="SYSTEM_9999";
            errorMsg=e.getLocalizedMessage();
            logger.error(errorMsg, e);
        }
        Map<String,Object> map = ResultHelper.fail(code, errorMsg);
        return map;
    }
}
