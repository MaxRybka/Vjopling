
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Storage {
  
  static public HashMap<String, Goods> stuff = new HashMap<String, Goods>();
  static public ArrayList<String> categories = new ArrayList<String>();
  static public ArrayList<String> makers = new ArrayList<String>();


  public Storage() {
    categories.add(Goods.all);
    makers.add(Goods.defaultMaker);
  }
  
  public static void createNewGoods(String name, String category, String maker, String description, int price, int ammount, ImageIcon icon) {
    Goods tovar = new Goods(name, category, maker, description, price, ammount, icon);
    stuff.put(name, tovar);
    boolean catExists = false;
    for(int i = 0; i < categories.size(); i ++) {
      if(tovar.getCategory().equals(categories.get(i))) {
        catExists = true;
        break;
      }
    }
    if(!catExists) createCategory(category);
    boolean makerExists = false;
    for(int i = 0; i < makers.size(); i ++) {
      if(tovar.getMaker().equals(makers.get(i))) {
        makerExists = true;
        break;
      }
    }
    if(!makerExists) addMaker(maker);
    String cat = category;
    if(catExists) cat = null;
    String mak = maker;
    if(makerExists) mak = null;
    MainWindow.repaintAdd(cat, mak);
  }
  
  /*
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
  */
  public void removeGoods(String name) {
    stuff.remove(name);
    checkCategory(stuff.get(name).getCategory());
    checkMaker(stuff.get(name).getMaker());
  }
  
  public boolean checkGoods(String name) {
    return stuff.containsKey(name) == true ? true : false;
  }
  
  public static void editGoods(String name, String newDescription, int newPrice, int newAmmount) {
    stuff.get(name).setDescription(newDescription);
    stuff.get(name).setPrice(newPrice);
    stuff.get(name).setAmmount(newAmmount);
  }

  public HashMap<String, Goods> searchByName(String substring) {
    HashMap<String, Goods> names = new HashMap<String, Goods>();
    if(substring.equals(null))
      return names;
    for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
//      System.out.println(substring);
//      System.out.println(entry.getKey().indexOf(substring));
      if (entry.getKey().indexOf(substring) != (-1)) {
        names.put(entry.getKey(), entry.getValue());
      }
    }
    return names;
  }

  public HashMap<String, Goods> searchByPrice(HashMap<String, Goods> list, int price) {
    HashMap<String, Goods> result = new HashMap<>();
    if (result.isEmpty())
      return result;
    for (Map.Entry<String, Goods> entry : list.entrySet()) {
      if (entry.getValue().getPrice() <= price)
        result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  public HashMap<String, Goods> searchByCategory(HashMap<String, Goods> list, String category) {
    if(category.equals(Goods.all))
      return list;
    HashMap<String, Goods> result = new HashMap<String, Goods>();
    if (result.isEmpty())
      return result;
    for (Map.Entry<String, Goods> entry : list.entrySet()) {
      if (category.equals(Goods.all)) {
        result.put(entry.getKey(), entry.getValue());
      } else {
        if (entry.getValue().getCategory().equals(category))
          result.put(entry.getKey(), entry.getValue());
      }
    }
//    if (result.isEmpty())
//      return null;
    return result;
  }

public HashMap<String, Goods> searchByMaker(HashMap<String, Goods> list, String maker) {
    if(maker == "All") {
      return list;
    }
    HashMap<String, Goods> result = new HashMap<String, Goods>();
    if (result.isEmpty())
      return result;
    for (Map.Entry<String, Goods> entry : list.entrySet()) {
      if (maker.equals(Goods.defaultMaker)) {
        result.put(entry.getKey(), entry.getValue());
      } else {
        if (entry.getValue().getMaker().equals(maker))
          result.put(entry.getKey(), entry.getValue());
      }
    }
//    if (result.isEmpty())
//      return null;
    return result;
  }

  public HashMap<String, Goods> searchByQuantity(HashMap<String, Goods> list, int amount) {
    HashMap<String, Goods> result = new HashMap<>();
    for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
      if (entry.getValue().getAmmount() <= amount)
        result.put(entry.getKey(), entry.getValue());
    }
//    if (result.isEmpty())
//      return null;
    return result;
  }

  private static void createCategory(String category) {
    categories.add(category);
  }

  private void deleteCategory(String category) {
    if (category.equals(Goods.all)) {
      stuff.clear();
    } else {
      for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
        if (entry.getValue().getCategory().equals(category)) {
          stuff.remove(entry.getKey());
        }
      }
    }
    categories.remove(category);
    MainWindow.repaintDelCat(category);
  }

  private void checkCategory(String category) {
    boolean notEmpty = false;
    for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
      if (entry.getValue().getCategory().equals(category)) {
        notEmpty = true;
        return;
      }
    }
    if (!notEmpty)
      deleteCategory(category);
  }

  private static void addMaker(String maker) {
    makers.add(maker);
  }

  private void checkMaker(String maker) {
    boolean notEmpty = false;
    for (Map.Entry<String, Goods> entry : stuff.entrySet()) {
      if (entry.getValue().getCategory().equals(maker)) {
        notEmpty = true;
        return;
      }
    }
    if (!notEmpty) {
      makers.remove(maker);
      MainWindow.repaintDelMaker(maker);
    }
  }

}