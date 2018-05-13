import com.sun.xml.internal.bind.v2.TODO;

public class Main {

    public static void main(String[] args) {

        String[] urlU = {"https://www.aitaotu.com/tag/xixiwang.html",
                "https://www.aitaotu.com/tag/youguowang.html",
                "https://www.aitaotu.com/tag/aiss.html",
                "https://www.aitaotu.com/tag/tuinvlang.html",
                "https://www.aitaotu.com/tag/rosi.html",
                "https://www.aitaotu.com/tag/ttns.html",
                "https://www.aitaotu.com/tag/tuinvshen.html",
                "https://www.aitaotu.com/tag/pansidong.html",
                "https://www.aitaotu.com/tag/xiurenwang.html",
                "https://www.aitaotu.com/tag/ddy.html",
                "https://www.aitaotu.com/tag/ligui.html",
                "https://www.aitaotu.com/tag/meituibaobei.html",
                "https://www.aitaotu.com/tag/meiyuanguan.html",
                "https://www.aitaotu.com/tag/meiyanshe.html",
                "https://www.aitaotu.com/tag/aimishe.html",
                "https://www.aitaotu.com/tag/beautyleg.html",
                "https://www.aitaotu.com/tag/vnvlang.html",
                "https://www.aitaotu.com/tag/jiamiannvhuang.html",
                "https://www.aitaotu.com/tag/mitaoshe.html",
                "https://www.aitaotu.com/tag/ruyixiezhen.html",
                "https://www.aitaotu.com/tag/3agirl.html",
                "https://www.aitaotu.com/tag/sibao.html",
                "https://www.aitaotu.com/tag/boluoshe.html",
                "https://www.aitaotu.com/tag/disi.html",
                "https://www.aitaotu.com/tag/sijianwu.html",
                "https://www.aitaotu.com/tag/aixiu.html",
                "https://www.aitaotu.com/tag/HeiSiAi.html",
                "https://www.aitaotu.com/tag/Leghacker.html",
                "https://www.aitaotu.com/tag/dongganzhixing.html",
                "https://www.aitaotu.com/tag/kelanvshen.html",
                "https://www.aitaotu.com/tag/MFStar.html",
                "https://www.aitaotu.com/tag/chizuzhe.html",
                "https://www.aitaotu.com/tag/qingdouke.html",
                "https://www.aitaotu.com/tag/youwuguan.html",
                "https://www.aitaotu.com/tag/simeivip.html",
                "https://www.aitaotu.com/tag/feilin.html",
                "https://www.aitaotu.com/tag/paimei.html",
                "https://www.aitaotu.com/tag/youmihui.html",
                "https://www.aitaotu.com/tag/tangyun.html",
                "https://www.aitaotu.com/tag/youxingguan.html",
                "https://www.aitaotu.com/tag/niceleg.html",
                "https://www.aitaotu.com/tag/shanghaixuancai.html",
                "https://www.aitaotu.com/tag/yannvshen.html",
                "https://www.aitaotu.com/tag/meixiu.html",
                "https://www.aitaotu.com/tag/girlt.html",
                "https://www.aitaotu.com/tag/xingleyuan.html",
                "https://www.aitaotu.com/tag/yunvlang.html",
                "https://www.aitaotu.com/tag/feituwang.html",
                "https://www.aitaotu.com/tag/huayan.html",
                "https://www.aitaotu.com/tag/sishangxiezhen.html",
                "https://www.aitaotu.com/tag/yingsihui.html",
                "https://www.aitaotu.com/tag/Tyingart.html",
                "https://www.aitaotu.com/tag/xiweisha.html",
                "https://www.aitaotu.com/tag/zhongguotuimo.html",
                "https://www.aitaotu.com/tag/tangsi.html",
                "https://www.aitaotu.com/tag/damingmowang.html",
                "https://www.aitaotu.com/tag/taste.html",
                "https://www.aitaotu.com/tag/moki.html",
                "https://www.aitaotu.com/tag/51modozazhi.html",
                "https://www.aitaotu.com/tag/maomengbang.html",
                "https://www.aitaotu.com/tag/tianshisheying.html",
                "https://www.aitaotu.com/tag/tangguohuabao.html",
                "https://www.aitaotu.com/tag/msjlb.html",
                "https://www.aitaotu.com/tag/tukmo.html"};

        // 标签
        for (int i = 0; i < urlU.length; i++) {
            String dom = UrlReqUtil.get("https://www.aitaotu.com/tag/tuinvlang.html");
            String[] split = dom.split("<a class=\"Pli-litpic\"");

            // 封面
            for (int i = 1; i < split.length; i++) {
                String title = split[i].substring(split[i].indexOf("title=\"") + "title=\"".length(), split[1].indexOf("\">"));
                String url = split[i].substring(split[i].indexOf("href=\"") + "href=\"".length(), split[1].indexOf("\" target"));
                String substring = title + "=https://www.aitaotu.com" + url;
                // 详情
                // TODO: 2018/5/12 ----------
                String dom1 = UrlReqUtil.get("https://www.aitaotu.com" + url);
                FileUtil.printFile("home2.txt",dom1);
                return;
            }
        }
    }
}
