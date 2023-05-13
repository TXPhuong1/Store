package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.KhachHang;
import com.example.sof3011_ass.repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi", "/khach-hang/detail", "/khach-hang/add",
        "/khach-hang/delete", "/khach-hang/update"})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/hien-thi")) {
            List<KhachHang> list = khachHangRepository.getAll();
            request.setAttribute("listKH", list);
            request.getRequestDispatcher("/view/khach-hang.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            request.setAttribute("khachHang", khachHang);
            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/view/khach-hang-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            khachHangRepository.delete(id);
            request.getRequestDispatcher("/khach-hang/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.update(khachHang, id);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
