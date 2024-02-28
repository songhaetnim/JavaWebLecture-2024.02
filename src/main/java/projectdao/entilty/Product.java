package projectdao.entilty;

public class Product {
	   private int pid;
	   private String category;
	   private String pname;
	   private int price;
	   private String description;
	   private String pimage;
	   
	   public Product() { }
	   public Product(int pid, String category, String pname, int price, String description, String pimage) {
	      this.pid = pid;
	      this.category = category;
	      this.pname = pname;
	      this.price = price;
	      this.description = description;
	      this.pimage = pimage;
	   }
	   // 인서트용
	   public Product(String category, String pname, int price, String description, String pimage) {
	      this.category = category;
	      this.pname = pname;
	      this.price = price;
	      this.description = description;
	      this.pimage = pimage;
	   }
}

