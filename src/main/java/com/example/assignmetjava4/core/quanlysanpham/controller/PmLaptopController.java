package com.example.assignmetjava4.core.quanlysanpham.controller;

import com.example.assignmetjava4.core.quanlysanpham.entity.request.PnLaptopReq;
import com.example.assignmetjava4.core.quanlysanpham.service.PmBrandService;
import com.example.assignmetjava4.core.quanlysanpham.service.PmLaptopService;
import com.example.assignmetjava4.core.quanlysanpham.service.impl.PmBrandServiceImpl;
import com.example.assignmetjava4.core.quanlysanpham.service.impl.PmLaptopServiceImpl;
import com.example.assignmetjava4.entity.Laptop;
import com.example.assignmetjava4.entity.LaptopDetail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;

@MultipartConfig()
@WebServlet(name = "PmLaptopController", value = {
        "/quan-ly/quan-ly-san-pham/laptop/list",
        "/quan-ly/quan-ly-san-pham/laptop/view-add",
        "/quan-ly/quan-ly-san-pham/laptop/view-update",
        "/quan-ly/quan-ly-san-pham/laptop/add-or-update",
        "/quan-ly/quan-ly-san-pham/laptop/delete"})
public class PmLaptopController extends HttpServlet {
    private static final PmLaptopService LAPTOP_SERVICE = new PmLaptopServiceImpl();
    private static final PmBrandService PM_BRAND_SERVICE = new PmBrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("laptop/list")) {
            this.getList(request, response);
        } else if (uri.contains("laptop/view-add")) {
            this.getViewAdd(request, response);
        } else if (uri.contains("laptop/view-update")) {
            this.getViewUpdate(request, response);
        } else if (uri.contains("laptop/delete")) {
            this.delete(request, response);
        }
    }

    private void getViewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String page = request.getParameter("page");
        int sizePage = LAPTOP_SERVICE.pageSizeLaptopDetail(id);
        if (!"".equals(id)) {
            Laptop laptop = LAPTOP_SERVICE.detail(id);
            request.setAttribute("listBrand", PM_BRAND_SERVICE.getAll());
            request.setAttribute("laptop", laptop);
            request.setAttribute("page", page);
            request.setAttribute("sizePage", sizePage);
            request.setAttribute("listDetail", LAPTOP_SERVICE.getListDetailByLaptopId(id, Integer.parseInt(page)));
            request.getRequestDispatcher("/views/quanlysp/view-save-update-laptop.jsp").forward(request, response);
        }
    }

    private void getViewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBrand", PM_BRAND_SERVICE.getAll());
        request.getRequestDispatcher("/views/quanlysp/view-save-update-laptop.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            LAPTOP_SERVICE.delete(id);
            getList(request, response);
        }
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page;
        if (Objects.isNull(request.getParameter("page"))) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("listLaptop", LAPTOP_SERVICE.getAll(page));
        request.setAttribute("page",page);
        request.setAttribute("pageSize", LAPTOP_SERVICE.pageSizeLaptop());
        request.getRequestDispatcher("/views/quanlysp/quan-ly-san-pham.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("laptop/add-or-update")) {
            this.addOfUpdate(request, response);
        }
    }

    @SneakyThrows
    private void addOfUpdate(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String id = request.getParameter("uid");
        String soLuong = request.getParameter("soLuong");
        PnLaptopReq req = new PnLaptopReq();
        BeanUtils.populate(req, request.getParameterMap());
        Part photo = request.getPart("image");
        String realPathImg = request.getServletContext().getRealPath("/image");
        String pathImg = Path.of(photo.getSubmittedFileName()).getFileName().toString();
        if (!"".equals(pathImg)) {
            if (!Files.exists(Path.of(realPathImg))) {
                Files.createDirectory(Path.of(realPathImg));
            }
            photo.write(realPathImg + "/" + pathImg);
            req.setImages("/image/" + pathImg);
        }
        if (id == null || "".equals(id)) {
            LAPTOP_SERVICE.save(req, soLuong);
        } else {
            req.setId(id);
            LAPTOP_SERVICE.update(req);
        }
        getList(request, response);
    }
}
