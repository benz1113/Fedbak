package com.questioner.controller;

import com.questioner.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@Controller
public class UEditorController{
    @RequestMapping("/ueditor/exec")
    public void ueditorIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String rootPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        rootPath = URLDecoder.decode(rootPath, "utf-8");
        PrintWriter out = response.getWriter();
        out.write(new ActionEnter( request, rootPath ).exec());
    }

}
