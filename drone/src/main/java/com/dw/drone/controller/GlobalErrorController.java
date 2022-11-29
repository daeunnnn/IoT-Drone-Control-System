package com.dw.drone.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * ���ڸ� 4 : ����Ʈ ���� (URL ��Ÿ, �Ķ���� ��Ÿ, GET�ε� POST�� ������)
 * ���ڸ� 5 : �鿣�� ���� (99% ��Ÿ, 1% null ����)
 * 404 : �߸��� URL ��û
 * 405 : http �޼ҵ� ���� get�ε� post�� ���� 
 * 401 : ���� ���� 
 */

/*
 * @Controller : ������ �̵�
 * @RestController : json �����͸� ������ ����
 */
@Controller
public class GlobalErrorController implements ErrorController{

	/*
	 * Http : ���ͳ� 
	 * Servlet : ���� ( == ����(��)�� ����)
	 * Request : ��û 
	 */
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		String httpErrorCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
		
		if(httpErrorCode.equals("500")){
			//*�����̸� /�����̸�
			return "error/500";
		}
		if("404".equals(httpErrorCode)){
			return "error/404";
		}
		return "error/error";
	}
}
