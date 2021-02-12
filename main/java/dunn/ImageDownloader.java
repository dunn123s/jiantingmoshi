package dunn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 图片下载器
 */
public class ImageDownloader {

    private final String domain;//需要下载的网站

    private final List<DownloadListener> listeners = new ArrayList<DownloadListener>();

    public ImageDownloader(String domain) {
        this.domain = domain;
    }

    /**
     * 添加监听器
     * @param listener
     */
    public void addDownloadListener(DownloadListener listener) {
        listeners.add(listener);
    }

    public void start() {
        List<String> images = getImages();//获取domain的图片地址
        for (int i = 0; i < images.size(); i++) {//遍历图片地址，
            byte[] imgBytes = downloadImg(images.get(i));//下载图片，下载成二进制数据
            saveToFile(images.get(i), "d:/img" + i + ".png", imgBytes);//把图片的二进制保存到文件；
            fireDownloadLister(images.get(i), "d:/img" + i + ".png");
        }
    }


    public void fireDownloadLister(String imageSource, String savePath) {
        for(DownloadListener listener: listeners) {
            DownloadEvent event = new DownloadEvent(this, imageSource, savePath);
            listener.whenDownloadOver(event);
        }
    }


    private byte[] downloadImg(String imgUrl) {
        return new byte[100];
    }

    private void saveToFile(String imageName, String fileName, byte[] buf) {
        //假设已经保存
        System.out.println("已经将" + imageName + "保存到" + fileName + "文件。");
    }

    /**
     * 伪代码，假设它能获取domain中的所有图片地址
     * @return
     */
    private List<String> getImages() {
        System.out.println("从" + domain + "中发现了5个图片地址");
        return Arrays.asList(
                domain + "/a.png",
                domain + "/b.png",
                domain + "/c.png",
                domain + "/d.png",
                domain + "/e.png"
        );
    }
}

