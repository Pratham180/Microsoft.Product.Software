/**
 * Write a description of class MicrosoftProduct here.
 *
 * @author (pratham adhikari)
 * @version (a version number or a date)
 */
public class MicrosoftProduct
{
    // declaration of class
    private int productNo;
    private String productName;
    private String activationKey;
    private float price;

    /**
     * Constructor for objects of class MicrosoftProduct
     */
    public MicrosoftProduct(int productNo, String productName)
    {
        // initialise instance variables
        this.productNo = productNo;
	this.productName = productName;
	this.price = 0;
	this.activationKey = "";
    }
    //setter method for activation key
    public void setActivationKey(String activationKey) {
	this.activationKey = activationKey;
    }
    //setter method for price
    public void setPrice(float price) {
	this.price = price;
    }
    //getter method for all productNo
    public int getProductNo() {
	return productNo;
    }
    //getter method for ProductName
    public String getProductName() {
	return productName; 
    }
    //getter method for activation key
    public String getActivationKey() {
	return activationKey;
    }
    //getter method for price
    public float getPrice() {
	return price;
    }
    //declaration of the method to display the product info   
    public void displayProductInfo() {
        System.out.println("Product No = " + productNo+"\nProduct Name = " + productName);
               if (!activationKey.equals("")){//if condition
            System.out.println("Activation Key = " + activationKey);
               }
        if (price > 0){//if condition
        System.out.println("Price = " + price);
       }
   }
}
