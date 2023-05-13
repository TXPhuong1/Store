package com.example.sof3011_ass.servlet;

import com.example.sof3011_ass.entity.ChucVu;
import com.example.sof3011_ass.repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {"/chuc-vu/hien-thi", "/chuc-vu/detail", "/chuc-vu/add",
        "/chuc-vu/delete", "/chuc-vu/update"})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/hien-thi")) {
            List<ChucVu> listCV = cvRepository.getAll();
            request.setAttribute("listCV", listCV);
            request.getRequestDispatcher("/view/chuc-vu.jsp").forward(request, response);
        } else if (uri.contains("/detail")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu chucVu = cvRepository.getById(id);
            request.setAttribute("cv", chucVu);
            request.getRequestDispatcher("/view/chuc-vu-detail.jsp").forward(request, response);
        } else if (uri.contains("/delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            cvRepository.delete(id);
            request.getRequestDispatcher("/chuc-vu/hien-thi").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);
            cvRepository.add(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if (uri.contains("/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu cv = new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);
            cvRepository.update(cv, id);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}

