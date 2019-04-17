package com.cdqblog;

import com.cdqblog.controller.*;
import com.cdqblog.interceptor.HrefInterceptor;
import com.cdqblog.interceptor.IpInterceptor;
import com.cdqblog.interceptor.UrlInterceptor;
import com.cdqblog.interceptor.UserNameInterceptor;
import com.cdqblog.model.Article;
import com.cdqblog.model.Articletype;
import com.cdqblog.model.Photo;
import com.cdqblog.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.json.JacksonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * API引导式配置
 */
public class Config extends JFinalConfig {
	
	/**
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 * 
	 * 使用本方法启动过第一次以后，会在开发工具的 debug、run config 中自动生成
	 * 一条启动配置，可对该自动生成的配置再添加额外的配置项，例如 VM argument 可配置为：
	 * -XX:PermSize=64M -XX:MaxPermSize=256M
	 */
	public static void main(String[] args) {
		/**
		 * 特别注意：Eclipse 之下建议的启动方式
		 */
//		JFinal.start("src/main/webapp/", 80, "/", 5);
		
		/**
		 * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
		 */
		 JFinal.start("src/main/webapp", 80, "/");
	}
	
	/**
	 * 配置常量
	 */
	public void configConstant(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("global_config.properties");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setInjectDependency(true);
		me.setJsonFactory(new JacksonFactory());
	}
	
	/**
	 * 配置路由
	 */
	public void configRoute(Routes me) {
		me.add("/cdqblog", IndexController.class, "/view");	// 第三个参数为该Controller的视图存放路径
		me.add("/cdqblog/blog", BlogController.class,"/view");			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
		me.add("/cdqblog/article",ArticleController.class,"/view");
		me.add("/cdqblog/comment",CommentController.class,"/view");
		me.add("/cdqblog/login",LoginController.class,"/view");
		me.add("/cdqblog/user",UserController.class,"/view");
		me.add("/cdqblog/admin",ManagerController.class,"/view/admin");
		me.add("/cdqblog/test",TestController.class,"/view");
		me.add("/cdqblog/uediter",UEditerController.class,"/uediter/utf8-jsp");
		me.add("/cdqblog/articleType",ArticleTypeController.class,"/view");
		me.add("/cdqblog/notice",NoticeController.class,"/view");
		me.add("/cdqblog/photo",PhotoController.class,"/view");
	}
	
	public void configEngine(Engine me) {
//		me.addSharedFunction("/common/_layout.html");
//		me.addSharedFunction("/common/_paginate.html");
		me.setDevMode(true);

	}
	
	/**
	 * 配置插件
	 */
	public void configPlugin(Plugins me) {
		// 配置 druid 数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(druidPlugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
		_MappingKit.mapping(arp);
		me.add(arp);
	}
	
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		me.add(new SessionInViewInterceptor());
		me.add(new IpInterceptor());
		me.add(new UserNameInterceptor());
		me.add(new UrlInterceptor());
		me.add(new HrefInterceptor());
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
}
