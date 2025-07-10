package org.zerock.exception;

import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice // 예외처리 목적
@Log4j2
public class CommonExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String execpt(Exception ex, Model model) {
		
		log.error("CommonExceptionAdvice.java execpt() in...");
		model.addAttribute("exception", ex);
		log.error("예외 발생:" + ex.getMessage());
		log.error(model);
		
		return "error_page";
	}
	
	/**
	 * web.xml
	 * 	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>throwExeptionIfNoHandlerFound</param-name>
			<param-value>true</param-value>
		</init-param>	<!-- 톰캣 404 예외처리 하지 말아라 --> 추가
		</servlet>
	 * @param ex
	 * @return
	 */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model) {
        model.addAttribute("message", "요청하신 페이지를 찾을 수 없습니다.");
        model.addAttribute("exception", ex);
        return "custom404"; // resources/templates/custom404.html 또는 src/main/webapp/WEB-INF/views/custom404.jsp
    }
}
