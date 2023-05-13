package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.*;
import com.example.sof3011_ass.repository.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {"/chi-tiet-sp/hien-thi", "/chi-tiet-sp/detail", "/chi-tiet-sp/add",
        "/chi-tiet-sp/delete", "/chi-tiet-sp/update", "/chi-tiet-sp/view-add"})
public class ChiTietSPServlet extends HttpServlet {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private SanPhamRepository spRepository = new SanPhamRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private NSXRepository nsxRepository = new NSXRepository();
    private List<ChiTietSP> listCTSP = new ArrayList<>();
    private List<SanPham> listSanPham = new ArrayList<>();
    private List<MauSac> listMauSac = new ArrayList<>();
    private List<NSX> listNSX = new ArrayList<>();
    private List<DongSP> listDongSP = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            listCTSP = chiTietSPRepository.getAll();
            request.setAttribute("listCTSP", listCTSP);
            request.getRequestDispatcher("/view/index.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP ctsp = chiTietSPRepository.getOne(id);
            request.setAttribute("ctsp", ctsp);
            listSanPham = spRepository.getAll();
            request.setAttribute("listSP", listSanPham);
            listMauSac = mauSacRepository.getAll();
            request.setAttribute("listMS", listMauSac);
            listDongSP = dongSPRepository.getAll();
            request.setAttribute("listDSP", listDongSP);
            listNSX = nsxRepository.getAll();
            request.setAttribute("listNSX", listNSX);
            request.getRequestDispatcher("/view/chi-tiet-sp-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            chiTietSPRepository.delete(id);
            request.getRequestDispatcher("/chi-tiet-sp/hien-thi").forward(request, response);
        } else if(uri.contains("/view-add")){
            listSanPham = spRepository.getAll();
            request.setAttribute("listSP", listSanPham);
            listMauSac = mauSacRepository.getAll();
            request.setAttribute("listMS", listMauSac);
            listDongSP = dongSPRepository.getAll();
            request.setAttribute("listDSP", listDongSP);
            listNSX = nsxRepository.getAll();
            request.setAttribute("listNSX", listNSX);
            request.getRequestDispatcher("/view/chi-tiet-sp-add.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTon");
            String giaNhap1 = request.getParameter("giaNhap");
            BigDecimal giaNhap = new BigDecimal(giaNhap1);
            String giaBan1 = request.getParameter("giaBan");
            BigDecimal giaBan = new BigDecimal(giaBan1);
            UUID sanPham = UUID.fromString(request.getParameter("sanPham"));
            SanPham sanPham1 = spRepository.getById(sanPham);
            UUID mauSac = UUID.fromString(request.getParameter("mauSac"));
            MauSac mauSac1 = mauSacRepository.getById(mauSac);
            UUID dongSP = UUID.fromString(request.getParameter("dongSP"));
            DongSP dongSP1 = dongSPRepository.getById(dongSP);
            UUID nsx = UUID.fromString(request.getParameter("nhaSX"));
            NSX nsx1 = nsxRepository.getById(nsx);
            ChiTietSP chiTietSanPham = new ChiTietSP();
            chiTietSanPham.setIdSP(sanPham1);
            chiTietSanPham.setIdNSX(nsx1);
            chiTietSanPham.setIdMauSac(mauSac1);
            chiTietSanPham.setIdDongSP(dongSP1);
            chiTietSanPham.setNamBH(Integer.valueOf(namBH));
            chiTietSanPham.setSoLuongTon(Integer.valueOf(soLuongTon));
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setGiaBan(giaBan);
            chiTietSanPham.setGiaNhap(giaNhap);
            chiTietSPRepository.add(chiTietSanPham);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTon");
            String giaNhap1 = request.getParameter("giaNhap");
            BigDecimal giaNhap = new BigDecimal(giaNhap1);
            String giaBan1 = request.getParameter("giaBan");
            BigDecimal giaBan = new BigDecimal(giaBan1);
            UUID sanPham = UUID.fromString(request.getParameter("sanPham"));
            SanPham sanPham1 = spRepository.getById(sanPham);
            UUID mauSac = UUID.fromString(request.getParameter("mauSac"));
            MauSac mauSac1 = mauSacRepository.getById(mauSac);
            UUID dongSP = UUID.fromString(request.getParameter("dongSP"));
            DongSP dongSP1 = dongSPRepository.getById(dongSP);
            UUID nsx = UUID.fromString(request.getParameter("nhaSX"));
            NSX nsx1 = nsxRepository.getById(nsx);
            ChiTietSP chiTietSanPham = new ChiTietSP();
            chiTietSanPham.setIdSP(sanPham1);
            chiTietSanPham.setIdNSX(nsx1);
            chiTietSanPham.setIdMauSac(mauSac1);
            chiTietSanPham.setIdDongSP(dongSP1);
            chiTietSanPham.setNamBH(Integer.valueOf(namBH));
            chiTietSanPham.setSoLuongTon(Integer.valueOf(soLuongTon));
            chiTietSanPham.setMoTa(moTa);
            chiTietSanPham.setGiaBan(giaBan);
            chiTietSanPham.setGiaNhap(giaNhap);
            chiTietSPRepository.update(id, chiTietSanPham);
            response.sendRedirect("/chi-tiet-sp/hien-thi");
        }
    }
}
