package com.example.assignmetjava4.controller;

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
        "/gioi-thieu"
})
public class HomeServlet extends HttpServlet {
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
        } else if (uri.contains("trang-chu")) {
            this.gioiThieu(request, response);
        } else {
            this.trangChu(request, response);
        }
    }

    private void gioiThieu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void sanPham(HttpServletRequest request, HttpServletResponse response) {
    }

    private void quenMatKhau(HttpServletRequest request, HttpServletResponse response) {
    }

    private void khachHangInfo(HttpServletRequest request, HttpServletResponse response) {
    }

    private void gioHang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void trangChu(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
