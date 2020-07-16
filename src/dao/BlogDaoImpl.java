package dao;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl
{
	public void insertBlog(Blog blog) throws ClassNotFoundException, SQLException, IOException
	{
		ConnectionManager ob=new ConnectionManager();
		String sql="insert into blog(id,blog_title,blog_description,postedon)values(?,?,?,?)";
		PreparedStatement ps=ob.getConnection().prepareStatement(sql);
		ps.setInt(1, blog.getBlogId());
		ps.setString(2, blog.getBlogTitle());
		ps.setString(3, blog.getBlogDescription());
		Date date = Date.valueOf(blog.getPostedOn());
		ps.setDate(4, date);
		ob.getConnection().close();
		System.out.println("DONE");
	}
	public List<Blog> selectAllBlogs() throws ClassNotFoundException, SQLException, IOException
	{
		List<Blog> list=new ArrayList<Blog>();
		ConnectionManager ob=new ConnectionManager();
		String sql="select * from blog order by name asc";
		Statement st=ob.getConnection().createStatement();
		ResultSet rs=st.executeQuery(sql);
		Blog blog=null;
		while(rs.next())
		{
			blog=new Blog();
			blog.setBlogId(rs.getInt("id"));
			blog.setBlogTitle(rs.getString("blog_title"));
			blog.setBlogDescription(rs.getString("blog_description"));
			java.sql.Date date = (java.sql.Date) rs.getDate("postedon");
			blog.setPostedOn(date.toLocalDate());
			list.add(blog);
		}
		ob.getConnection().close();
		System.out.println("DONE");
		return list;
	}
}