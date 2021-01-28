package com.poo.lab12.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.poo.lab12.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess
        Map<Disability, List<Employee>> map = new HashMap<>();
        business.getEmployees().forEach(employee -> {
            if (map.containsKey(employee.getDisability())) {
                List<Employee> employeeList = map.get(employee.getDisability());
                employeeList.add(employee);
            } else {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(employee);
                map.put(employee.getDisability(), employeeList);
            }
        });
        return map;
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count
        Map<Gender, HashSet<Employee>> map = new HashMap<>();
        business.getEmployees().forEach(employee -> {
            if (map.containsKey(employee.getGender())) {
                HashSet<Employee> set = map.get(employee.getGender());
                set.add(employee);
            } else {
                HashSet<Employee> set = new HashSet<>();
                set.add(employee);
                map.put(employee.getGender(), set);
            }
        });
        for (Map.Entry<Gender, HashSet<Employee>> entry : map.entrySet()) {
            if (entry.getKey().equals(Gender.FEMALE)) {
                return entry.getValue().size();
            }
        }
        return 0;
    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMinByGenderSortedByCitySortedByAge(Business business) {
        // Get the employees with majority by religion, from this group select the subgroup that has the minority by gender
        // Sort the set by city and, in case of equality, by age
        Map<Religion, List<Employee>> map = business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion));
        List<Employee> byReligion = null;
        int mx = -1;
        for (Map.Entry<Religion, List<Employee>> entry : map.entrySet()) {
            if(entry.getValue().size() > mx) {
                mx = entry.getValue().size();
                byReligion = entry.getValue();
            }
        }
        assert byReligion != null;
        Map<Gender, List<Employee>> map1 = byReligion.stream().collect(Collectors.groupingBy(Employee::getGender));
        List<Employee> byGender = null;
        int mn = 100000;
        for (Map.Entry<Gender, List<Employee>> entry : map1.entrySet()) {
            if(entry.getValue().size() < mn) {
                mn = entry.getValue().size();
                byGender = entry.getValue();
            }
        }
        assert byGender != null;
        SortedSet<Employee> employees1 = new TreeSet<>(Comparator.comparing(Employee::getCity).thenComparing(Employee::getAge));
        employees1.addAll(byGender);
        return employees1;
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        // Group employees by religion, count the accounts in each group, return the religion with biggest score
        Map<Religion, List<Employee>> map = new HashMap<>();
        business.getEmployees().forEach(employee -> {
            if (map.containsKey(employee.getReligion())) {
                List<Employee> employeeList = map.get(employee.getReligion());
                employeeList.add(employee);
            } else {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(employee);
                map.put(employee.getReligion(), employeeList);
            }
        });
        int mx = -1;
        Religion religion = null;
        for(Map.Entry<Religion, List<Employee>> entry : map.entrySet()) {
            int val = 0;
            for(Employee employee : entry.getValue()) {
                val += employee.getAccounts().size();
            }
            if(mx < val) {
                mx = val;
                religion = entry.getKey();
            }
        }
        return religion;
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by city (Map<String, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)
        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getReligion, Collectors.groupingBy(Employee::getGender)));
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(Business business) {
        // Map the employees to the business projects (not to their respective projects)
        Map<Project, Map<String, List<Employee>>> map = new HashMap<>();
        business.getProjects().forEach(project -> {
            business.getEmployees().forEach(employee -> {
                if (employee.getProjects().contains(project)) {
                    if (map.get(project) == null) {
                        Map<String, List<Employee>> map1 = new HashMap<>();
                        map.put(project, map1);
                    }
                    if (map.get(project).get(employee.getCity()) == null) {
                        List<Employee> employeeList = new ArrayList<>();
                        map.get(project).put(employee.getCity(), employeeList);
                    }
                    map.get(project).get(employee.getCity()).add(employee);
                }

            });
        });
        return map;
    }
}
