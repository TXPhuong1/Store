package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.CuaHang;
import com.example.sof3011_ass.repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {"/cua-hang/hien-thi", "/cua-hang/detail", "/cua-hang/add",
        "/cua-hang/delete", "/cua-hang/update"})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<CuaHang> list = cuaHangRepository.getAll();
            request.setAttribute("listCH", list);
            request.getRequestDispatcher("/view/cua-hang.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("ch", cuaHang);
            request.getRequestDispatcher("/view/cua-hang-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            cuaHangRepository.delete(id);
            request.getRequestDispatcher("/cua-hang/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang ch = new CuaHang();
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(diaChi);
            ch.setThanhPho(thanhPho);
            ch.setQuocGia(quocGia);
            cuaHangRepository.add(ch);
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang ch = new CuaHang();
            ch.setMa(ma);
            ch.setTen(ten);
            ch.setDiaChi(diaChi);
            ch.setThanhPho(thanhPho);
            ch.setQuocGia(quocGia);
            cuaHangRepository.update(ch, id);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
