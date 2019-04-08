import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/3/12 10:27
 * description:
 */
public class MyMain {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        String collect = String.join("", Files.readAllLines(Paths.get("D:\\gj-new\\es-analysis\\code\\yq_analysis\\data\\dictionary\\custom\\人名词典.txt"), StandardCharsets.UTF_8));

        ZHConverter tCcharacter = ZHConverter.getExample(ZHConverter.target.TCcharacter);
        System.out.println("tCcharacter = " + tCcharacter.transformation(collect));

        ZHConverter sCcharacter = ZHConverter.getExample(ZHConverter.target.SCcharacter);
        System.out.println("sCcharacter = " + sCcharacter.transformation(collect));

        MyMain.println(tCcharacter.transformation(collect), "tCcharacter");
        MyMain.println(tCcharacter.transformation(collect), "sCcharacter");

    }

    public static void println(String string, String path) {
        Path fpath = Paths.get(path);
        //创建文件
        if (!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //创建BufferedWriter
        try {
            BufferedWriter bfw = Files.newBufferedWriter(fpath);
            bfw.write(string);
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建BufferedReader
        try {
            BufferedReader bfr = Files.newBufferedReader(fpath);
            System.out.println(bfr.readLine());
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
