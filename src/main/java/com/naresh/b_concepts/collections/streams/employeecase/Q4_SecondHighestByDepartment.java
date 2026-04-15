package com.naresh.b_concepts.collections.streams.employeecase;

import java.util.*;
import java.util.stream.*;

/**
 * Multiple ways to compute the second-highest salaried employee(s) per department.
 * Kept original approach (renamed), and added simpler/alternative implementations
 * with short pattern and complexity notes.
 */
public class Q4_SecondHighestByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 70000, "HR"),
            new Employee("Bob", 60000, "HR"),
            new Employee("Charlie", 60000, "HR"),
            new Employee("Dave", 90000, "IT"),
            new Employee("Eve", 85000, "IT"),
            new Employee("Frank", 90000, "IT"),
            new Employee("Grace", 50000, "Sales"),
            new Employee("Prince", 40000, "Sales")
        );

        System.out.println("Original (stream) approach:");
        secondHighestByDepartment_streamOriginal(employees).forEach(System.out::println);

        System.out.println("\nSimpler stream variant:");
        secondHighestByDepartment_streamSimpler(employees).forEach(System.out::println);

        System.out.println("\nTreeSet per-group approach:");
        secondHighestByDepartment_treeSet(employees).forEach(System.out::println);

        System.out.println("\nPriorityQueue per-group approach:");
        secondHighestByDepartment_priorityQueue(employees).forEach(System.out::println);
    }

    // ORIGINAL APPROACH (kept and renamed)
    // Pattern: Grouping + distinct salaries sorted descending
    // Complexity: O(N log M) where M is unique salaries per group; sorting per group dominates
    public static List<Employee> secondHighestByDepartment_streamOriginal(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return Collections.emptyList();
        }

        return employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment))
            .values().stream()
            .flatMap(group -> {
                List<Double> distinctSalariesDesc = group.stream()
                    .map(e -> Double.valueOf(e.getSalary()))
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

                if (distinctSalariesDesc.size() < 2) {
                    return Stream.empty();
                }

                Double secondHighest = distinctSalariesDesc.get(1);
                return group.stream().filter(e -> Double.valueOf(e.getSalary()).equals(secondHighest));
            })
            .collect(Collectors.toList());
    }

    // Alternative 1: Stream - simpler readable variant
    // Pattern: grouping -> map distinct salaries -> pick second using limited sorted stream
    // Complexity: O(N log M)
    public static List<Employee> secondHighestByDepartment_streamSimpler(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return Collections.emptyList();
        }

        return employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment))
            .entrySet()
            .stream()
            .flatMap(entry -> {
                List<Double> descending = entry.getValue().stream()
                    .map(emp -> Double.valueOf(emp.getSalary()))
                    .distinct()
                    .sorted(Comparator.reverseOrder())
                    .limit(2)
                    .collect(Collectors.toList());
                if (descending.size() < 2) return Stream.empty();
                Double second = descending.get(1);
                return entry.getValue().stream().filter(emp -> Double.valueOf(emp.getSalary()).equals(second));
            })
            .collect(Collectors.toList());
    }

    // Alternative 2: Use a TreeSet per group (keeps salaries sorted and distinct)
    // Pattern: grouping -> TreeSet (desc) -> pick second
    // Complexity: O(N log M)
    public static List<Employee> secondHighestByDepartment_treeSet(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return Collections.emptyList();

        Map<String, NavigableSet<Double>> map = new HashMap<>();
        for (Employee emp : employees) {
            map.computeIfAbsent(emp.getDepartment(), d -> new TreeSet<>(Comparator.reverseOrder()))
                .add(Double.valueOf(emp.getSalary()));
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<String, NavigableSet<Double>> e : map.entrySet()) {
            NavigableSet<Double> set = e.getValue();
            if (set.size() < 2) continue;
            Iterator<Double> it = set.iterator();
            it.next(); // highest
            Double second = it.next();
            final Double sec = second;
            String dept = e.getKey();
            employees.stream()
                .filter(emp -> emp.getDepartment().equals(dept) && Double.valueOf(emp.getSalary()).equals(sec))
                .forEach(result::add);
        }
        return result;
    }

    // Alternative 3: PriorityQueue per group (keeping top-2 distinct salaries)
    // Pattern: grouping + PQ of size 2 on distinct salaries
    // Complexity: O(N log M)
    public static List<Employee> secondHighestByDepartment_priorityQueue(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return Collections.emptyList();

        Map<String, Set<Double>> distinct = new HashMap<>();
        for (Employee emp : employees) {
            distinct.computeIfAbsent(emp.getDepartment(), d -> new HashSet<>()).add(Double.valueOf(emp.getSalary()));
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<String, Set<Double>> e : distinct.entrySet()) {
            PriorityQueue<Double> minHeap = new PriorityQueue<>();
            for (Double s : e.getValue()) {
                minHeap.offer(s);
                if (minHeap.size() > 2) minHeap.poll();
            }
            if (minHeap.size() < 2) continue;
            // when size==2, polling yields the smaller of the two => second highest
            Double second = minHeap.poll();
            final Double sec = second;
            String dept = e.getKey();
            employees.stream()
                .filter(emp -> emp.getDepartment().equals(dept) && Double.valueOf(emp.getSalary()).equals(sec))
                .forEach(result::add);
        }
        return result;
    }

    // Backwards-compatible method name
    public static List<Employee> secondHighestByDepartment(List<Employee> employees) {
        return secondHighestByDepartment_streamOriginal(employees);
    }
}