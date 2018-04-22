
import javax.swing.ImageIcon;

public class Goods {
  
  final static public String all = "All";
  
  private String name;
  private String description;
  private double price;
  private int ammount;
  private ImageIcon image;
  private ImageIcon defaultImage;
  private String category;
  
  
  public Goods(String name, String category, String description, double price, int ammount, ImageIcon image) {
    this.name = name;
    this.setCategory((category == null ? all : category));
    this.description = description;
    this.ammount = (ammount == 0 ? 0 : ammount);
    this.image = (image == null ? defaultImage : image);
  }

  /*
  public Goods(String name, String category, int price, int ammount, ImageIcon image) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.ammount = ammount;
    this.image = image;
  }
  
  public Goods(String name, String category, int price, int ammount) {
    super();
    this.name = name;
    this.category = category;
    this.price = price;
    this.ammount = ammount;
    this.image = defaultImage;
  }
  
  public Goods(String name, String category, int price, ImageIcon image) {
    super();
    this.name = name;
    this.category = category;
    this.price = price;
    this.ammount = 1;
    this.image = image;
  }
  
  */


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }


  public void setDescription(String description) {
    this.description = description;
  }
  
  public double getPrice() {
    return this.price;
  }
  
  public void detPrice(double price) {
    this.price = price;
  }


  public int getAmmount() {
    return ammount;
  }
  
  public void setAmmount(int ammount) {
    this.ammount = ammount;
  }


  public ImageIcon getImage() {
    return image;
  }


  public void setImage(ImageIcon image) {
    this.image = image;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
  

}