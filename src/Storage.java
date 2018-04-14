import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Storage {
	
	static private Map<String, Goods> stuff = new HashMap<String, Goods>();
	static private ArrayList<String> categories = new ArrayList<String>();


	public Storage() {
		categories.add(Goods.all);
	}
	
	public void createNewGoods(String name, String category, int price, int ammount, ImageIcon icon) {
		Goods tovar = new Goods(name, category, price, ammount, icon);
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
			changed.setPrice(changed.getPrice()-difference);
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
	
	public ArrayList<Goods> searchByPrice(int price){
		ArrayList<Goods> result = new ArrayList<Goods>();
		for(Map.Entry<String, Goods> entry : stuff.entrySet()) {
			if(entry.getValue().getPrice() <= price)
				result.add(entry.getValue());
		}
		if(result.isEmpty())
			return null;
		return result;
	}
	
	public ArrayList<Goods> searchByCategory(String category){ 
		ArrayList<Goods> result = new ArrayList<Goods>();
		for(Map.Entry<String, Goods> entry : stuff.entrySet()) {
			if(category.equals(Goods.all)) {
				result.add(entry.getValue());
			}else {
				if(entry.getValue().getCategory().equals(category))
					result.add(entry.getValue());
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
