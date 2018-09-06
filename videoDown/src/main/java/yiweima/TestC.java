//package yiweima;
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGEncodeParam;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import org.jbarcode.JBarcode;
//import org.jbarcode.encode.Code128Encoder;
//import org.jbarcode.encode.InvalidAtributeException;
//import org.jbarcode.paint.BaseLineTextPainter;
//import org.jbarcode.paint.WidthCodedPainter;
//
//import java.awt.image.BufferedImage;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
///**
// * Created by Administrator on 2016-06-20.
// * java生成二维码
// */
//public class TestC {
//    public static void main(String[] arge){
//        JBarcode localJBarcode = new JBarcode(Code128Encoder.getInstance(), WidthCodedPainter.getInstance(), BaseLineTextPainter.getInstance());
//        localJBarcode.setEncoder(Code128Encoder.getInstance());
//        localJBarcode.setPainter(WidthCodedPainter.getInstance());
//        localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());
//        localJBarcode.setShowCheckDigit(false);
//
//        BufferedImage localBufferedImage = null;
//        try {
//            localBufferedImage = localJBarcode.createBarcode("dddd201606140001");
//        } catch (InvalidAtributeException e) {
//            e.printStackTrace();
//        }
//        OutputStream jos = null;
//        try {
//            jos = new FileOutputStream("E:\\imagesFile.jpg");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(jos);
//        JPEGEncodeParam jpegEP = JPEGCodec.getDefaultJPEGEncodeParam(localBufferedImage);
//        jpegEP.setQuality((float) 1, true);
//        try {
//            encoder.encode(localBufferedImage, jpegEP);
//            jos.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                jos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
