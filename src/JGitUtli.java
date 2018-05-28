import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JGitUtli {
    public static void main(String[] args) {
        for (int j = 1; j <= 53; j++) {
//            File file = new File("res/url/");
//            File[] files = file.listFiles();
//            for (int i = 0; i < files.length; i++) {
//                FileUtil.copyFileUsingFileStreams(files[i].getAbsoluteFile(), new File("res/url/" + files[i].getName()));
//            }
            List<String> strings = FileUtil.readLineFile("res/url/youguowang" + j + ".txt");
            for (int i = 0; i < strings.size(); i++) {
                FileUtil.printFile("res/url/youguowang_url.txt", strings.get(i) + "\r\n", true);
            }
        }
    }

    @Test
    public void read() {
        List<String> strings = FileUtil.readLineFile("res/xixiwang1/xixiwang1.txt");
        for (int i = 0; i < strings.size(); i++) {
            FileUtil.printFile("res/img_url.txt", strings.get(i) + "\r\n", true);
        }
    }

//    @Test
//    public void test() {
//        File file = new File("res/url/");
//        String[] files = file.list();
//        for (int i = 0; i < files.length; i++) {
//            System.out.println("还是:"+files[i]);
//            List<String> strings = FileUtil.readLineFile("res/url/" + files[i]);
//            FileUtil.printFile("res/url/" + files[i], "", false);
//            for (int j = 0; j < strings.size(); j++) {
//                if(strings.get(j).isEmpty()){
//                    continue;
//                }
//                String url = strings.get(j).split("=")[1];
//                url = url.replace("html", "txt");
//                url = url.substring(url.lastIndexOf("/") + 1, url.length());
//                String url1 = files[i].replace("_url.txt", "");
//                String img = FileUtil.readLineFile("res/img/" + url1 + "/" + url).get(0).split("=")[1];
//                img = strings.get(j) + "=" + img;
//                FileUtil.printFile("res/url/" + files[i], img + "\r\n", true);
//            }
//        }
//    }
}
