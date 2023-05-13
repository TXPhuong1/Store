package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.ChiTietSP;
import com.example.sof3011_ass.entity.HoaDon;
import com.example.sof3011_ass.entity.HoaDonChiTiet;
import com.example.sof3011_ass.repository.ChiTietSPRepository;
import com.example.sof3011_ass.repository.HoaDonChiTietRepository;
import com.example.sof3011_ass.repository.HoaDonRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "HoaDonChiTietServlet", value = {"/hoa-don/chon-san-pham", "/hoa-don-chi-tiet/add",
        "/hoa-don-chi-tiet/delete", "/hoa-don-chi-tiet/update"})
public class HoaDonChiTietServlet extends HttpServlet {
    private HoaDonChiTietRepository hoaDonChiTietRepository = new HoaDonChiTietRepository();
    private HoaDonRepository hoaDonRepository = new HoaDonRepository();
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private List<ChiTietSP> listChiTietSP = new ArrayList<>();
    private List<HoaDon> listHoaDon = new ArrayList<>();
    private List<HoaDonChiTiet> listHDCT = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/delete")) {
            UUID idHD = UUID.fromString(request.getParameter("idHD"));
            UUID idSP = UUID.fromString(request.getParameter("idSP"));
            System.out.println("id hoa don:"+idHD);
            System.out.println("id sp:"+idSP);
            hoaDonChiTietRepository.delete(idHD, idSP);
            request.getRequestDispatcher("/hoa-don/hien-thi").forward(request, response);
        } else if (uri.contains("/chon-san-pham")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            HoaDon hd = hoaDonRepository.getById(id);
            request.setAttribute("idHD", hd);
            listHoaDon = hoaDonRepository.getAll();
            request.setAttribute("listHD", listHoaDon);
            listChiTietSP = chiTietSPRepository.getAll();
            request.setAttribute("listCTSP", listChiTietSP);
            listHDCT = hoaDonChiTietRepository.getAll(id);
            request.setAttribute("listHDCT", listHDCT);
            request.getRequestDispatcher("/view/chon-san-pham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String soLuong = request.getParameter("soLuong");
            UUID hoaDon = UUID.fromString(request.getParameter("hoaDon"));
            HoaDon hoaDon1 = hoaDonRepository.getById(hoaDon);
            UUID chiTietSP = UUID.fromString(request.getParameter("chiTietSP"));
            ChiTietSP chiTietSP1 = chiTietSPRepository.getOne(chiTietSP);
            BigDecimal donGia = chiTietSP1.getGiaBan();
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setSoLuong(Integer.valueOf(soLuong));
            hdct.setDonGia(donGia);
            hdct.setIdChiTietSP(chiTietSP1);
            hdct.setIdHoaDon(hoaDon1);
            chiTietSP1.setSoLuongTon(chiTietSP1.getSoLuongTon() - Integer.valueOf(soLuong));
            chiTietSPRepository.update(chiTietSP, chiTietSP1);
            System.out.println(chiTietSP1.getSoLuongTon() - Integer.valueOf(soLuong));
            hoaDonChiTietRepository.add(hdct);
            response.sendRedirect("/hoa-don/hien-thi");
        } else if (uri.contains("/update")) {
            String soLuong = request.getParameter("soLuong");
            String donGia1 = request.getParameter("donGia");
            BigDecimal donGia = new BigDecimal(donGia1);
            UUID hoaDon = UUID.fromString(request.getParameter("hoaDon"));
            UUID chiTietSP = UUID.fromString(request.getParameter("chiTietSP"));
            ChiTietSP chiTietSP1 = chiTietSPRepository.getOne(chiTietSP);
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setSoLuong(Integer.valueOf(soLuong));
            hdct.setDonGia(donGia);
            hdct.setIdChiTietSP(chiTietSP1);
            hoaDonChiTietRepository.update(hoaDon, hdct);
            response.sendRedirect("/hoa-don/hien-thi");
        }
    }
}
