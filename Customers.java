
import java.util.Scanner;

class Customers extends Company{
	 String name;
	 String surname;
	 String email;
	 String password;
	 int id;
	 String adress;
	 String phoneNum;
	 String orders[];
	Customers(){
		
	}
	
	Customers(String name, String surname, String email, String password, Company com){
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		int[] idArray = new int[8];
		int  id = 10000000;
		
		for(int i = 0; i < 5 ; i++) {
			if(i != 0)
				idArray[i] = (i * 2 + 1) * idArray[i - 1];
			else
				idArray[i] = (i * 2 + 1);
		}
		
		for(int i = 0; i < com.customer.size; i++) {
			if(id != com.customer.get(i).id) {
				this.id = id;
			}else {
				for(int k = 7; k >= 0; k--) {
					for(int j = 0; j < k; j++)
						id += idArray[7-k] * 10;
				}
			}
		}
	}
	
	Customers setCustomer(String name, String surname, String email, String password, int customerNum, Company com) {
		Customers c = new Customers();
		com.customer.add(customerNum, c);
		com.customer.get(customerNum).name = name;
		com.customer.get(customerNum).surname = surname;
		com.customer.get(customerNum).email = email;
		com.customer.get(customerNum).password = password;
		int[] idArray = new int[8];
		int  id = 10000000;
	
		for(int i = 0; i < 5 ; i++) {
			if(i != 0)
				idArray[i] = (i * 2 + 1) * idArray[i - 1];
			else
				idArray[i] = (i * 2 + 1);
		}
		
		for(int i = 0; i < com.customer.size; i++) {
			if(id != com.customer.get(i).id) {
				com.customer.get(customerNum).id = id;
			}else {
				for(int k = 7; k >= 0; k--) {
					for(int j = 0; j < k; j++)
						id += idArray[7-k] * 10;
				}
			}
		}
		com.customer.get(customerNum).id = id;
		return com.customer.get(customerNum);
	}
	
	KWArrayList<Customers> setCustomer(String name, String surname, String email, String password, int driver, int NumofCustomer, Company com) {
		Scanner in = new Scanner(System.in);
		Customers cus = new Customers();
		
		if(driver != 1) {
			String name1, surname1, email1, password1;
			System.out.println("Please enter name: ");
			name1 = in.next();
			System.out.println("Surname: ");
			surname1 = in.next();
			System.out.println("Email: ");
			email1 = in.next();
			System.out.println("Password: ");
			password1 = in.next();
			cus = cus.setCustomer(name1, surname1, email1, password1, NumofCustomer, com);
			com.customer.add(NumofCustomer, cus);
		}else {
			cus = cus.setCustomer(name, surname, email, password, NumofCustomer, com);
			com.customer.add(NumofCustomer, cus);
		}
		
		com.customer.get(NumofCustomer).getCustomer(NumofCustomer, com);
		
		return com.customer;
	}
	
	void getCustomer(int customerNum, Company com) {
		System.out.println("Name: " + com.customer.get(customerNum).name + "Surname: " + com.customer.get(customerNum).surname + "Email: " + com.customer.get(customerNum).email + "Password: " + com.customer.get(customerNum).password + "ID: " + com.customer.get(customerNum).id);
	}
	
	KWArrayList<Customers> searchProduct(String productName, int isRequested, String productColor, String modelName, int returnStatement, int customerNum, Company com) {
		int productType = 6;
		if(productName.equals("OfficeChairs")) {
			productType = 0;
		}else if(productName.equals("OfficeDesks")) {
			productType = 1;
		}else if(productName.equals("OfficeCabinets")) {
			productType = 2;
		}else if(productName.equals("MeetingTables")) {
			productType = 3;
		}else if (productName.equals("Bookcases")) {
			productType = 4;
		}else {
			System.out.println("Product is not available. Try again...");
		}
		
		Wrapper wrapper = new Wrapper();
		wrapper.value = 0;
		
		for(int i = 0; i < com.branch.size; i++) {
				switch(productType) {
				case 0:
					com.customer = com.branch.get(i).officeChair.get(0).searchProduct(i, productName, isRequested, productColor, modelName, returnStatement, customerNum, wrapper, com);
					break;
				case 1:
					com.customer = com.branch.get(i).officeDesk.get(0).searchProduct(i, productName, isRequested, productColor, modelName, returnStatement, customerNum, wrapper, com);
					break;
				case 2:
					com.customer = com.branch.get(i).officeCabinet.get(0).searchProduct(i, productName, isRequested, productColor, modelName, returnStatement, customerNum, wrapper, com);
					break;
				case 3:
					com.customer = com.branch.get(i).meetingTable.get(0).searchProduct(i, productName, isRequested, productColor, modelName, returnStatement, customerNum, wrapper, com);
					break;
				case 4:
					com.customer = com.branch.get(i).bookcase.get(0).searchProduct(i, productName, isRequested, productColor, modelName, returnStatement, customerNum, wrapper, com);
					break;
				}
				if(wrapper.value == 1) {
					break;
				}
		}
		return com.customer;
	}
	
	void productLists(Company com) {
		for(int i = 0; i < com.branch.size; i++) {
			System.out.println("Products in the branch named: " + com.branch.get(i).Branchname);
			System.out.print("\n");
			System.out.println("Office Chairs models: ");
			for(int j = 0; j < com.branch.get(i).officeChair.get(0).models.length; j++) {
				for(int k = 0; k < com.branch.get(i).officeChair.get(0).models[j].colorNum; k++) {
					System.out.println("Model: " + com.branch.get(i).officeChair.get(0).models[j].modelName + " " + "Color: " + com.branch.get(i).officeChair.get(0).models[j].colorNames[k]);
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			System.out.println("Office Desks models: ");
			for(int j = 0; j < com.branch.get(i).officeDesk.get(0).models.length; j++) {
				for(int k = 0; k < com.branch.get(i).officeDesk.get(0).models[j].colorNum; k++) {
					System.out.println("Model: " + com.branch.get(i).officeDesk.get(0).models[j].modelName + " " + "Color:" + com.branch.get(i).officeDesk.get(0).models[j].colorNames[k]);
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			System.out.println("Office Cabinets models: ");
			for(int j = 0; j < com.branch.get(i).officeCabinet.get(0).models.length; j++) {
				for(int k = 0; k < com.branch.get(i).officeCabinet.get(0).models[j].colorNum; k++) {
					System.out.println("Model: " + com.branch.get(i).officeCabinet.get(0).models[j].modelName + " " + "Color: " + com.branch.get(i).officeCabinet.get(0).models[j].colorNames[k]);
				}
				System.out.print("\n");
			}
			System.out.print("\n");
			System.out.println("Meeting Tables models: ");
			for(int j = 0; j < com.branch.get(i).meetingTable.get(0).ModelNum; j++) {
				System.out.println("Model: " +  com.branch.get(i).meetingTable.get(0).models[j].modelName);
			}
			System.out.print("\n");
			System.out.println("Bookcases models: ");
			for(int j = 0; j < com.branch.get(i).bookcase.get(0).ModelNum; j++) {
				System.out.println("Model: " +  com.branch.get(i).bookcase.get(0).models[j].modelName);
			}
			System.out.print("\n");
			System.out.print("\n");
		}
	}
	
	void shopOnline(String productName, String productColor, String modelName, int customerNum, Company com) {
		searchProduct(productName, 1, productColor, modelName, 1, customerNum, com);
	}
	
	void checkPreviousOrders(Company com, int id) {
			int flag = 0, flag1 = 0;
				for(int i = 0; i < com.customer.size/2; i++) {
					if(com.customer.get(i).id == id) {
						flag = 1;
						if(com.customer.get(i).orders != null) {
							flag1 = 1; 
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
			
			if(flag1 == 0) {
				System.out.println("There is nothing to show please shop first.");
			}
			if(flag == 0) {
				System.out.println("Customer number is not valid. Try again or subscribe again...");
			}
	}
}
