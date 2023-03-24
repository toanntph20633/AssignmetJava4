package com.example.assignmetjava4.controller;

import com.example.assignmetjava4.entity.Account;
import com.example.assignmetjava4.service.AccountService;
import com.example.assignmetjava4.service.impl.AccountServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HomeServlet", value = {
        "/trang-chu",
        "/gio-hang",
        "/thong-tin-khach-hang",
        "/quen-mat-khau",
        "/san-pham",
        "/gioi-thieu",
        "/dang-nhap",
        "/dang-ky"
})
public class HomeServlet extends HttpServlet {
    private static final AccountService ACCOUNT_SERVICE = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("trang-chu")) {
            this.trangChu(request, response);
        } else if (uri.contains("gio-hang")) {
            this.gioHang(request, response);
        } else if (uri.contains("thong-tin-khach-hang")) {
            this.khachHangInfo(request, response);
        } else if (uri.contains("quen-mat-khau")) {
            this.quenMatKhau(request, response);
        } else if (uri.contains("san-pham")) {
            this.sanPham(request, response);
        } else if (uri.contains("gioi-thieu")) {
            this.gioiThieu(request, response);
        } else if (uri.contains("dang-nhap")) {
            this.viewDangNhap(request, response);
        } else if (uri.contains("dang-ky")) {
            this.viewDangKy(request, response);
        } else {
            this.trangChu(request, response);
        }
    }

    private void viewDangKy(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewDangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
    }

    private void dangKy(HttpServletRequest request, HttpServletResponse response) {
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        try {
            Account account = ACCOUNT_SERVICE.login(username, pass);
            request.setAttribute("acc", account);
            request.getRequestDispatcher("/views/page/home.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mess", e.getMessage());
            request.getRequestDispatcher("/views/login/login.jsp").forward(request, response);
        }


    }

    private void gioiThieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void sanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/page/view-san-pham.jsp").forward(request, response);
    }

    private void quenMatKhau(HttpServletRequest request, HttpServletResponse response) {
    }

    private void khachHangInfo(HttpServletRequest request, HttpServletResponse response) {
    }

    private void gioHang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void trangChu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/page/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("dang-nhap")) {
            this.dangNhap(request, response);
        }
    }
}
