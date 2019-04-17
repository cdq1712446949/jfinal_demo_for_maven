package util;

import com.cdqblog.util.OkHttpUtil;
import org.junit.Test;

import java.io.File;

public class TestOkHttpUtil {

    @Test
    public void testOkHttp(){
//        OkHttpUtil okHttpUtil=new OkHttpUtil();
        OkHttpUtil.postUrl("https://sm.ms/api/upload",new File("/resources/test.png"));
    }

}
