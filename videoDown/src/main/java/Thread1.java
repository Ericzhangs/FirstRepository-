import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

class Thread1 implements Runnable {
    private int start;
    private int end;
    private URL url;

    public Thread1(int start, int end, URL url) {
        super();
        this.start = start;
        this.end = end;
        this.url = url;
    }

    public void run() {
        // TODO Auto-generated method stub
        System.out.println("下载中");
        try {
            HttpURLConnection urlconn = (HttpURLConnection) url
                    .openConnection();
            urlconn.setRequestProperty("Range", "bytes=" + start + "-" + end);
            if (urlconn.getResponseCode() == 206) {
                String path = System.getProperty("user.dir") + "/src/MV.mp4";
                File file = new File(path);
                InputStream in = urlconn.getInputStream();
                byte[] b = new byte[1024];
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                raf.seek(start);
                int readcode = 0;
                while ((readcode = in.read(b)) != -1) {
                    raf.write(b, 0, readcode);
                }
                raf.close();
                in.close();
                System.out.println("下载完成");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("IO异常");
        }
    }
}