import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Storage {
  
  static public Map<String, Goods> stuff = new HashMap<String, Goods>();
  static public ArrayList<String> categories = new ArrayList<String>();


  public Storage() {
    categories.add(Goods.all);
  }
  
  public void createNewGoods(String name, String category, String description, double price, int ammount, ImageIcon icon) {
    Goods tovar = new Goods(name, category, description, price, ammount, icon);
    stuff.put(name, tovar);
  }
  
  public void addGoods(String name, int difference) {
    Goods changed = stuff.get(name);
    changed.setAmmount(changed.getAmmount()+difference);
    stuff.put(name, changed);
  }
  
  public void substractGoods(String name, int difference) {
    Goods changed = stuff.get(name);
    if(difference < changed.getAmmount()) {
      changed.setAmmount(changed.getAmmount()-difference);
      stuff.put(name, changed);
    }else {
      removeGoods(name);
    }
  }
  
  public void removeGoods(String name) {
    stuff.remove(name);
  }
  
  public boolean checkGoods(String name) {
    return stuff.containsKey(name) == true ? true : false;
  }
  
  public Goods searchByName(String name) {
    return stuff.get(name);
  }
  
  public HashMap<String, Goods> searchByPrice(int price){
    HashMap<String, Goods> result = new HashMap<>();
    for(Map.Entry<String, Goods> entry : stuff.entrySet()) {
      if(entry.getValue().getPrice() <= price)
        result.put(entry.getKey(),entry.getValue());
    }
    if(result.isEmpty())
      return null;
    return result;
  }
  
  public HashMap<String, Goods> searchByCategory(String category){ 
	  HashMap<String, Goods> result = new HashMap<String, Goods>();
    for(Map.Entry<String, Goods> entry : stuff.entrySet()) {
      if(category.equals(Goods.all)) {
        result.put(entry.getKey(),entry.getValue());
      }else {
        if(entry.getValue().getCategory().equals(category))
          result.put(entry.getKey(),entry.getValue());
      }    
    }
    if(result.isEmpty())
      return null;
    return result;
  }
  
  public void createCategory(String category) {
    categories.add(category);
  }
  
  public void deleteCategory(String category) {
    if(category.equals(Goods.all)) {
      stuff.clear();
    }else {
      for(Map.Entry<String, Goods> entry : stuff.entrySet()) {
        if(entry.getValue().getCategory().equals(category)) {
          stuff.remove(entry.getKey());
        }
      }
    }
    categories.remove(category);
  }
  

}