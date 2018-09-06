import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class videoDown {


    public static void down(String urlname){
        URL url = null;
        try {
            url = new URL(urlname);
            URLConnection conn = url.openConnection();
            HttpURLConnection urlconn = (HttpURLConnection)url.openConnection();
            File file = new File("E:\\test\\testMV.flv");
            InputStream in = urlconn.getInputStream();
            byte[] b = new byte[1024];
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            int readcode = 0;
            while ((readcode = in.read(b)) != -1) {
                raf.write(b, 0, readcode);
            }
            raf.close();
            in.close();
            System.out.println("结束");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String urlname = "http://api.tianxianle.com/jx/dapi.php?id=sa51naKhqaajyqqWmah1aGNjd25raKZmaHd8enZ3YWVwdnl9eWl6epeZaXwO0O0O";
        down(urlname);
    }

//    public static void main(String[] args) {
//
//        try {
////            String urlname = "http://219.147.83.244/695EF05563F718C926E37E9/03000A010059F1DF936FEE01233E8D995A1F67-7C9C-B63F-01CE-B5EA6252C012."
////                    + "mp4?ali_redirect_domain=vali-dns.cp31.o"
////                    + "tt.cibntv.net&ccode=0502&duration=62&expire=18000&"
////                    + "psid=2ac4ca6e7cf55a1435d242c356b17eb2&ups_client_ne"
////                    + "tip=222.168.152.224&ups_ts=1509081807&ups_userid=33"
////                    + "8784644&utid=341CEpTrYAECAd6of4zTB4VO&vid=XMzExMjY0OT"
////                    + "I1Mg%3D%3D&vkey=A4e308094022f9680ab63ca1076ed02c8";
//            String urlname = "http://api.tianxianle.com/jx/dapi.php?id=sa51naKhqaajyqqWmah1aGNjd25raKZmaHd8enZ3YWVwdnl9eWl6epeZaXwO0O0O";
//            URL url = new URL(urlname);
//            URLConnection conn = url.openConnection();
//            int length = conn.getContentLength();
//            System.out.println("length=" + length);
//            // 定义线程数量
//            int size = 2;
//            int block = length % size == 0 ? length / size : length / size + 1;
//            for (int i = 0; i < size; i++) {
//                int start = i * block;
//                System.out.println("block=" + block);
//                int end = start + (block - 1);
//                if (i == size - 1) {
//                    end++;
//                }
//                new Thread(new Thread1(start, end, url)).start();
//                System.out.println("start=" + start + "end=" + end);
//            }
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
}
