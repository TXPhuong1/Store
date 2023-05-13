package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.*;
import com.example.sof3011_ass.repository.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {"/mau-sac/hien-thi", "/mau-sac/detail", "/mau-sac/add",
        "/mau-sac/delete", "/mau-sac/update"})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<MauSac> listMS = new MauSacRepository().getAll();
            request.setAttribute("listMS", listMS);
            request.getRequestDispatcher("/view/mau-sac.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("ms", mauSac);
            request.getRequestDispatcher("/view/mau-sac-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            mauSacRepository.delete(id);
            request.getRequestDispatcher("/mau-sac/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac ms = new MauSac();
            ms.setMa(ma);
            ms.setTen(ten);
            mauSacRepository.add(ms);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            MauSac ms = new MauSac();
            ms.setMa(ma);
            ms.setTen(ten);
            mauSacRepository.update(ms, id);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
