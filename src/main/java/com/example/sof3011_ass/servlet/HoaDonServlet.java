package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.*;
import com.example.sof3011_ass.repository.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "HoaDonServlet", value = {"/hoa-don/hien-thi", "/hoa-don/detail", "/hoa-don/add", "/hoa-don/thanh-toan",
        "/hoa-don/delete", "/hoa-don/update", "/tim-kiem"})
public class HoaDonServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
        private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<NhanVien> listNV = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/hien-thi")) {
            listKH = khachHangRepository.getAll();
            request.setAttribute("listKH", listKH);
            listNV = nhanVienRepository.getAll();
            request.setAttribute("listNV", listNV);
            listHD = hoaDonRepository.getAll();
            request.setAttribute("listHD", listHD);
            request.getRequestDispatcher("/view/hoa-don.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            HoaDon hd = hoaDonRepository.getById(id);
            request.setAttribute("hd", hd);
            listKH = khachHangRepository.getAll();
            request.setAttribute("listKH", listKH);
            listNV = nhanVienRepository.getAll();
            request.setAttribute("listNV", listNV);
            String ngayTao = dateFormat.format(hd.getNgayTao());
            request.setAttribute("ngayTao", ngayTao);
            String ngayThanhToan = dateFormat.format(hd.getNgayThanhToan());
            request.setAttribute("ngayThanhToan", ngayThanhToan);
            String ngayShip = dateFormat.format(hd.getNgayShip());
            request.setAttribute("ngayShip", ngayShip);
            String ngayNhan = dateFormat.format(hd.getNgayNhan());
            request.setAttribute("ngayNhan", ngayNhan);
            request.getRequestDispatcher("/view/hoa-don-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            hoaDonRepository.delete(id);
            request.getRequestDispatcher("/hoa-don/hien-thi").forward(request, response);
        } else if (uri.contains("/tim-kiem")) {
            String ma = request.getParameter("search");
            ChiTietSP crsp = new ChiTietSPRepository().search(ma);
            request.setAttribute("ctsp", crsp);
            request.getRequestDispatcher("/view/hoa-don.jsp").forward(request, response);
        } else if (uri.contains("/thanh-toan")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            HoaDon hd = hoaDonRepository.getById(id);
            request.setAttribute("hd", hd);
            listHoaDonChiTiet = hoaDonChiTietRepository.getAll(id);
            request.setAttribute("listHDCT", listHoaDonChiTiet);
            listKH = khachHangRepository.getAll();
            request.setAttribute("listKH", listKH);
            listNV = nhanVienRepository.getAll();
            request.setAttribute("listNV", listNV);
            String ngayTao = dateFormat.format(hd.getNgayTao());
            request.setAttribute("ngayTao", ngayTao);
            String ngayThanhToan = dateFormat.format(hd.getNgayThanhToan());
            request.setAttribute("ngayThanhToan", ngayThanhToan);
            String ngayShip = dateFormat.format(hd.getNgayShip());
            request.setAttribute("ngayShip", ngayShip);
            String ngayNhan = dateFormat.format(hd.getNgayNhan());
            request.setAttribute("ngayNhan", ngayNhan);
            request.getRequestDispatcher("/view/thanh-toan.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            int tinhTrang = 2;
            String tenNguoiNhan = request.getParameter("tenNguoiNhan");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            UUID nhanVien = UUID.fromString(request.getParameter("nhanVien"));
            NhanVien nhanVien1 = nhanVienRepository.getById(nhanVien);
            UUID khachHang = UUID.fromString(request.getParameter("khachHang"));
            KhachHang khachHang1 = khachHangRepository.getById(khachHang);
            Date ngayTao;
            try {
                ngayTao = dateFormat.parse(request.getParameter("ngayTao"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayThanhToan;
            try {
                ngayThanhToan = dateFormat.parse(request.getParameter("ngayThanhToan"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayShip;
            try {
                ngayShip = dateFormat.parse(request.getParameter("ngayShip"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayNhan;
            try {
                ngayNhan = dateFormat.parse(request.getParameter("ngayNhan"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMa(ma);
            hoaDon.setTinhTrang(Integer.valueOf(tinhTrang));
            hoaDon.setTenNguoiNhan(tenNguoiNhan);
            hoaDon.setDiaChi(diaChi);
            hoaDon.setSdt(sdt);
            hoaDon.setIdNV(nhanVien1);
            hoaDon.setIdKH(khachHang1);
            hoaDon.setNgayTao(ngayTao);
            hoaDon.setNgayThanhToan(ngayThanhToan);
            hoaDon.setNgayShip(ngayShip);
            hoaDon.setNgayNhan(ngayNhan);
            hoaDonRepository.add(hoaDon);
            response.sendRedirect("/hoa-don/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = hoaDonRepository.getById(id).getMa();
            String tenNguoiNhan = request.getParameter("tenNguoiNhan");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            UUID nhanVien = UUID.fromString(request.getParameter("nhanVien"));
            NhanVien nhanVien1 = nhanVienRepository.getById(nhanVien);
            UUID khachHang = UUID.fromString(request.getParameter("khachHang"));
            KhachHang khachHang1 = khachHangRepository.getById(khachHang);
            Date ngayTao;
            try {
                ngayTao = dateFormat.parse(request.getParameter("ngayTao"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayThanhToan;
            try {
                ngayThanhToan = dateFormat.parse(request.getParameter("ngayThanhToan"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayShip;
            try {
                ngayShip = dateFormat.parse(request.getParameter("ngayShip"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            Date ngayNhan;
            try {
                ngayNhan = dateFormat.parse(request.getParameter("ngayNhan"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(id);
            hoaDon.setMa(ma);
            hoaDon.setTinhTrang(1);
            hoaDon.setTenNguoiNhan(tenNguoiNhan);
            hoaDon.setDiaChi(diaChi);
            hoaDon.setSdt(sdt);
            hoaDon.setIdNV(nhanVien1);
            hoaDon.setIdKH(khachHang1);
            hoaDon.setNgayTao(ngayTao);
            hoaDon.setNgayThanhToan(ngayThanhToan);
            hoaDon.setNgayShip(ngayShip);
            hoaDon.setNgayNhan(ngayNhan);
            hoaDonRepository.update(id, hoaDon);
            response.sendRedirect("/hoa-don/hien-thi");
        }
    }
}
