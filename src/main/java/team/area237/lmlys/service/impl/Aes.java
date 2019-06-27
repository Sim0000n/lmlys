package team.area237.lmlys.service.impl;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//AES_CBC_PKCS7Padding
public class Aes {
    private String ALGO = "AES";
    private String ALGO_MODE = "AES/CBC/NoPadding";
    private String akey = "11111111111111111111111111111111";
    private String aiv = "22222222222222222222222222222222";

    //String passwordDec = aes.decrypt(passwordEnc);//解密
    public static String encryptAes(String plaintext) throws Exception{
        Aes aes = new Aes();
        String rstData = pkcs7padding(plaintext);//进行PKCS7Padding填充
        String passwordEnc = aes.encrypt(rstData);//进行java的AES/CBC/NoPadding加密
        return passwordEnc;
    }

    public String encrypt(String Data) throws Exception {
        try {
            byte[] iv = toByteArray(aiv);//因为要求IV为16byte，而此处aiv串为32位字符串，所以将32位字符串转为16byte
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = Data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            Encoder encoder = Base64.getEncoder();
            String EncStr = encoder.encodeToString(encrypted);//将cipher加密后的byte数组用base64加密生成字符串
            return EncStr ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String decrypt(String encryptedData) throws Exception {
        try {

            // BASE64Decoder decoder = new BASE64Decoder();
            // byte[] buffer = decoder.decodeBuffer(data);
            // 从JKD 9开始rt.jar包已废除，从JDK 1.8开始使用java.util.Base64.Decoder
            Decoder decoder = Base64.getDecoder();
            byte[] encrypted1 = decoder.decode(encryptedData);
            byte[] iv = toByteArray(aiv);
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();//此处添加trim（）是为了去除多余的填充字符，就不用去填充了，具体有什么问题我还没有遇到，有强迫症的同学可以自己写一个PKCS7UnPadding函数
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //此函数是将字符串每两个字符合并生成byte数组
    private static byte[] toByteArray(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        System.out.println(byteArray.length);
        return byteArray;
    }
    //此函数是pkcs7padding填充函数
    private static String pkcs7padding(String data) {
        int bs = 16;
        int padding = bs - (data.length() % bs);
        String padding_text = "";
        for (int i = 0; i < padding; i++) {
            padding_text += (char)padding;
        }
        return data+padding_text;
    }
}
