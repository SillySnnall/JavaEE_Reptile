import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    /**
     * 文件写入
     *
     * @param fileName
     * @param content
     * @param isAppend
     */
    public static void printFile(String fileName, String content, boolean isAppend) {
        BufferedWriter bw = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), isAppend);
            bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件读取，一行一行读取
     *
     * @param filename
     * @return
     */
    public static List<String> readLineFile(String filename) {
        List<String> data = new ArrayList<>();
        try {
            FileInputStream in = new FileInputStream(filename);
            InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
            BufferedReader bufReader = new BufferedReader(inReader);
            String line = null;
            int i = 1;
            while ((line = bufReader.readLine()) != null) {
                data.add(line);
//                System.out.println("第" + i + "行：" + line);
                i++;
            }
            bufReader.close();
            inReader.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取" + filename + "出错！");
        }
        return data;
    }

    /**
     * 文件复制
     *
     * @param source
     * @param dest
     * @throws IOException
     */
    public static void copyFileUsingFileStreams(File source, File dest) {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (Exception e) {

        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
