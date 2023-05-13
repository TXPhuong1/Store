package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.NSX;
import com.example.sof3011_ass.repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {"/nsx/hien-thi", "/nsx/detail", "/nsx/add",
        "/nsx/delete", "/nsx/update"})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("listNSX", list);
            request.getRequestDispatcher("/view/nsx.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsxuat = nsxRepository.getById(id);
            request.setAttribute("nsx", nsxuat);
            request.getRequestDispatcher("/view/nsx-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            nsxRepository.delete(id);
            request.getRequestDispatcher("/nsx/hien-thi").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.update(nsx, id);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
