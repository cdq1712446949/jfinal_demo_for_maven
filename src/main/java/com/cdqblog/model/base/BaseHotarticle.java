package com.cdqblog.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseHotarticle<M extends BaseHotarticle<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setArticleId(java.lang.Long articleId) {
		set("article_id", articleId);
		return (M)this;
	}
	
	public java.lang.Long getArticleId() {
		return getLong("article_id");
	}

}
