package commons_net;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileOutputStream;

/**
 * Created by yangyu on 2017/3/20.
 */
public class TestFtpClient {

    private static String server = "10.5.6.169";

    private static String name = "download";

    private static String passWord = "download";

    public static void main(String[] args) throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(server);
        ftpClient.login(name,passWord);
        FTPFile[] ftpFiles = ftpClient.listDirectories();
        for (FTPFile ftpFile : ftpFiles){
            System.out.println(ftpFile.getName());
        }
        ftpClient.retrieveFile("/CtpRun/v5version.txt", new FileOutputStream("/Users/yangyu/Downloads/v5version.txt"));
    }
}
