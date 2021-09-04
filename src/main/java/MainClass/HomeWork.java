package MainClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
	private String productName;
	private String group;
	private double price;
	public Product(String productName, String group, double price) {
		super();
		this.productName = productName;
		this.group = group;
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
class Category{
	public Category(String category, int startRange, int endRange) {
		super();
		this.category = category;
		this.startRange = startRange;
		this.endRange = endRange;
	}
	private String category;
	private int startRange;
	private int endRange;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStartRange() {
		return startRange;
	}
	public void setStartRange(int startRange) {
		this.startRange = startRange;
	}
	public int getEndRange() {
		return endRange;
	}
	public void setEndRange(int endRange) {
		this.endRange = endRange;
	}
}

public class HomeWork {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// adding product to a list
		ArrayList<Product> productList=new ArrayList<Product>();
		Product pobj=new Product("A", "G1", 20.1);
		productList.add(pobj);
		pobj=new Product("B", "G2", 98.4);
		productList.add(pobj);
		pobj=new Product("C", "G1", 49.7);
		productList.add(pobj);
		pobj=new Product("D", "G3", 35.8);
		productList.add(pobj);
		pobj=new Product("E", "G3", 105.5);
		productList.add(pobj);
		pobj=new Product("F", "G1", 55.2);
		productList.add(pobj);
		pobj=new Product("G", "G1", 12.7);
		productList.add(pobj);
		pobj=new Product("H", "G3", 88.6);
		productList.add(pobj);
		pobj=new Product("I", "G1", 5.2);
		productList.add(pobj);
		pobj=new Product("J", "G2", 72.4);
		productList.add(pobj);
		
		//Adding categories to a list
		ArrayList<Category> categoryList=new ArrayList<Category>();
		Category cobj=new Category("C3", 50, 75);
		cobj=new Category("C1", 0, 25);
		categoryList.add(cobj);
		cobj=new Category("C2", 25, 50); 
		categoryList.add(cobj);
		cobj=new Category("C3", 50, 75);
		categoryList.add(cobj);
		cobj=new Category("C4", 75, 100);
		categoryList.add(cobj);
		cobj=new Category("C5", 100, 200);
		categoryList.add(cobj);
		
		//Creating a hashmap for margin
		HashMap<String,Double> margin=new HashMap<String,Double>();
		margin.put("C1", 20.0);
		margin.put("C2", 30.0);
		margin.put("C3", 0.4);
		margin.put("C4", 50.0);
		margin.put("C5", 0.6);
		
		HashMap pc=new HashMap();
		//Calling method for finding category
		pc= findCategoryOfProduct(productList, categoryList);
		//find the margin
		pc=findMarginOfProduct(pc,margin);
		//find the cost
		pc=findCostOfProduct(pc,productList);
		//find the average per group
		pc=findAvgofGroup(pc,productList);
		
		
	}
	static HashMap<String, Double> findAvgofGroup(HashMap<String,Double> pc, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		HashMap<String,Double> hm=new HashMap<String,Double>();
		int G1count=0,G2count=0,G3count=0,G1avg = 0,G2avg = 0,G3avg = 0;
		for(Entry<String, Double> entry: pc.entrySet())
		{
			for(Product p:productList)
			{
				if(p.getGroup()=="G1"&&p.getProductName().equals(entry.getKey()))
				{
					G1avg+=entry.getValue();
					G1count++;
				}
				else if(p.getGroup()=="G2"&&p.getProductName().equals(entry.getKey()))
				{
					G2avg+=entry.getValue();
					G2count++;
				}
				else if (p.getGroup()=="G3"&&p.getProductName().equals(entry.getKey())){
					G3avg+=entry.getValue();
					G3count++;
				}
			}
		}
		hm.put("G1",(double) G1avg/G1count);
		hm.put("G2",(double) G2avg/G2count);
		hm.put("G3",(double) G3avg/G3count);
		System.out.println(hm);
		return hm;
	}
	static HashMap<String,Double> findCostOfProduct(HashMap<String,Double> pc, ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		HashMap<String,Double> hm=new HashMap<String,Double>();
		for(Entry<String, Double> entry: pc.entrySet())
		{
			for(Product p:productList)
			{
				if(p.getProductName().equals(entry.getKey()))
				{
					double cost=p.getPrice()*(1+entry.getValue());
					hm.put(entry.getKey(), cost);
				}
			}
		}
		System.out.println(hm);
		return hm;
	}
	
	static HashMap<String,Double> findMarginOfProduct(HashMap<String, String> pc, HashMap<String, Double> margin) {
		// TODO Auto-generated method stub
		HashMap<String,Double> hm=new HashMap<String,Double>();
		for(Entry<String, String> entry: pc.entrySet()) {
			for(String marg:margin.keySet())
			{
				if(entry.getValue().equals(marg))
				{
					hm.put( entry.getKey(),margin.get(marg));
				}
			}
		}
		//System.out.println(hm);
		return hm;
	}
	static HashMap<String,String> findCategoryOfProduct(ArrayList<Product> product,ArrayList<Category> category)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		for(Product p :product)
		{
			double price=p.getPrice();
			for(Category c: category)
			{
				if(price>c.getStartRange()&&price<c.getEndRange())
				{
					hm.put(p.getProductName(), c.getCategory());
				}
			}
		}
		return hm;
	}
}
