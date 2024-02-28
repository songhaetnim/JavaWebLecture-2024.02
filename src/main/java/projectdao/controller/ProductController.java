package projectdao.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import projectdao.entilty.Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@WebServlet({"/bbs/product/insert", "/bbs/product/view"})
@MultipartConfig(
   fileSizeThreshold = 1 * 1024 * 1024,         // 1 MB
   maxFileSize = 10 * 1024 * 1024,               // 10 MB
   maxRequestSize = 10 * 1024 * 1024
)
public class ProductController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   public static final String UPLOAD_PATH = "c:/Temp/upload/bbs" ;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String[] uri = request.getRequestURI().split("/");
      String action = uri[uri.length - 1];
      String method = request.getMethod();
      HttpSession session = request.getSession();
      RequestDispatcher rd = null;
      
      switch(action) {
      case "insert" :
         if (method.equals("GET")) {
            rd = request.getRequestDispatcher("/WEB-INF/view/product/insert.jsp");
            rd.forward(request, response);
         } else {
            String category = request.getParameter("category");
            String pname = request.getParameter("pname");
            String price_ = request.getParameter("price");
            int price = Integer.parseInt(price_);
            String dectiption = request.getParameter("dectiption");
            
            Part filePart = request.getPart("imgFile");         // 파일값 받아오기
            String filenaem = filePart.getSubmittedFileName();   // 파일 이름 추출
            
            // 스키.jpg --> category + 현재날짜 .jpg
            // jsp만 뽑기
            String[] ext = filenaem.split("\\.");
            String extension = ext[ext.length - 1];
            //           카테고리명       현재시간             .   파일명(jsp)
            String fname = category + System.currentTimeMillis() + "." + extension;
            //            위치         
            String path = UPLOAD_PATH + "/" + fname;
            filePart.write(path);
            
            Product product = new Product(category, pname, price, dectiption, fname);
            rd = request.getRequestDispatcher("/WEB-INF/view/product/detail.jsp");
            request.setAttribute("product", product);
            rd.forward(request, response);
         }
         break;
      
      case "view" : 
         byte[] buffer = new byte[8*1024];      // 8 KB buffer
         String fname = request.getParameter("filename");
         String path = UPLOAD_PATH + "/" + fname;
         OutputStream os = response.getOutputStream();
         response.setContentType("text/html; charset=utf-8");
         response.setHeader("Cache-Control", "no-cache");
         response.setHeader("Content-disposition", "attachment; fileName=" +
                        URLEncoder.encode(fname, "utf-8"));
         
         FileInputStream fis = new FileInputStream(path);
         while (true) {
            int count = fis.read(buffer);
            if (count == -1)
               break;
            os.write(buffer, 0, count);
         }
         fis.close(); os.close();
         break;
      }
   }

}
