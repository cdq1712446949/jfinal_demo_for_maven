package com.cdqblog.dao;

import com.cdqblog.model.Article;
import com.cdqblog.model.Articletype;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class ArticleTypeDAO {

    public Page<Articletype> findArticleTypeByPn(int pn) {
        return Articletype.dao.paginate(pn, 10, "select * ", "from articletype");
    }

    public Articletype findArticleTypeById(long id) {
        return Articletype.dao.findById(id);
    }

    public boolean changeStatus(long id, int status) {
        Articletype articletype = new Articletype();
        articletype.setId(id);
        articletype.setStatus(status);
        return articletype.update();
    }

    public boolean add(Articletype articletype) {
        return articletype.save();
    }

    public List<Articletype> getAllArticle(){
        return Articletype.dao.find("select * from articletype where status=?",0);
    }

}
