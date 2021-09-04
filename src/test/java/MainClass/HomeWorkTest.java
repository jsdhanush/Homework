package MainClass;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class HomeWorkTest {
	private static ArrayList<Product> productList=new ArrayList<Product>();
	private static HashMap<String,Double> margin=new HashMap<String,Double>();
	private static ArrayList<Category> categoryList=new ArrayList<Category>();
	private static HashMap hm=new HashMap();
	private static Map<String, Double> expected = new HashMap<>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
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
		
		margin.put("C1", 20.0);
		margin.put("C2", 30.0);
		margin.put("C3", 0.4);
		margin.put("C4", 50.0);
		margin.put("C5", 0.6);
		
		expected.put("G1", 482.8);
		expected.put("G2",2559.5 );
		expected.put("G3", 1931.6666666666667);
	
	}

	@Test
	public void test() {
        HashMap pc=new HashMap();
		//Calling method for finding category
		pc= HomeWork.findCategoryOfProduct(productList, categoryList);
		//find the margin
		pc=HomeWork.findMarginOfProduct(pc,margin);
		//find the cost
		pc=HomeWork.findCostOfProduct(pc,productList);
		//find the average per group
		pc=HomeWork.findAvgofGroup(pc,productList);
		assertThat(pc,is(expected));
		System.out.println("it works");
	}
	

	

}
