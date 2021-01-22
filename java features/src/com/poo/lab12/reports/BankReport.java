package com.poo.lab12.reports;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.poo.lab12.entities.*;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        // All the customers that have accounts at the bank
        return bank.getClients().stream().mapToInt(business -> business.getEmployees().size()).sum();
    }

    public static int getNumberOfAccounts(Bank bank) {
        // Accounts of all the customers of the bank
        return bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).mapToInt(employee -> employee.getAccounts().size()).sum();
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order
        SortedSet<Employee> employeeSortedSet = new TreeSet<>(Comparator.comparing(Employee::getName));
        bank.getClients().stream().map(Business::getEmployees).forEach(employeeSortedSet::addAll);
        return employeeSortedSet;
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances
         return bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).flatMap(employee -> employee.getAccounts().stream()).mapToDouble(Account::getBalance).sum();
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance
        SortedSet<Account> accounts = new TreeSet<>(Comparator.comparingDouble(Account::getBalance));
        bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).map(Employee::getAccounts).forEach(accounts::addAll);
        return accounts;
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts
        return bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).collect(Collectors.toMap(employee -> employee, Employee::getAccounts, (a, b) -> b));
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities
        Map<String, List<Employee>> map = new HashMap<>();
        bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).forEach(employee -> {
            if (map.containsKey(employee.getCity())) {
                List<Employee> employeeList = map.get(employee.getCity());
                employeeList.add(employee);
            } else {
                List<Employee> newList = new ArrayList<>();
                newList.add(employee);
                map.put(employee.getCity(), newList);
            }
        });
        return map;
    }

    public static Project getProjectWorkedOnByMostCustomers(Bank bank) {
        // Get all the projects from the employees and find the most repeated one in the list
        Map<Project, Integer> map = new HashMap<>();
        bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).flatMap(employee -> employee.getProjects().stream()).forEach(project1 -> {
            if (map.containsKey(project1)) {
                int x = map.get(project1);
                map.put(project1, x + 1);
            } else {
                map.put(project1, 1);
            }
        });
        int mx = -1;
        Project project = new Project();
        for (Map.Entry<Project, Integer> entry : map.entrySet()) {
            if (mx < entry.getValue()) {
                mx = entry.getValue();
                project = entry.getKey();
            }
        }
        return project;
    }

    public static Gender getGenderWhoWorkedOnMostProjects(Bank bank) {
        // Get all the pairs <gender, project> or <gender, List<project>>, then reduce the array to only one pair
        // of each gender and retrieve the one with most counted projects (you are expected to count duplicates as well).
        Map<Gender, List<Project>> map = new HashMap<>();
        bank.getClients().stream().flatMap(business -> business.getEmployees().stream()).forEach(employee -> {
            if (map.containsKey(employee.getGender())) {
                List<Project> projects = map.get(employee.getGender());
                projects.addAll(employee.getProjects());
            } else {
                map.put(employee.getGender(), new ArrayList<>(employee.getProjects()));
            }
        });
        int mx = 0;
        Gender gender = null;
        for (Entry<Gender, List<Project>> entry : map.entrySet()) {
            if (entry.getValue().size() > mx) {
                mx = entry.getValue().size();
                gender = entry.getKey();
            }
        }
        return gender;
    }
}
