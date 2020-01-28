package com.cognizant.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.cognizant.model.Employee;

public class EmployeeMain {

	/*
	 * Driver method
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("dummy.txt");
		Collection<Employee> employeeList = new ArrayList<>();
		BufferedReader bufferedReader;
		try {
			Employee employee = null;
			bufferedReader = new BufferedReader(new FileReader(file));
			String st;
			String[] employeeDetails = null;

			while ((st = bufferedReader.readLine()) != null) {
				employeeDetails = st.split("\t");
				employee = new Employee(employeeDetails[0], employeeDetails[1], employeeDetails[2], employeeDetails[3],
						employeeDetails[4], employeeDetails[5], employeeDetails[6], employeeDetails[7],
						employeeDetails[8], employeeDetails[9], employeeDetails[10], employeeDetails[11]);
				employeeList.add(employee);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		printEmployeeData(employeeList);

	}
	
	/*
	 * To print every employee details in a tabular form into a text file
	 */
	private static void printEmployeeData(Collection<Employee> employeeList) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		FileWriter archivo = new FileWriter("output.txt");
		archivo.write(String.format("%1s %40s %40s %40s %40s %100s \r\n" , "Emp ID" , "Full Name" , "Gender" , "Department" , "Salary" , "Address"));
		for (Employee employee : employeeList) {
			System.out.println(employee);
			archivo.write(String.format("%1s %40s %40s %40s %40s %100s \r\n" , employee.getEmployeeId() , employee.getFirstName() + " " + employee.getLastName() , employee.getGender() , employee.getDepartmentName() , employee.getSalary().substring(1) , employee.getStreetAddress() + " " + employee.getCity() + " " + employee.getState()));
		}
		archivo.flush();
		archivo.close();
		out.close();
	}
}

