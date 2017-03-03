package com.validator;

import com.blog.Blog;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class BlogValidator extends Validator {

	@Override
	protected void handleError(Controller controller) {
		// TODO Auto-generated method stub
		// controller.keepModel(Blog.class);
		String actionKey = getActionKey();
		controller.keepModel(Blog.class, "b");
		if (actionKey.equals("/hello/doadd"))
			controller.render("add.html");
		else if (actionKey.equals("/hello/updata"))
			controller.render("edit.html");
	}

	@Override
	protected void validate(Controller controller) {
		// TODO Auto-generated method stub
		validateRequired("b.title", "titleMsg", "«Î ‰»ÎBlog±ÍÃ‚¢ò!");
		validateRequired("b.content", "contentMsg", "ËØ∑ËæìÂÖ•contentMsg!");
	}

}
