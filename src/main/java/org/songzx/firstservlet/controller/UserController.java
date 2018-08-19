package org.songzx.firstservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.songzx.firstservlet.model.User;
import org.songzx.firstservlet.service.UserServiceI;
import org.songzx.firstservlet.service.UserServiceImpl;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author songzx
 *         <p>
 *         当你的才华还撑不起你的野心的时候，你就应该静下心来学习；
 *         当你的能力还驾驭不了你的目标时，就应该沉下心来，历练；梦想，不是浮躁，而是沉淀和积累，
 *         只有拼出来的美丽，没有等出来的辉煌，机会永远是留给最渴望的那个人，学会与内心深处的你对话，
 *         问问自己，想要怎样的人生，静心学习，耐心沉淀，送给自己，共勉。
 *         </p>
 */
@WebServlet(name = "userController", urlPatterns = "/user/*", asyncSupported = true)
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -4517082409888184884L;
	private static Logger logger = Logger.getLogger(UserController.class);
	private UserServiceI userService = new UserServiceImpl();

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求的URI地址信息
		String url = request.getRequestURI();
		// 截取其中的方法名
		String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
		Method method = null;
		try {
			// 使用反射机制获取在本类中声明了的方法
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			// 执行方法
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException("调用方法出错！");
		}
	}

	protected void getUserById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		PrintWriter out = null;
		try {
			User user = userService.getUserById(uid);
			String jsonStr = user != null ? JSON.toJSONString(user) : "";
			response.setContentType("application/json");
			out = response.getWriter();
			out.write(jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
