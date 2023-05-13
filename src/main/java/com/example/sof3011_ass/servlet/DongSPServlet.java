package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.DongSP;
import com.example.sof3011_ass.entity.MauSac;
import com.example.sof3011_ass.repository.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {"/dong-sp/hien-thi", "/dong-sp/detail", "/dong-sp/add",
        "/dong-sp/delete", "/dong-sp/update"})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dspRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<DongSP> listDSP = dspRepository.getAll();
            request.setAttribute("listDSP", listDSP);
            request.getRequestDispatcher("/view/dong-sp.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dspRepository.getById(id);
            request.setAttribute("dsp", dongSP);
            request.getRequestDispatcher("/view/dong-sp-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            dspRepository.delete(id);
            request.getRequestDispatcher("/dong-sp/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dsp = new DongSP();
            dsp.setMa(ma);
            dsp.setTen(ten);
            dspRepository.add(dsp);
            response.sendRedirect("/dong-sp/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dsp = new DongSP();
            dsp.setMa(ma);
            dsp.setTen(ten);
            dspRepository.update(dsp, id);
            response.sendRedirect("/dong-sp/hien-thi");
        }
    }
}
