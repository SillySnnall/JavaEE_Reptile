import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // ---------------------通过标签url获取封面-------------------
        for (int i = 40; i < Url.urlU.length; i++) {
            int num = getCover(Url.urlU[i], true);
            System.out.println(Url.urlU[i] + "  完成度:1/" + num);
            for (int j = 2; j <= num; j++) {
                String url = Url.urlU[i].replace(".html", "/" + j + ".html");
                getCover(url, false);
                System.out.println(Url.urlU[i] + "  完成度:" + j + "/" + num);
            }
            System.out.println(Url.urlU[i] + "  总进度:" + i + "/" + Url.urlU.length);
        }
    }

    private static String fileName;

    /**
     * 获取封面
     */
    private static int getCover(String url, boolean isNum) {
        String mainUrl = "https://www.aitaotu.com";
        String dom;
        String[] split = new String[0];
        try {
            dom = UrlReqUtil.get(url);
            split = dom.split("<a class=\"Pli-litpic\"");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            getCover(url, isNum);
        }
        int num = 0;
        for (int j = 1; j < split.length; j++) {
            String replace = split[j].replace("\r\n", "");
            String title = replace.substring(replace.indexOf("title=\"") + "title=\"".length(), replace.indexOf("\">"));
            String urlz = replace.substring(replace.indexOf("href=\"") + "href=\"".length(), replace.indexOf("\" target"));
            String substring = title + "=" + mainUrl + urlz;
            if (isNum) {
                fileName = url.replace(mainUrl + "/tag/", "").replace(".html", "_url.txt");
            } else {
//                fileName = url.replace(mainUrl + "/tag/", "").replace("/", "").replace(j+".html", "_url.txt");
            }
            String dir = "res/url/";
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdirs();
            }

            FileUtil.printFile(dir + "/" + fileName, substring + "\r\n", true);
            System.out.println("条目完成写入:" + j + "/" + (split.length - 1));
            if (isNum && j == split.length - 1) {
                int index = replace.indexOf(".html\">末页</a></span>");
                if (index == -1) {
                    return 1;
                }
                String substring1 = replace.substring(0, index);
                int numIndex = substring1.lastIndexOf("/") + 1;
                num = Integer.parseInt(replace.substring(numIndex, substring1.length()));
            }

            // -------------------通过封面url获取详情----------------------
//            int num1 = getDetailed(mainUrl + urlz, dir, true);
//            System.out.println(mainUrl + urlz + ">>详情第1页完成");
//            for (int k = 2; k <= num1; k++) {
//                String url1 = mainUrl + urlz.replace(".html", "_" + k + ".html");
//                getDetailed(url1, dir, false);
//                System.out.println(mainUrl + urlz + ">>详情第" + k + "页完成");
//            }
        }
        return num;
    }

    @Test
    public void detailed() {
        List<String> strings = FileUtil.readLineFile("res/url/" + Url.fileF[0]);
        for (int j = 143; j < strings.size(); j++) {
            String url = strings.get(j).split("=")[1];

//         -------------------通过封面url获取详情----------------------
            int num1 = getDetailed(url, "res/img", true);
            System.out.println(url + "  完成度:1/" + num1);
            for (int k = 2; k <= num1; k++) {
                String url1 = url.replace(".html", "_" + k + ".html");
                getDetailed(url1, "res/img", false);
                System.out.println(url1 + "  完成度:" + k + "/" + num1);
            }
            System.out.println(url + "  总进度:" + (j + 1) + "/" + strings.size());
        }
    }


    /**
     * 获取详细数据
     *
     * @return
     */
    private static int getDetailed(String url, String preDir, boolean isNum) {
        String dom;
        String substring;
        String[] split = new String[0];
        try {
            dom = UrlReqUtil.get(url);

            substring = dom.substring(dom.indexOf("<p align=\"center\">"), dom.indexOf("<div class=\"photo-fbl\">"));

            split = substring.split("\" /></a>");
        } catch (Exception e) {
            getDetailed(url, preDir, isNum);
        }
        int num = 0;
        for (int j = 0; j < split.length; j++) {
            if (j != split.length - 1) {
                String imgUrl = split[j].substring(split[j].indexOf("<img src=\"") + "<img src=\"".length(), split[j].indexOf("\" alt=\""));
                String imgName = split[j].substring(split[j].indexOf("\" alt=\"") + "\" alt=\"".length(), split[j].length());
                String substring1 = imgName + "=" + imgUrl;
                String mainurl = url.substring(0, url.lastIndexOf("/") + 1);
                if (isNum) {
                    fileName = url.replace(mainurl, "").replace(".html", ".txt");
                } else {
//                    fileName = url.replace(mainurl, "").replace(".html", ".txt");
                }
//            String dir = preDir + "/" + fileName.substring(0, fileName.lastIndexOf("_"));
                String dir = preDir;
                File file = new File(dir);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileUtil.printFile(dir + "/" + fileName, substring1 + "\r\n", true);
                System.out.println("条目完成写入:" + (j + 1) + "/" + (split.length - 1));
            } else {
                int index = split[j].lastIndexOf(".html\">末页</a></li>");
                if (index == -1) {
                    return 1;
                }
                num = Integer.parseInt(split[j].substring(split[j].lastIndexOf("_") + "_".length(), index));
            }
        }
        return num;
    }
}
