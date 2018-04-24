
import javax.swing.ImageIcon;

public class Goods {
  
  final static public String all = "All";
  final static public String defaultMaker = "Unknown";
  private ImageIcon defaultImage = new ImageIcon("Image\\meme.png");
  private String name;
  private String description;
  private String maker;
  private int price;
  private int ammount;
  private ImageIcon image;
  private String category;
  
  
  public Goods(String name, String category, String maker, String description, int price, int ammount, ImageIcon image) {
    this.name = name;
    this.setCategory((category == null ? all : category));
    this.maker = (maker == null ? defaultMaker : maker);
    this.description = description;
    this.price = price;
    this.ammount = ammount;
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


  public String getMaker() {
	return maker;
}

public void setMaker(String maker) {
	this.maker = maker;
}

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
  
  public int getPrice() {
    return this.price;
  }
  
  public void setPrice(int price) {
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