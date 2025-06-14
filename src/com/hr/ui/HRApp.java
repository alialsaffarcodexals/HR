package com.hr.ui;

import com.hr.data.DataStore;
import com.hr.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Simple HR management UI.
 */
public class HRApp extends JFrame {
    private final Company company;

    public HRApp() {
        super("HR Management");
        this.company = DataStore.load();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        initUI();
    }

    private void initUI() {
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Add Department", createAddDepartmentPanel());
        tabs.add("Add Employee", createAddEmployeePanel());
        tabs.add("Assign", createAssignPanel());
        tabs.add("Report", createReportPanel());
        tabs.add("List", createListPanel());
        JButton save = new JButton("Save and Exit");
        save.addActionListener(e -> {
            DataStore.save(company);
            System.exit(0);
        });
        add(tabs, BorderLayout.CENTER);
        add(save, BorderLayout.SOUTH);
    }

    private JPanel createAddDepartmentPanel() {
        JPanel p = new JPanel(new GridLayout(3,2));
        JTextField name = new JTextField();
        JTextField loc = new JTextField();
        JButton add = new JButton("Add");
        add.addActionListener((ActionEvent e) -> {
            company.createDepartment(name.getText(), loc.getText());
            JOptionPane.showMessageDialog(this, "Department added");
            name.setText("");
            loc.setText("");
        });
        p.add(new JLabel("Name"));
        p.add(name);
        p.add(new JLabel("Location"));
        p.add(loc);
        p.add(add);
        return p;
    }

    private JPanel createAddEmployeePanel() {
        JPanel p = new JPanel(new GridLayout(6,2));
        JTextField first = new JTextField();
        JTextField last = new JTextField();
        JTextField gender = new JTextField();
        JTextField addr = new JTextField();
        JTextField scale = new JTextField();
        JButton add = new JButton("Add");
        add.addActionListener((ActionEvent e) -> {
            char g = gender.getText().isEmpty()? 'M' : gender.getText().charAt(0);
            company.createEmployee(first.getText(), last.getText(), g, addr.getText(), Integer.parseInt(scale.getText()));
            JOptionPane.showMessageDialog(this, "Employee added");
            first.setText(""); last.setText(""); gender.setText(""); addr.setText(""); scale.setText("");
        });
        p.add(new JLabel("First")); p.add(first);
        p.add(new JLabel("Last")); p.add(last);
        p.add(new JLabel("Gender")); p.add(gender);
        p.add(new JLabel("Address")); p.add(addr);
        p.add(new JLabel("Pay scale")); p.add(scale);
        p.add(add);
        return p;
    }

    private JPanel createAssignPanel() {
        JPanel p = new JPanel(new GridLayout(4,2));
        JComboBox<Employee> empBox = new JComboBox<>(company.getEmployees().toArray(new Employee[0]));
        JComboBox<Department> depBox = new JComboBox<>(company.getDepartments().toArray(new Department[0]));
        JButton assign = new JButton("Assign");
        assign.addActionListener(e -> {
            Employee emp = (Employee)empBox.getSelectedItem();
            Department dep = (Department)depBox.getSelectedItem();
            if(emp.getDepartment()!=null) {
                emp.getDepartment().removeEmployee(emp);
            }
            dep.addEmployee(emp);
            JOptionPane.showMessageDialog(this, "Assigned");
        });
        p.add(new JLabel("Employee")); p.add(empBox);
        p.add(new JLabel("Department")); p.add(depBox);
        p.add(assign);
        return p;
    }

    private JPanel createReportPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JButton gen = new JButton("Generate Report");
        JTextArea area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        gen.addActionListener(e -> area.setText(generateReport()));
        p.add(gen, BorderLayout.NORTH);
        p.add(sp, BorderLayout.CENTER);
        return p;
    }

    private JPanel createListPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JComboBox<Department> depBox = new JComboBox<>(company.getDepartments().toArray(new Department[0]));
        JTextArea area = new JTextArea();
        JScrollPane sp = new JScrollPane(area);
        depBox.addActionListener(e -> {
            Department dep = (Department)depBox.getSelectedItem();
            StringBuilder sb = new StringBuilder();
            for(Employee emp: dep.getEmployees()) {
                sb.append(emp).append(" - ").append(emp.getPayScale()).append("\n");
            }
            area.setText(sb.toString());
        });
        p.add(depBox, BorderLayout.NORTH);
        p.add(sp, BorderLayout.CENTER);
        return p;
    }

    private String generateReport() {
        StringBuilder sb = new StringBuilder();
        double companyTotal = 0;
        for(Department d : company.getDepartments()) {
            sb.append("Department: ").append(d.getName()).append("\n");
            double depTotal = 0;
            for(Employee e : d.getEmployees()) {
                double pay = payForScale(e.getPayScale())/26.0;
                depTotal += pay;
                sb.append("  ").append(e.getFirstName()).append(" ").append(e.getLastName())
                        .append(" (").append(e.getId()).append(") - ")
                        .append(String.format("%.2f", pay)).append("\n");
            }
            sb.append("  Department total: ").append(String.format("%.2f", depTotal)).append("\n\n");
            companyTotal += depTotal;
        }
        sb.append("Company total: ").append(String.format("%.2f", companyTotal)).append("\n");
        return sb.toString();
    }

    private double payForScale(int scale) {
        switch(scale) {
            case 1: return 44245.75;
            case 2: return 48670.32;
            case 3: return 53537.35;
            case 4: return 58891.09;
            case 5: return 64780.20;
            case 6: return 71258.22;
            case 7: return 80946.95;
            case 8: return 96336.34;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HRApp().setVisible(true));
    }
}
