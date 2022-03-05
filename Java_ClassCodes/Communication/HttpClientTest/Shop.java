import java.util.Properties;
import java.util.HashMap;
import java.io.FileInputStream;

class Shop {

	private static HashMap<String, Shop> cache = new HashMap<>();
	private Properties doc = new Properties();

	private Shop() {}

	public static Shop open(String source) {
		Shop shop = cache.get(source);
		if(shop == null){
			shop = new Shop();
			try(var input = new FileInputStream(source)){
				shop.doc.loadFromXML(input);
			}catch(Exception e){
				throw new RuntimeException(e);
			}
			cache.put(source, shop);
		}
		return shop;
	}

	public String getItemInfo(String name) {
		return doc.getProperty(name);
	}

}

