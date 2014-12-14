package com.blogpost.happygilmor89.protobuf.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTableExample extends JFrame {
    private JTable table;

    // Constructor of main frame
    public SimpleTableExample() {
        // Set the frame characteristics
        setTitle("Simple Table Application");
        setSize(300, 200);
        setBackground(Color.gray);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create a panel to hold all other components
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // Create columns names
        String columnNames[] = {"Id", "Value"};

        // Create a new table instance
        String[][] dataValues = new String[][]{{"0", "Date 0"}};
        DefaultTableModel model = new DefaultTableModel(dataValues, columnNames);
        table = new JTable(model);

        // Add the table to a scrolling pane
        JScrollPane scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
    }

    // Main entry point for this example
    public static void main(String args[]) {
        // Create an instance of the test application
        final SimpleTableExample mainFrame = new SimpleTableExample();
        mainFrame.setVisible(true);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new Runnable() {
            public void run() {
                int counter = 0;
                while (counter < 10) {

                    DefaultTableModel model = (DefaultTableModel) mainFrame.table.getModel();
                    model.addRow(new String[]{model.getRowCount() + "", new Date().toString()});
                    model.fireTableDataChanged();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                    counter++;
                }
            }
        });
    }
}
