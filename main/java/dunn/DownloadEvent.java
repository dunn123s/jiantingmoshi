package dunn;

import java.util.EventObject;

public class DownloadEvent extends EventObject {
    private final String imageSource;
    private final String savedFilePath;
    public DownloadEvent(Object source, String imageSource, String savedFilePath) {
        super(source);
        this.imageSource = imageSource;
        this.savedFilePath = savedFilePath;
    }

    public String getImageSource() {
        return imageSource;
    }

    public String getSavedFilePath() {
        return savedFilePath;
    }
}
