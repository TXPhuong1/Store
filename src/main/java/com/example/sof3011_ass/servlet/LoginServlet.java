package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.NhanVien;
import com.example.sof3011_ass.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = {"/login", "/logout"})
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private List<NhanVien> nhanVienList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy tên người dùng và mật khẩu từ request parameter
        String name = "";
        String pass = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        nhanVienList = nhanVienRepository.getAll();
        // Kiểm tra tên người dùng và mật khẩu
        for (NhanVien nv : nhanVienList) {
            name = nv.getMa();
            pass = nv.getMatKhau();
        }
        if (username.equalsIgnoreCase(name) && password.equalsIgnoreCase(pass)) {
            // Tạo HttpSession và lưu tên người dùng vào session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Chuyển hướng đến trang chủ
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        } else {
            // Nếu tên người dùng hoặc mật khẩu không đúng, hiển thị thông báo lỗi
            request.setAttribute("error", "Username or password incorrect");
            request.getRequestDispatcher("/view/login.jsp").forward(request, response);
        }
    }
}

