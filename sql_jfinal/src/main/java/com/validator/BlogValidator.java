package com.validator;

import com.blog.Blog;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class BlogValidator extends Validator {

	@Override
	protected void handleError(Controller controller) {
		// TODO Auto-generated method stub
		// controller.keepModel(Blog.class);
		controller.keepModel(Blog.class, "b");
		controller.render("edit.html");
	}

	@Override
	protected void validate(Controller controller) {
		// TODO Auto-generated method stub
		validateRequired("b.title", "titleMsg", "请输入Blog标题!");
		validateRequired("b.content", "contentMsg", "请输入contentMsg!");
		System.out.println(getActionKey());
	}

}
