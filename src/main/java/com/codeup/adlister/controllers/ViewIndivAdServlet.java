package com.codeup.adlister.controllers;



import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/view")
public class ViewIndivAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        Ad ad = DaoFactory.getAdsDao().getOne(id);
        req.setAttribute("ad", ad);
        req.getRequestDispatcher("/WEB-INF/ads/view.jsp").forward(req, resp);
    }
}