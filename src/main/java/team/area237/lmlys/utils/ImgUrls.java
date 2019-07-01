package team.area237.lmlys.utils;

import java.util.ArrayList;
import java.util.List;

public class ImgUrls {
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;

    public String[] getUrls(){
        List<String> list=new ArrayList<>();
        list.add(url1);
        list.add(url2);
        list.add(url3);
        list.add(url4);
        list.add(url5);
        String[] array=list.toArray(new String[list.size()]);
        return array;
    }

    public String getUrl1() {
        return url1;
    }

    public String getUrl2() {
        return url2;
    }

    public String getUrl3() {
        return url3;
    }

    public String getUrl4() {
        return url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }
}
