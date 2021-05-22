
class BranchEmployees {
	String name;
	String surname;
	String email;
	
	BranchEmployees(){
		
	}
	
	BranchEmployees(String name, String surname, String email, Company com){
		this.name = name;
		this.surname = surname;
		this.email = email;
		com.branchEmployees.add(this);
	}
	
	void getBranchEmployee() {
		System.out.println(name + " " + surname + " " + email);
	}
	
	void checkProductSituation(Company com, int branchNum, int requested, int productNum) {
		switch(productNum) {
		case 1:
			com.branch.get(branchNum).officeChair.get(0).checkProductSituation(com, branchNum, requested, productNum);
			break;
		case 2:
			com.branch.get(branchNum).officeDesk.get(0).checkProductSituation(com, branchNum, requested, productNum);
			break;
		case 3:
			com.branch.get(branchNum).officeCabinet.get(0).checkProductSituation(com, branchNum, requested, productNum);
			break;
		case 4:
			com.branch.get(branchNum).meetingTable.get(0).checkProductSituation(com, branchNum, requested, productNum);
			break;
		case 5:
			com.branch.get(branchNum).bookcase.get(0).checkProductSituation(com, branchNum, requested, productNum);
			break;
		default:
			System.out.println("Invalid selection. Try again...");
			break;
		}
	}


	void giveInfoToAdmin(int branchNum, int productNum, Company com) {
		System.out.println("Administrator is informing by the automated system...");
		switch(productNum) {
		case 1:
			System.out.println("Office chairs must be purchased in the branch named " + com.branch.get(branchNum).Branchname + "!!");
			break;
		case 2:
			System.out.println("Office desks must be purchased in the branch named " + com.branch.get(branchNum).Branchname + "!!");
			break;
		case 3:
			System.out.println("Office cabinets must be purchased in the branch named " + com.branch.get(branchNum).Branchname + "!!");
			break;
		case 4:
			System.out.println("Meeting tables must be purchased in the branch named " + com.branch.get(branchNum).Branchname + "!!");
			break;
		case 5:
			System.out.println("Bookcases must be purchased in the branch named " + com.branch.get(branchNum).Branchname + "!!");
			break;
		default:
			System.out.println("Invalid product. Try again...");
			break;
		}
		
	}
	
	String[] sellProduct(int branchNum, Company com, String requestedAmount, int customerNum, String productName, String productModel, String productColor) {
int space = 0;
		
		if(com.customer.get(customerNum).orders == null)
			space = 0;
		else 
			space = com.customer.get(customerNum).orders.length;


		Customers[] c = new Customers[com.customer.size + 1];
		c[customerNum] = new Customers();
		c[customerNum].orders = new String[space + 1];
		c[customerNum].orders = com.customer.get(customerNum).orders;
		
		
		int count = c[customerNum].orders.length;
		com.customer.get(customerNum).orders = new String[space + 5];
		
		for(int i = 0; i < com.customer.get(customerNum).orders.length; i++) {
			com.customer.get(customerNum).orders[i] = new String();
			if(i < count) {
				com.customer.get(customerNum).orders[i] = c[customerNum].orders[i];
			}else {
				com.customer.get(customerNum).orders[i + 1] = new String();
				com.customer.get(customerNum).orders[i + 2] = new String();
				com.customer.get(customerNum).orders[i + 3] = new String();
				com.customer.get(customerNum).orders[i + 4] = new String();
				com.customer.get(customerNum).orders[i] = productName;
				com.customer.get(customerNum).orders[i + 1] = productModel;
				com.customer.get(customerNum).orders[i + 2] = productColor;
				com.customer.get(customerNum).orders[i + 3] = com.branch.get(branchNum).Branchname;
				com.customer.get(customerNum).orders[i + 4] = requestedAmount;
				i += 4;
			}
		}
		System.out.println("Online shopping is succeeded.");
		return com.customer.get(customerNum).orders;
	}
	
	void demonstratePreOrders(int id, Company com) {
		int flag = 0;
		for(int i = 0; i < com.customer.size/2; i++) {
			if(com.customer.get(i).id == id) {
				flag = 1;
				if(com.customer.get(i).orders != null) {
					for(int j = 0; j < com.customer.get(i).orders.length; j += 5) {
						System.out.println("Product Name: " + com.customer.get(i).orders[j] 
								+"\nProduct Model: " + com.customer.get(i).orders[j + 1]
									+ "\nProduct Color: " + com.customer.get(i).orders[j + 2] 
										+ "\nBranch Name: " + com.customer.get(i).orders[j + 3] 
											+ "\nAmount: " + com.customer.get(i).orders[j + 4]);
					}
				}
			}
		}
		if(flag == 0) {
			System.out.println("Customer number is not valid. Try again...");
		}
	}
	
	KWLinkedList<Branch> addProduct(String productName, int branchNum, int amount, int colorAmount[], String modelName[], String colorName[], Company com) {
		
		int productType = 6;
		if(productName.equals("OfficeChairs")) {
			productType = 1;
		}else if(productName.equals("OfficeDesks")) {
			productType = 2;
		}else if(productName.equals("OfficeCabinets")) {
			productType = 3;
		}else if(productName.equals("MeetingTables")) {
			productType = 4;
		}else if (productName.equals("Bookcases")) {
			productType = 5;
		}else {
			System.out.println("Product is not available. Try again...");
		}
		switch(productType) {
		case 1:
			com.branch.get(branchNum).officeChair = com.branch.get(branchNum).officeChair.get(0).addProduct(branchNum, amount, colorAmount, modelName, colorName, com);
			break;
		case 2:
			com.branch.get(branchNum).officeDesk =com.branch.get(branchNum).officeDesk.get(0).addProduct(branchNum, amount, colorAmount, modelName, colorName, com);
			break;
		case 3:
			com.branch.get(branchNum).officeCabinet = com.branch.get(branchNum).officeCabinet.get(0).addProduct(branchNum, amount, colorAmount, modelName, colorName, com);
			break;
		case 4:
			com.branch.get(branchNum).meetingTable = com.branch.get(branchNum).meetingTable.get(0).addProduct(branchNum, amount, colorAmount, modelName, colorName, com);
			break;
		case 5:
			com.branch.get(branchNum).bookcase = com.branch.get(branchNum).bookcase.get(0).addProduct(branchNum, amount, colorAmount, modelName, colorName, com);
			break;
		default:
			System.out.println("Invalid branch. Please try again...");
			break;
		}
		return com.branch;
	}
	
	KWLinkedList<Branch> removeProduct(String productName, int branchNum, String modelName, String colorName, Company com) {
		int productType = 6;
		if(productName.equals("OfficeChairs")) {
			productType = 1;
		}else if(productName.equals("OfficeDesks")) {
			productType = 2;
		}else if(productName.equals("OfficeCabinets")) {
			productType = 3;
		}else if(productName.equals("MeetingTables")) {
			productType = 4;
		}else if (productName.equals("Bookcases")) {
			productType = 5;
		}else {
			System.out.println("Product is not available. Try again...");
		}
		switch(productType) {
		case 1:
			com.branch.get(branchNum).officeChair.get(0).removeProduct(branchNum, modelName, colorName, com);
			break;
		case 2:
			com.branch.get(branchNum).officeDesk.get(0).removeProduct(branchNum, modelName, colorName, com);
			break;
		case 3:
			com.branch.get(branchNum).officeCabinet.get(0).removeProduct(branchNum, modelName, colorName, com);
			break;
		case 4:
			com.branch.get(branchNum).meetingTable.get(0).removeProduct(branchNum, modelName, colorName, com);
			break;
		case 5:
			com.branch.get(branchNum).bookcase.get(0).removeProduct(branchNum, modelName, colorName, com);
			break;
		default:
			System.out.println("Invalid branch. Please try again...");
			break;
		}
		return com.branch;
	}
}
