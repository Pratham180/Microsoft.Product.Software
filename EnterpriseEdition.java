/**
 * Write a description of class EnterpriseEdition here.
 *
 * @author (pratham adhikari)
 * @version (a version number or a date)
 */
public class EnterpriseEdition extends MicrosoftProduct
{
    // instance variables
    private String clientCompanyName;
    private float pricePerUser;
    private int noOfUser;
    private String activationDate;
    private String licenseExpireDate;
    private boolean isActivated;
    private boolean isExpired;

    /**
     * Constructor for objects of class EnterpriseEdition
     */
    //Constructor declaration
    public EnterpriseEdition(int productNo, String productName, float pricePerUser) {
	super(productNo, productName);
	this.pricePerUser = pricePerUser;
	this.noOfUser = 0;
	this.activationDate = "";
	this.licenseExpireDate = "";
	this.isActivated = false;
	this.isExpired = false;
    }
    //getter method for client company name
    public String getClientCompanyName() {
		return clientCompanyName;
	}
    //getter method for price per user
    public float getPricePerUser() {
	return pricePerUser;
    }
    //getter method for no of user
    public int getNoOfUser() {
	return noOfUser;
    }
    //getter method for activation date
    public String getActivationDate() {
	return activationDate;
    }
    //getter method for license expiration date
    public String getLicenseExpireDate() {
	return licenseExpireDate;
    }
    // getter method for activation
    public boolean isActivated() {
	return isActivated;
    }
    // getter method for expiration
    public boolean isExpired() {
	return isExpired;
    }
    //setter method for price per user
    public String setPricePerUser(float pricePerUser) {
	if (isActivated){ //if condition
		return "License is already assigned, can not update price per user.";
        }
	this.pricePerUser = pricePerUser;
	return "Price per user set successfully.";
    }
    //declaration of the method activate license
    public String activateLicense(String clientCompanyName, int noOfUser, String activationDate,
			String licenseExpireDate, String activationKey) {
	if (isActivated) { //if condition
		return "License is already activated for " + this.clientCompanyName + ", with " + this.noOfUser + " users.";
	}
	this.clientCompanyName = clientCompanyName;
	this.noOfUser = noOfUser;
	this.activationDate = activationDate;
	this.licenseExpireDate = licenseExpireDate;
	super.setActivationKey(activationKey); // calling setter method of super class
	this.isActivated = true;
	this.isExpired = false;
	super.setPrice(this.pricePerUser * this.noOfUser); // calling the setter method of super class and declaration of formula to calculate total price
	return "License activated successfully.";
    }
    //declaration of the method to terminate license
    public String teminateLicense() {
	if (!isActivated){ //if condtition
		return "License is not present.";
        }
	this.clientCompanyName = "";
	this.noOfUser = 0;
	this.activationDate = "";
	this.licenseExpireDate = "";
	this.isActivated = false;
	this.isExpired = true;
	return "License terminated successfully.";
    }
    //declaration of method to display the Product Info 
    public void displayProductInfo() {
            super.displayProductInfo(); // calling the parent class method
            if (isActivated) { //if condtition
            System.out.println("Client Company Name = " + clientCompanyName
            + "\nPrice Per User = " + pricePerUser + "\nNo. Of User = " + noOfUser
            + "\nActivation Date = " + activationDate + "\nLicense Expire Date = " + licenseExpireDate
            + "\nActivated = " + isActivated + "\nExpired = " + isExpired);

        }
    }
}
