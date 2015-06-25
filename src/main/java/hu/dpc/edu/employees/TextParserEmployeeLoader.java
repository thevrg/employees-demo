package hu.dpc.edu.employees;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author IQJB
 */
public class TextParserEmployeeLoader implements EmployeeLoader {

    private ReadableSource readableSource;

    private static final Set<String> VALID_TYPES;

    static {
        VALID_TYPES = Collections.unmodifiableSet(
                new HashSet<>(
                        Arrays.asList("Employee", "Manager", "Secretary")
                ));

    }

    public TextParserEmployeeLoader(ReadableSource readableSource) {
        this.readableSource = readableSource;
    }

    @Override
    public List<Employee> loadEmployees() {

        List<Employee> employees = new ArrayList<>();

        try (Reader in = readableSource.createReader()) {
            Scanner scanner = new Scanner(in).useDelimiter("\n");

            while (scanner.hasNext()) {
                String line = scanner.next();
                Scanner scan = new Scanner(line).useDelimiter(",");
                String type = scan.next();
                long id = scan.nextLong();
                String name = scan.next();
                double salary = scan.nextDouble();

                if (VALID_TYPES.contains(type)) {

                    Class<? extends Employee> clazz = (Class<? extends Employee>) Class.forName("hu.dpc.edu.employees." + type);
                    Employee emp = clazz.newInstance();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);

                    if ("Manager".equals(type)) {
                        Manager m = (Manager) emp;
                        final String departmentName = scan.next();

                        m.setManagerOf(new Department(departmentName));
                    }

                    employees.add(emp);
                }
            }
            return employees;
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

}
