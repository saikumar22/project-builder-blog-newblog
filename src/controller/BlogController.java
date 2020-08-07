package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Blog;

@WebServlet(urlPatterns= {"/blog"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogDetails = request.getParameter("selectedAnswers");
		String[] blogDate = blogDetails.split(",");
		String blogTitle = blogDate[0];
		String blogdescription = blogDate[1];
		LocalDate blogDate1 = LocalDate.now();
		
		Blog blog=new Blog(blogTitle, blogdescription, blogDate1);
		blog.setTitle(blogTitle);
		blog.setDescription(blogdescription);
		blog.setPostedOn(blogDate1);
		
		System.out.println("Blog Title: "+blog.getTitle());
		System.out.println("Blog Description: "+blog.getDescription());
		System.out.println("Posted on: "+blog.getPostedOn());

		if(blog!=null) {
			request.setAttribute("blog", blog);
			Object user = null;
			request.setAttribute("user",user);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		
	}

}
