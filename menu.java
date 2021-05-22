
import java.util.Scanner;

class menu {
	void showMenu() {
		
		int NumofCustomer = 0, flag1 = 0;
		
		//Default Company
		Company company = new Company();
		company = company.initialAssignments(company);
		
		System.out.println("Welcome To Furniture Company Menu\nDo you want to give a name to this company? (y or n)");
		
		Scanner in = new Scanner(System.in);
		String selection = in.next();
		
		if(selection.equals("y")) {
			
			System.out.println("Please enter the name of the company: ");
			String name = in.next();
			
			System.out.println("Please enter the name of the administrator: ");
			String adminName = in.next();
			
			company.setCompany(name, adminName);
			
		}else {
			company.setCompany("GURLER Furniture", "merve");
		}
		
		int select = 0;
		while(select != 4) {
			System.out.println("Which user type do you want to continue with?\n1.Administrator\n2.Branch Employee\n3.Customer\n4.Quit");
			select = in.nextInt();
			if(select == 1) {
				while(select != 6) {
					System.out.println("You entered as an administrator!\nWhat do you want to do?\n1.Add branch\n2.Remove Branch"
							+ "\n3.Add Branch Employee\n4.Remove Branch Employee\n5.Query\n6.Quit");
					
					select = in.nextInt();
					
					if(select == 1) {	
						System.out.println("How many branches do you want to add?");
						int a = in.nextInt();
						String[] branchNames = new String[a];
						
						System.out.println("Please enter the name of the branches do you want to add!");
						for(int i = 0; i < a; i++) {
							String b = in.next();
							branchNames[i] = new String();
							branchNames[i] = b;
						}
						
						company.branch = company.administrators.get(0).addBranch(branchNames, a, company);
						
					}else if(select == 2) {
						System.out.println("How many branches do you want to remove?");
						int a = in.nextInt();
						String[] branchNames = new String[a];
						
						System.out.println("Please enter the name of the branches do you want to remove!");
						for(int i = 0; i < a; i++) {
							String b = in.next().toString();
							branchNames[i] = new String();
							branchNames[i] = b;
						}
						
						company.branch = company.administrators.get(0).removeBranch(branchNames, a, company);
						
					}else if(select == 3) {
						System.out.println("Please enter the name, surname and email adress of the branch employee do you want to add!");
						String branchEmpName = in.next().toString();
						String branchEmpSurname = in.next().toString();
						String branchEmpEmail = in.next().toString();
						
						company.branchEmployees = company.administrators.get(0).addBranchEmployee(branchEmpName, branchEmpSurname, branchEmpEmail, null, company);
						
						company.branchEmployees.get(1).getBranchEmployee();
						
					}else if(select == 4) {
						System.out.println("Please enter the name, surname and email adress of the branch employee do you want to remove!");
						String branchEmpName = in.next().toString();
						String branchEmpSurname = in.next().toString();
						String branchEmpEmail = in.next().toString();
						
						company.branchEmployees = company.administrators.get(0).removeBranchEmployees(branchEmpName, branchEmpSurname, branchEmpEmail, null, company);
						
						company.branchEmployees.get(0).getBranchEmployee();
						
					}else if(select == 5){
						int flag = 0, branchNum = 0;
						
						System.out.println("Please enter the name of the branch that you want to query:");
						String branchName = in.next().toString();
						for(int i = 0; i < company.branch.size; i++) {
							if(branchName.equals(company.branch.get(i).Branchname)) {
								flag = 1;
								branchNum = i;
								break;
							}
						}
						
						if(flag == 1) {
							System.out.println("Please choose the name of the selling do you want to query!\n1.Office Chairs"
									+ "\n2.Office Desks\n3.Office Cabinets\n4.Meeting Tables\n5.Bookcases");
							int a = in.nextInt();
							
							System.out.println("There are " + company.administrators.get(0).query(a, branchNum, company) + " products in different models and colors.");
							
						}else {
							System.out.println("Invalid branch name. Try again...");
						}
					}else if (select > 6) {
						System.out.println("Invalid selection. Try again!");
					}
				}
			}else if(select == 2) {
				while(select != 5) {
					
					System.out.println("You entered as a branch employee!\nWhat do you want to do?\n1.Check Product Situation"
							+ "\n2.Demonstrate Previous Orders\n3.Add Product\n4.Remove Product\n5.Quit");
					select = in.nextInt();
					
					if(select == 1) {
						
						System.out.println("Please enter the name of the branch: ");
						String branchName = in.next().toString();
						int flag = 0, branchNum = 0;
						
						for(int i = 0; i < company.branch.size; i++) {
							if(branchName.equals(company.branch.get(i).Branchname)) {
								flag = 1;
								branchNum = i;
								break;
							}
						}
						
						if(flag == 1) {
							System.out.println("Please choose the name of the selling do you want to inquire!\n1.Office Chairs\n2.Office Desks"
									+ "\n3.Office Cabinets\n4.Meeting Tables\n5.Bookcases");
							int a = in.nextInt();
							company.branchEmployees.get(0).checkProductSituation(company, branchNum, 0, a);
						}else {
							System.out.println("Invalid branch name. Try again...");
						}
						
					}else if(select == 2) {
						
						System.out.println("Please enter the customer number of the customer (8 digits number): ");
						int customerNum = in.nextInt();
						company.branchEmployees.get(0).demonstratePreOrders(customerNum, company);
						
					}else if(select == 3) {
						
						System.out.println("Please enter the branch name: ");
						String branchName = in.next().toString();
						int branchNum = company.branch.get(0).findBranch(company, branchName);
						
						if(branchNum == -1) {
							System.out.println("Branch is not available. Try again...");
						}else {
							System.out.println("Please enter the product name: ");
							String[] productName = new String[2];
							String proName = null;
							int t = 0, y = 0;
							while(t != 2) {
								productName[t] = new String();
								productName[t]= in.next();
								if(productName[t].equals("Bookcases")) {
									proName = "Bookcases";
									break;
								}
								t++;
							}
							if(proName == null) {
								String sb = new String();
							      for(int i = 0; i < productName.length; i++) {
							         sb += productName[i];
							      }
							    proName = sb.toString();
							}
						    
							System.out.println("Please enter the amount: ");
							int amount = in.nextInt();
							
							String modelNames[] = new String[amount];
							String colorName[] = new String[1];
							int colorNum[] = new int[amount];
							
							for(int  i = 0; i < amount; i++) {
								
								System.out.println("Please enter the model of the product: ");
								String modelName = in.next();
								modelNames[i] = modelName;
								
								if(!proName.equals("MeetingTables")  && !proName.equals("Bookcases")) {
									
									System.out.println("Please enter the number of colors of the product: ");
									int colorAmount = in.nextInt();
									colorNum[i] = colorAmount;
									colorName = new String[colorAmount];
									System.out.println("Please enter the colors of the product: ");
									for(int j = 0; j < colorAmount; j++) {
										String productColor = in.next();
										colorName[y] = productColor;
										y++;
									}
								}
							}
							
							company.branch = company.branchEmployees.get(0).addProduct(proName, branchNum, amount, colorNum, modelNames, colorName, company);
						}
					}else if(select == 4) {
						System.out.println("Please enter the branch name: ");
						String branchName = in.next().toString();
						int branchNum = company.branch.get(0).findBranch(company, branchName);
						
						if(branchNum == -1) {
							System.out.println("Branch is not available. Try again...");
						}else {
							System.out.println("Please enter the product name: ");
							String[] productName = new String[2];
							String proName = null;
							int t = 0, y = 0;
							while(t != 2) {
								productName[t] = new String();
								productName[t]= in.next();
								if(productName[t].equals("Bookcases")) {
									proName = "Bookcases";
									break;
								}
								t++;
							}
							if(proName == null) {
								String sb = new String();
							      for(int i = 0; i < productName.length; i++) {
							         sb += productName[i];
							      }
							    proName = sb.toString();
							}
							
							System.out.println("Please enter the model of the product: ");
							String modelName = in.next();
							
							String productColor = null;
							if(!proName.equals("MeetingTables")  && !proName.equals("Bookcases")) {
		
								System.out.println("Please enter the colors of the product: ");
								productColor = in.next();
							}
							
							company.branch = company.branchEmployees.get(0).removeProduct(proName, branchNum, modelName, productColor, company);
						}
				}
				}
			}else if(select == 3){
				
				while(select != 7) {
					System.out.println("What do you want to do?\n1.Search Products\n2.List Of Products"
							+ "\n3.Learn The Branch Of Product\n4.Shop Online\n5.Chech Previous Orders\n6.Subscribe\n7.Quit");
					select = in.nextInt();
					
					if(select == 6) {
						System.out.println("You entered as a customer!\nPlease subscribe to continue.");
						company.customer = company.customer.get(NumofCustomer).setCustomer(null, null, null, null, 0, NumofCustomer+1, company);
						flag1 = 1;
					}
					else if(select == 1) {
						System.out.println("Please enter the product name: ");
						String[] productName = new String[2];
						String proName = null;
						int t = 0, y = 0;
						while(t != 2) {
							productName[t] = new String();
							productName[t]= in.next();
							if(productName[t].equals("Bookcases")) {
								proName = "Bookcases";
								break;
							}
							t++;
						}
						if(proName == null) {
							String sb = new String();
						      for(int i = 0; i < productName.length; i++) {
						         sb += productName[i];
						      }
						    proName = sb.toString();
						}
						System.out.println("Please enter the model of the product: ");
						String modelName = in.next().toString();
						
						System.out.println("Please enter the color of the product: ");
						String productColor = in.next().toString();
						
						company.customer.get(NumofCustomer).searchProduct(proName, 0, productColor, modelName, 0, 0/*customerNum*/,company);
						
					}else if(select == 2) {
						
						System.out.println("Product list is given below: ");
						company.customer.get(NumofCustomer).productLists(company);
						
					}else if(select == 3) {
						
						System.out.println("Please enter the product name: ");
						String[] productName = new String[2];
						String proName = null;
						int t = 0;
						while(t != 2) {
							productName[t] = new String();
							productName[t]= in.next();
							if(productName[t].equals("Bookcases")) {
								proName = "Bookcases";
								break;
							}
							t++;
						}
						if(proName == null) {
							String sb = new String();
						      for(int i = 0; i < productName.length; i++) {
						         sb += productName[i];
						      }
						    proName = sb.toString();
						}
						System.out.println("Please enter the model of the product: ");
						String modelName = in.next().toString();
						
						String productColor = null;
						
						if(!proName.equals("Bookcases") && !proName.equals("MeetingTables")) {
							System.out.println("Please enter the color of the product: ");
							productColor = in.next().toString();
						}
						
						company.customer.get(NumofCustomer).searchProduct(proName, 1, productColor, modelName, 0, 0/*customerNum*/,company);
						
					}else if(select == 4) {
						
						System.out.println("Please enter the product name: ");
						String[] productName = new String[2];
						String proName = null;
						int t = 0;
						while(t != 2) {
							productName[t] = new String();
							productName[t]= in.next();
							if(productName[t].equals("Bookcases")) {
								proName = "Bookcases";
								break;
							}
							t++;
						}
						if(proName == null) {
							String sb = new String();
						      for(int i = 0; i < productName.length; i++) {
						         sb += productName[i];
						      }
						    proName = sb.toString();
						}
						
						System.out.println("Please enter the model of the product: ");
						String modelName = in.next().toString();
						
						String productColor = null;
						
						if(!proName.equals("Bookcases") && !proName.equals("MeetingTables")) {
							System.out.println("Please enter the color of the product: ");
							productColor = in.next().toString();
						}
						
						company.customer = company.customer.get(NumofCustomer).searchProduct(proName, 1, productColor, modelName, 1, NumofCustomer/*customerNum*/,company);
					}else if(select == 5) {
						System.out.println("Please enter the customer number of the customer (8 digits number)(If you are not subscribed type -1): ");
						int customerNum = in.nextInt();
						if(flag1 == 1 && customerNum != -1) {
							company.customer.get(NumofCustomer).checkPreviousOrders(company, customerNum);
						}else {
							System.out.println("To check your previous orders you must subscribe.");
						}
					}
					
				}
				if(flag1 == 1)
					NumofCustomer++;
			}else {
				System.exit(0);
			}
		}
	}
}
