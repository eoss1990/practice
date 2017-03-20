package compress;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

/**
 * Created by yangyu on 2017/3/14.
 */
public class ZipCompress {

    /**
     * compress
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        ZipArchiveOutputStream zipout = new ZipArchiveOutputStream(
                new FileOutputStream("/Users/yangyu/Downloads/compress.zip"));
        zipout.setEncoding("UTF-8");
        ZipArchiveEntry entry = new ZipArchiveEntry("myclass.drp");
        zipout.putArchiveEntry(entry);
        FileInputStream in = new FileInputStream("/Users/yangyu/Downloads/myclass");
        int i;
        while ((i = in.read(buffer)) != -1) {
            zipout.write(buffer, 0, i);
        }
        zipout.closeArchiveEntry();
        zipout.close();
        in.close();

    }

    @Test
    public void deCompress() throws Exception {
        ZipFile zipFile = new ZipFile("/Users/yangyu/Downloads/compress.zip", "UTF-8");
        Enumeration<ZipArchiveEntry> entrys = zipFile.getEntries();
        while (entrys.hasMoreElements()) {
            ZipArchiveEntry entry = entrys.nextElement();
            BufferedReader in = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }

        }
        zipFile.close();
    }
}
