package com.config;

import com.blog.Blog;
import com.controller.HelloController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		// 设置渲染视图
		// me.setViewType(ViewType.JSP);
		// 加载外部配置文件
		PropKit.use("system_info.txt");
		// 设置开发模式
		me.setDevMode(PropKit.getBoolean("devMode", false));
		// 设置编码
		me.setEncoding("utf-8");
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		// 设置翻页的数量的方法
		me.addSharedFunction("common/_foot.html");
		me.addSharedFunction("common/_add.html");
	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		C3p0Plugin p = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		// 配置C3p0数据库连接池插件
		me.add(p);
		// 配置ActiveRecordPlugin插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(p);
		// 默认blog表的id字段是id
		arp.addMapping("blog", Blog.class);
		// 设置发 sql 文件存放的基础路径
		arp.setBaseSqlTemplatePath(PathKit.getRootClassPath());
		arp.addSqlTemplate("demo.sql");
		// 配置属性名(字段名)大小写不敏感容器工厂
		arp.setContainerFactory(new CaseInsensitiveContainerFactory());
		me.add(arp);
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add("/hello", HelloController.class, "/");
	}

}
