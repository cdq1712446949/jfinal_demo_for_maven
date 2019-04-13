package com.cdqblog.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseArticle<M extends BaseArticle<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Long id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Long getId() {
		return getLong("id");
	}

	public M setTitle(java.lang.String title) {
		set("title", title);
		return (M)this;
	}
	
	public java.lang.String getTitle() {
		return getStr("title");
	}

	public M setIntroduce(java.lang.String introduce) {
		set("introduce", introduce);
		return (M)this;
	}
	
	public java.lang.String getIntroduce() {
		return getStr("introduce");
	}

	public M setContent(java.lang.String content) {
		set("content", content);
		return (M)this;
	}
	
	public java.lang.String getContent() {
		return getStr("content");
	}

	public M setNumLook(java.lang.Long numLook) {
		set("num_look", numLook);
		return (M)this;
	}
	
	public java.lang.Long getNumLook() {
		return getLong("num_look");
	}

	public M setNumComment(java.lang.Integer numComment) {
		set("num_comment", numComment);
		return (M)this;
	}
	
	public java.lang.Integer getNumComment() {
		return getInt("num_comment");
	}

	public M setSrc(java.lang.String src) {
		set("src", src);
		return (M)this;
	}
	
	public java.lang.String getSrc() {
		return getStr("src");
	}

	public M setType(java.lang.Integer type) {
		set("type", type);
		return (M)this;
	}
	
	public java.lang.Integer getType() {
		return getInt("type");
	}

	public M setCreatedDate(java.util.Date createdDate) {
		set("createdDate", createdDate);
		return (M)this;
	}
	
	public java.util.Date getCreatedDate() {
		return get("createdDate");
	}

	public M setStatus(java.lang.Integer status) {
		set("status", status);
		return (M)this;
	}
	
	public java.lang.Integer getStatus() {
		return getInt("status");
	}

}