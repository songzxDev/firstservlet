package org.songzx.firstservlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet(name = "userController", urlPatterns = "/user/getUserById", asyncSupported = true)
public class UserController extends HttpServlet {

	private static final long serialVersionUID = -4517082409888184884L;
	private UserServiceI userService = new UserServiceImpl();

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uid = req.getParameter("uid");
		String jsonStr = "";
		try {
			User user = userService.getUserById(uid);
			if (user != null) {
				jsonStr = JSON.toJSONString(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		System.out.println(jsonStr);
		out.write(jsonStr);
		out.close();
	}

}
