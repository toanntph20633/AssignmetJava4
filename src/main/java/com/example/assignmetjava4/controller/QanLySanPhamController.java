package com.example.assignmetjava4.controller;

import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.service.BrandService;
import com.example.assignmetjava4.service.LaptopService;
import com.example.assignmetjava4.service.impl.LaptopServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "QanLySanPhamController", value = {
        "/list",
        "/view-add",
        "/view-update",
        "/add",
        "/update",
        "/delete",
        "/detail",
})
public class QanLySanPhamController extends HttpServlet {
        private static final LaptopService LAPTOP_SERVICE = new LaptopServiceImpl();
        private static final BrandService BRAND_SERVICE = new Br
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        switch (uri) {
            case "/list": {
                this.getList(request, response);
                break;
            }
            case "/view-add": {
                this.viewAdd(request, response);
                break;
            }
            case "/view-update": {
                this.viewUpdate(request, response);
                break;
            }
            case "/detail": {
                this.getDetail(request, response);
                break;
            }
            case "/delete": {
                this.delete(request, response);
                break;
            }
            default: {

                break;
            }
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void getDetail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
