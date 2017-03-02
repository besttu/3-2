package com.controller;

import java.util.List;

import com.blog.Blog;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.validator.BlogValidator;

public class HelloController extends Controller {
	int id = 0;

	public void index() {
		renderTemplate("index.html");
	}

	public void find() {
		String sql = Blog.blog.dao().getSql("fingid");
		List<Blog> lb = Blog.blog.dao().find(sql, 1);
		renderText(lb.toString());
	}

	/**
	 * 翻页功能的实现
	 */
	public void page() {

		int pageNumber = 1;
		int pageSize = 5;
		try {
			pageNumber = Integer.parseInt(getPara("pageNumber"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			pageSize = Integer.parseInt(getPara("pageSize"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Page<Blog> p_blog = Blog.blog.dao().paginate(pageNumber, pageSize);
		setAttr("bg", p_blog);
		renderTemplate("index.html");
	}

	/**
	 * 通过id删除
	 */
	public void delete() {
		int id = getParaToInt("did");
		Blog.blog.dao().deleteById(id);
		page();
	}

	/**
	 * 添加数据
	 */
	public void add() {
		renderTemplate("add.html");
	}

	public void doadd() {
		Blog b = getModel(Blog.class, "b");
		b.save();
		page();
	}

	// 页面的修改
	public void edit() {
		setAttr("b", Blog.blog.dao().findById(getParaToInt()));
		id = getParaToInt();
		renderTemplate("edit.html");
	}

	// 页面的更新
	@Before(BlogValidator.class)
	public void updata() {
		getModel(Blog.class,"b").update();
		page();
	}

}
