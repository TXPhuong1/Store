package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.MauSac;
import com.example.sof3011_ass.entity.SanPham;
import com.example.sof3011_ass.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi", "/san-pham/detail", "/san-pham/add",
        "/san-pham/delete", "/san-pham/update"})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanphamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<SanPham> listSP = new SanPhamRepository().getAll();
            request.setAttribute("listSP", listSP);
            request.getRequestDispatcher("/view/san-pham.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanphamRepository.getById(id);
            request.setAttribute("sp", sanPham);
            request.getRequestDispatcher("/view/san-pham-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            sanphamRepository.delete(id);
            request.getRequestDispatcher("/san-pham/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = new SanPham();
            sp.setMa(ma);
            sp.setTen(ten);
            sanphamRepository.add(sp);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            SanPham sp = new SanPham();
            sp.setMa(ma);
            sp.setTen(ten);
            sanphamRepository.update(sp, id);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
