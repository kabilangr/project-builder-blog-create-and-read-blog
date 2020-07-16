package dao;

import java.util.List;

import model.Blog;

public interface BlogDaoInterface
{
	public void insertBlog(Blog blog);
	public List<Blog> selectAllBlogs();

}