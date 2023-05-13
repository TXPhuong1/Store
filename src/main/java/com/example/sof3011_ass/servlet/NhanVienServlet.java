package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.ChucVu;
import com.example.sof3011_ass.entity.CuaHang;
import com.example.sof3011_ass.entity.KhachHang;
import com.example.sof3011_ass.entity.NhanVien;
import com.example.sof3011_ass.repository.ChucVuRepository;
import com.example.sof3011_ass.repository.CuaHangRepository;
import com.example.sof3011_ass.repository.KhachHangRepository;
import com.example.sof3011_ass.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi", "/nhan-vien/detail", "/nhan-vien/add",
        "/nhan-vien/delete", "/nhan-vien/update"})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    List<NhanVien> listNV = new ArrayList<>();
    List<CuaHang> listCH = new ArrayList<>();
    List<ChucVu> listCV = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/hien-thi")) {
            listNV = nhanVienRepository.getAll();
            request.setAttribute("listNV", listNV);
            listCH = cuaHangRepository.getAll();
            request.setAttribute("listCH", listCH);
            listCV = chucVuRepository.getAll();
            request.setAttribute("listCV", listCV);
            request.getRequestDispatcher("/view/nhan-vien.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien", nhanVien);
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            listNV = nhanVienRepository.getAll();
            request.setAttribute("listNhanVien", listNV);
            listCH = cuaHangRepository.getAll();
            request.setAttribute("listCuaHang", listCH);
            listCV = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listCV);
            request.getRequestDispatcher("/view/nhan-vien-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            nhanVienRepository.delete(id);
            request.getRequestDispatcher("/nhan-vien/hien-thi").forward(request, response);
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
            String gioiTinh = request.getParameter("gioiTinh");
            String trangThai = request.getParameter("trangThai");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            UUID nv = UUID.fromString(request.getParameter("nhanVien"));
            NhanVien nhanVien1 = nhanVienRepository.getById(nv);
            UUID cuaHang = UUID.fromString(request.getParameter("cuaHang"));
            CuaHang cuaHang1 = cuaHangRepository.getById(cuaHang);
            UUID chucVu = UUID.fromString(request.getParameter("chucVu"));
            ChucVu chucVu1 = chucVuRepository.getById(chucVu);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setHo(ho);
            nhanVien.setTenDem(tenDem);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setSdt(sdt);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setTrangThai(Integer.valueOf(trangThai));
            nhanVien.setMatKhau(matKhau);
            nhanVien.setIdGBC(nhanVien1);
            nhanVien.setIdCV(chucVu1);
            nhanVien.setIdCH(cuaHang1);
            nhanVienRepository.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String gioiTinh = request.getParameter("gioiTinh");
            String trangThai = request.getParameter("trangThai");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            UUID nv = UUID.fromString(request.getParameter("nhanVien"));
            NhanVien nhanVien1 = nhanVienRepository.getById(nv);
            UUID cuaHang = UUID.fromString(request.getParameter("cuaHang"));
            CuaHang cuaHang1 = cuaHangRepository.getById(cuaHang);
            UUID chucVu = UUID.fromString(request.getParameter("chucVu"));
            ChucVu chucVu1 = chucVuRepository.getById(chucVu);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setHo(ho);
            nhanVien.setTenDem(tenDem);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setSdt(sdt);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setTrangThai(Integer.valueOf(trangThai));
            nhanVien.setMatKhau(matKhau);
            nhanVien.setIdGBC(nhanVien1);
            nhanVien.setIdCV(chucVu1);
            nhanVien.setIdCH(cuaHang1);
            nhanVienRepository.update(nhanVien, id);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
