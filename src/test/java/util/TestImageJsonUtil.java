package util;

import com.cdqblog.model.Photo;
import com.cdqblog.service.PhotoService;
import com.cdqblog.service.impl.PhotoServiceImpl;
import com.cdqblog.util.ImageJsonUtil;
import org.junit.Test;

public class TestImageJsonUtil {

    @Test
    public void testImage(){
        PhotoService photoService=new PhotoServiceImpl();
        String imge="{\n" +
                "  \"code\": \"success\",\n" +
                "  \"data\": {\n" +
                "    \"width\": 140,\n" +
                "    \"height\": 100,\n" +
                "    \"filename\": \"1.jpg\",\n" +
                "    \"storename\": \"5cb699a378461.jpg\",\n" +
                "    \"size\": 9294,\n" +
                "    \"path\": \"/2019/04/17/5cb699a378461.jpg\",\n" +
                "    \"hash\": \"LzmE1YuIt6vUNOc\",\n" +
                "    \"timestamp\": 1555470755,\n" +
                "    \"ip\": \"122.5.7.138\",\n" +
                "    \"url\": \"https://i.loli.net/2019/04/17/5cb699a378461.jpg\",\n" +
                "    \"delete\": \"https://sm.ms/delete/LzmE1YuIt6vUNOc\"\n" +
                "  }\n" +
                "}";
        Photo photo=ImageJsonUtil.toPhoto(imge);
        photoService.addPhoto(photo);
        System.out.println(photo.getUrl());
    }

}
