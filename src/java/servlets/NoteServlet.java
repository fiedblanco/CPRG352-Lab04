/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;
import domain.Note;
import java.util.*;

/**
 *
 * @author 854276
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //reading the file content to the view page
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String fileLine;
        while ((fileLine = br.readLine()) != null) {
            lines.add(fileLine);
        }

        String titleLine = lines.get(0);
        String contentLine = lines.get(1);
        Note note = new Note(titleLine, contentLine);
        request.setAttribute("note", note);
        System.out.println(note.getTitle());
        //to determine which jsp to display
        String edit = request.getParameter("edit");

        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

        } else {

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        String entered_title = request.getParameter("titleEdit");
        String entered_content = request.getParameter("contentEdit");


        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        pw.println(entered_title);
        pw.println(entered_content);
        pw.close();

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String fileLine;
        while ((fileLine = br.readLine()) != null) {
            lines.add(fileLine);
        }

        String titleLine = lines.get(0);
        String contentLine = lines.get(1);
        Note note = new Note(titleLine, contentLine);
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
