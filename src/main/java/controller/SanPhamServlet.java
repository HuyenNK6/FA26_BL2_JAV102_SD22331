package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.SanPhamRepository;

import java.io.IOException;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/view", //GET
        "/san-pham/detail",//GET
        "/san-pham/delete",//GET
        "/san-pham/view-update",//GET
        "/san-pham/update",//POST
        "/san-pham/add"//POST
})
public class SanPhamServlet extends HttpServlet {
    SanPhamRepository sanPhamRepository= new SanPhamRepository();
    //doGet + tab

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("view")){
            view(req,resp); //gọi trước, tạo sau -> hover chuột lên chữ view -> Create method....
        }else if(uri.contains("detail")){
            detail(req,resp);
        } else if(uri.contains("delete")){
            delete(req,resp);
        } else if(uri.contains("view-update")){
            viewUpdate(req,resp);
        }

    }
    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSanPham", sanPhamRepository.getAll());
        req.getRequestDispatcher("/san-pham/view.jsp").forward(req,resp);
    }
    private void detail(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) {
    }

    //doPost + tab
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
