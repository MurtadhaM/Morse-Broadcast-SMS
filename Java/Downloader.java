import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader extends Thread {

  @Override
  public void run() {
    try {
      // Starting a download with a new thread
      System.out.println("Downloading " + this.getFileName());
      this.download();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @param urls
   */
  public void bulkDownload(String[] urls) {
    for (int i = 0; i < urls.length; i++) {
      Downloader d = new Downloader(urls[i]);
      d.start();
    }
  }

  public Downloader(String[] urls) {
    this.bulkDownload(urls);
  }

  private String url;
  private String fileName;
  private String filePath = new File(".").getAbsolutePath();

  public Downloader(String url) {
    this.url = url;
    this.fileName = url.split("/")[url.split("/").length - 1];
  }

  public Downloader(String url, String fileName) {
    this.url = url;
    this.fileName = fileName;
  }

  public Downloader() {}

  public Downloader(String url, String fileName, String filePath) {
    this.url = url;
    this.fileName = fileName;
    this.filePath = filePath;
  }

  /**
   * @return String
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return String
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @param fileName
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * @return String
   */
  public String getFilePath() {
    return filePath;
  }

  /**
   * @param filePath
   */
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public void download() {
    // Check if the file exists and if it does, delete it before downloading
    if (new File(filePath + fileName).exists()) {
      new File(filePath + fileName).delete();
      filePath = "./Downloads/";
    } else {
      new File("./Downloads").mkdirs();
      filePath = "./Downloads/";
    }

    try {
      URL website = new URL(url);
      ReadableByteChannel rbc = Channels.newChannel(website.openStream());
      FileOutputStream fos = new FileOutputStream(filePath + "/" + fileName);

      fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * @param fileName
   * @param filePath
   * @param text
   */
  public void WriteToFile(String fileName, String filePath, String text) {
    try {
      FileOutputStream fos = new FileOutputStream(filePath + fileName);
      fos.write(text.getBytes());
      fos.close();
      System.out.println("File written successfully");
    } catch (Exception e) {
      System.out.println("Error in writing file");
      e.printStackTrace();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    String[] urls = {
      "https://raw.githubusercontent.com/MurtadhaM/FindASnake/main/information.json",
      "https://raw.githubusercontent.com/HullRyan/test_data/main/faculty_tree.json",
      "https://webpages.charlotte.edu/mmarzouq/English/background.jpg",
    };
    Downloader d = new Downloader();
    d.bulkDownload(urls);
  }
}
