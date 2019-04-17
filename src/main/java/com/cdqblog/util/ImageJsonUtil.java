package com.cdqblog.util;

import com.cdqblog.model.Photo;
import net.sf.json.JSONObject;

import java.util.Date;

public class ImageJsonUtil {

    public static Photo toPhoto(String json){
        Photo photo=new Photo();
        JSONObject object=JSONObject.fromObject(json);
        JSONObject data=object.getJSONObject("data");
        photo.setDelete(data.getString("delete"));
        photo.setFilename(data.getString("filename"));
        photo.setHash(data.getString("hash"));
        photo.setHeight(data.getLong("height"));
        photo.setWidth(data.getInt("width"));
        photo.setPath(data.getString("path"));
        photo.setSize(data.getInt("size"));
        photo.setTimestamp(new Date());
        photo.setUrl(data.getString("url"));
        photo.setStorename(data.getString("storename"));
        return photo;
    }

}
