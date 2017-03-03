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
	 * 缈婚〉鍔熻兘鐨勫疄鐜�
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

	public void delete() {
		int id = getParaToInt("did");
		Blog.blog.dao().deleteById(id);
		page();
	}

	public void add() {
		renderTemplate("meger.html");
	}

	public void doadd() {

		if (getParaToInt() == null) {
			Blog b = getModel(Blog.class, "b");
			b.save();
			page();
		} else {
			System.out.println("updata");
			getModel(Blog.class, "b").update();
			page();
		}

	}

	public void edit1() {
		setAttr("b", Blog.blog.dao().findById(getPara("up")));
		renderTemplate("meger.html");
	}

	public void updata1() {
		getModel(Blog.class, "b").update();
		page();
	}

	// 更新数据
	public void updata() {
		getModel(Blog.class, "b").update();
		page();
	}

}
