package arren;

import dunn.DownloadEvent;
import dunn.DownloadListener;
import dunn.ImageDownloader;

public class Application {

    public static void main(String[] args) {
        ImageDownloader downloader = new ImageDownloader("http://www.baidu.com");
        DownloadListener listener = new DownloadListener() {
            public void whenDownloadOver(DownloadEvent event) {
                System.out.println("我监听到了图片" + event.getImageSource() + "被下载到了文件：" + event.getSavedFilePath());
            }
        };
        downloader.addDownloadListener(listener);

        downloader.start();

    }
}
