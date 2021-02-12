package dunn;

/**
 * 下载监听器
 */
public interface DownloadListener {

    /**
     * 当下载结束
     * @param sourceUrl 图片地址
     * @param savedFilePath 保存文件地址
     */
    void whenDownloadOver(DownloadEvent event);
}
