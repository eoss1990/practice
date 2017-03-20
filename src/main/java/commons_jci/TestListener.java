package commons_jci;

import org.apache.commons.jci.listeners.FileChangeListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;

import java.io.File;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by yangyu on 2017/3/20.
 */
public class TestListener {

    static class MyFileChangeListener extends FileChangeListener{

        @Override
        public void onFileCreate(File pFile) {
            super.onFileCreate(pFile);
            System.out.println(String.format("FileCreate[%s]",pFile.getName()));
        }

        @Override
        public void onFileChange(File pFile) {
            super.onFileChange(pFile);
            System.out.println(String.format("FileChange[%s]",pFile.getName()));
        }

        @Override
        public void onFileDelete(File pFile) {
            super.onFileDelete(pFile);
            System.out.println(String.format("FileDelelte[%s]",pFile.getName()));
        }
    }

    public static void main(String[] args) {
        MyFileChangeListener listener = new MyFileChangeListener();
        FilesystemAlterationMonitor fam = new FilesystemAlterationMonitor();
        fam.addListener(new File("/Users/yangyu/Downloads/compiler/src/java"),listener);
        fam.start();
        LockSupport.park();
    }
}
