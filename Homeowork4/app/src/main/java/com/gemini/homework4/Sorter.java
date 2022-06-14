package  com.gemini.homework4;

public class Sorter {
  private String name;
  private int imgAscending;
  private int imgDescending;

  public String getSortLabel() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getImageASC() {
    return imgAscending;
  }

  public void setImgAscending(int imgAscending) {
    this.imgAscending = imgAscending;
  }

  public int getImageDESC() {
    return imgDescending;
  }

  public void setImgDescending(int imgDescending) {
    this.imgDescending = imgDescending;
  }

  public Sorter(String name, int imgAscending, int imgDescending) {
    this.name = name;
    this.imgAscending = imgAscending;
    this.imgDescending = imgDescending;
  }
}
