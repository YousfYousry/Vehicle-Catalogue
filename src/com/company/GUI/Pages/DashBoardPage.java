package com.company.GUI.Pages;

import com.company.GUI.CustomElements.HintTextField;
import com.company.GUI.CustomTableCells.JTableDateRendere;
import com.company.GUI.CustomTableCells.JTableEditor;
import com.company.GUI.CustomTableCells.JTableRenderer;
import com.company.Records;
import com.company.vehicle;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.company.GUI.Launcher.filter;

public class DashBoardPage extends JFrame {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JLabel searchLabel = new JLabel("Search: ");
    private HintTextField searchField;// a custom class used to show the hint when the jtext field is empty
    private JPanel filterPanel = new JPanel();
    private JLabel bottomLabel = new JLabel("");
    private DefaultTableModel model;
    private String selectedType = "all";
    private String selectedAvailabilty = "all";
    private JXDatePicker productionDateFromList;
    private JXDatePicker productionDateToList;


    public DashBoardPage(String title) {
        setTitle(title);
        setLayout(new GridBagLayout());
        searchField = new HintTextField("Enter Name Or ...", showTable(), this);
        initFilter();
        showSearch();
        showLabel();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                if (Records.getAllRecords() != Records.getOriginal()) {
                    int result = JOptionPane.showOptionDialog(null, "Want to save your changes?", "Vehicle Catalogue",
                            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                            null, new Object[]{"Save", "Don't save",
                                    "Cancel"}, null);
                    if (result == 0) {

                        dispose();
                    } else if (result == 1) {
                        dispose();
                    } else {
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                } else {
                    dispose();

                }

            }
        });
    }

    public void viewSearch(boolean view) {
        if (view) {
            showSearch();
        } else {
            removeSearch();
        }
    }

    public void viewLabel(boolean view) {
        if (view) {
            showLabel();
        } else {
            removeLabel();
        }
    }

    public void viewFilter(boolean view) {
        if (view) {
            showFilter();
        } else {
            removeFilter();
        }
    }

    private void initFilter() {
        GridBagConstraints filterGbc = new GridBagConstraints();

        JLabel category = new JLabel("Category");
//        category.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        final Choice categoryList = new Choice();
        categoryList.setBounds(100, 100, 75, 75);
        categoryList.add("All");
        categoryList.add("Air");
        categoryList.add("Water");
        categoryList.add("Land");


        JLabel availability = new JLabel("Availability");
//        availability.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        final Choice availabilityList = new Choice();
        availabilityList.setBounds(100, 100, 75, 75);
        availabilityList.add("All");
        availabilityList.add("Available");
        availabilityList.add("Unavailable");

        final JLabel productionDate = new JLabel("Production Date");
        productionDate.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

        productionDateFromList = new JXDatePicker();
        productionDateFromList.setDate(getCalendar(1, 1, 2000).getTime());
        productionDateFromList.setFormats(new SimpleDateFormat("dd-MMM-yyyy"));

        productionDateToList = new JXDatePicker();
        productionDateToList.setDate(Calendar.getInstance().getTime());
        productionDateToList.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        JButton clearAll = new JButton("Clear All");
        JButton close = new JButton("");
        close.addActionListener(e -> removeFilter());
        close.setPreferredSize(new Dimension(20, 20));
        ImageIcon closeIcon = new ImageIcon(System.getProperty("user.dir") + "\\assets\\close.png");
        close.setIcon(new ImageIcon(getScaledImage(closeIcon.getImage(), 10, 10)));
        clearAll.addActionListener(e -> {
            categoryList.select(0);
            availabilityList.select(0);
            productionDateFromList.setDate(getCalendar(1, 1, 2000).getTime());
            productionDateToList.setDate(Calendar.getInstance().getTime());
            model.setRowCount(0);
            selectedType = "all";
            selectedAvailabilty = "all";
            for (vehicle vehicle : Records.getAllRecords()) {
                model.addRow(vehicle.getObject());
            }
            updateBottomLabel(model.getRowCount());
        });
        categoryList.addItemListener(e -> {
            selectedType = e.getItem().toString().toLowerCase();
            updateTable();
        });
        availabilityList.addItemListener(e -> {
            selectedAvailabilty = e.getItem().toString().toLowerCase();
            updateTable();
        });
        productionDateFromList.addActionListener(e -> updateTable());
        productionDateToList.addActionListener(e -> updateTable());

        filterPanel.setLayout(new GridBagLayout());
        filterPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        filterGbc.anchor = GridBagConstraints.WEST;

        ImageIcon filterIcon = new ImageIcon(System.getProperty("user.dir") + "\\assets\\filter.png");
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getScaledImage(filterIcon.getImage(), 15, 15)));
        filterGbc.gridx = 0;
        filterGbc.gridy = 0;
        filterGbc.weightx = 0;
        filterGbc.gridwidth = 0;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.NONE;
        filterGbc.insets = new Insets(0, 0, 0, 0);
        filterPanel.add(label, filterGbc);
        filterGbc.gridx = 0;
        filterGbc.gridy = 0;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 0;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.NONE;
        filterGbc.insets = new Insets(5, 25, 5, 0);
        filterPanel.add(new JLabel("Search Filter"), filterGbc);

        filterGbc.anchor = GridBagConstraints.EAST;
        filterGbc.gridx = 0;
        filterGbc.gridy = 0;
        filterGbc.weightx = 0;
        filterGbc.gridwidth = 0;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.NONE;
        filterGbc.insets = new Insets(0, 0, 0, 0);
        filterPanel.add(close, filterGbc);
        filterGbc.anchor = GridBagConstraints.WEST;

        filterGbc.gridx = 0;
        filterGbc.gridy = 1;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 1;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(0, 0, 0, 20);
        filterPanel.add(category, filterGbc);
        filterGbc.gridx = 1;
        filterGbc.gridy = 1;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 2;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(5, 0, 5, 0);
        filterPanel.add(categoryList, filterGbc);

        filterGbc.gridx = 0;
        filterGbc.gridy = 2;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 1;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(0, 0, 0, 20);
        filterPanel.add(availability, filterGbc);
        filterGbc.gridx = 1;
        filterGbc.gridy = 2;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 2;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(5, 0, 5, 0);
        filterPanel.add(availabilityList, filterGbc);

        filterGbc.gridx = 0;
        filterGbc.gridy = 3;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 1;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(0, 0, 0, 0);
        filterPanel.add(productionDate, filterGbc);

        filterGbc.gridx = 1;
        filterGbc.gridy = 3;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 1;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(5, 0, 5, 0);
        filterPanel.add(productionDateFromList, filterGbc);
        filterGbc.gridx = 2;
        filterGbc.gridy = 3;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 1;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(5, 0, 5, 0);
        filterPanel.add(productionDateToList, filterGbc);

        filterGbc.gridx = 1;
        filterGbc.gridy = 4;
        filterGbc.weightx = 1;
        filterGbc.gridwidth = 2;
        filterGbc.weighty = 0;
        filterGbc.fill = GridBagConstraints.HORIZONTAL;
        filterGbc.insets = new Insets(5, 0, 5, 0);
        filterPanel.add(clearAll, filterGbc);

//        showFilter();
    }

    private void showSearch() {
        SwingUtilities.invokeLater(() -> {
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.gridwidth = 2;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 0, 0);
            add(searchLabel, gbc);

            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.gridwidth = 2;
            gbc.insets = new Insets(0, 5, 5, 5);
            add(searchField, gbc);

            invalidate();
            validate();
        });

    }

    private void removeSearch() {
        SwingUtilities.invokeLater(() -> {
            remove(searchLabel);
            remove(searchField);
            invalidate();
            validate();
        });
    }

    private JTable showTable() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0;
            }
        };
        String columnTitle[] = {"Action", "Category", "Name", "Brand", "Date Of Production", "ID Number", "Availability"};
        model.setColumnIdentifiers(columnTitle);
        for (vehicle vehicle : Records.getAllRecords()) {
            model.addRow(vehicle.getObject());
        }
        updateBottomLabel(model.getRowCount());
        JTable jTable = new JTable(model) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                if (column == 0) {
                    tableColumn.setPreferredWidth(20);
                } else {
                    tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                }
                return component;
            }
        };
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnTitle.length; i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jTable.getColumn("Action").setCellEditor(new JTableEditor());
        jTable.getColumn("Action").setCellRenderer(new JTableRenderer(jTable.getDefaultRenderer(JComponent.class)));
        jTable.getColumn("Date Of Production").setCellRenderer(new JTableDateRendere());
        jTable.getColumn("Availability").setCellRenderer(new JTableRenderer(jTable.getDefaultRenderer(Boolean.class)));

        jTable.setColumnSelectionAllowed(false);
//        jTable.setRowSelectionAllowed(true);
        jTable.setUpdateSelectionOnSort(true);

        jTable.setAutoCreateRowSorter(true);
        jTable.setFillsViewportHeight(true);
//        jTable.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//                if (me.getClickCount() == 2) {     // to detect doble click events
//                    JTable target = (JTable)me.getSource();
//                    int row = target.getSelectedRow(); // select a row
//                    int column = target.getSelectedColumn(); // select a column
//                    JOptionPane.showMessageDialog(null, jTable.getValueAt(row, column)); // get the value of a row and column.
//                }
//            }
//        });


        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);

//        contactTableModel = (DefaultTableModel) jTable.getModel();

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 2;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(contentPane, gbc);
        return jTable;
    }

    private void showFilter() {
        SwingUtilities.invokeLater(() -> {
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.weightx = 0;
            gbc.weighty = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 0, 0, 0);
            add(filterPanel, gbc);

            invalidate();
            validate();
        });
    }

    private void removeFilter() {
        SwingUtilities.invokeLater(() -> {
            remove(filterPanel);
            filter.setSelected(false);
            invalidate();
            validate();
        });
    }

    private void showLabel() {
        SwingUtilities.invokeLater(() -> {
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.weightx = 1;
            gbc.weighty = 0;
            gbc.gridwidth = 1;
            gbc.insets = new Insets(0, 5, 5, 5);
            bottomLabel.setHorizontalAlignment(0);
            add(bottomLabel, gbc);
            invalidate();
            validate();
        });
    }

    private void removeLabel() {
        SwingUtilities.invokeLater(() -> {
            remove(bottomLabel);
            invalidate();
            validate();
        });
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void updateTable() {
        model.setRowCount(0);
        for (vehicle record : Records.filterRecords(selectedType, selectedAvailabilty, productionDateFromList.getDate(), productionDateToList.getDate())) {
            model.addRow(record.getObject());
        }
        updateBottomLabel(model.getRowCount());
    }

    public void displayAll() {
        model.setRowCount(0);
        for (vehicle record : Records.getAllRecords()) {
            model.addRow(record.getObject());
        }
        updateBottomLabel(model.getRowCount());
    }

    private Calendar getCalendar(int day, int month, int year) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month - 1);
        date.set(Calendar.DAY_OF_MONTH, day);
        return date;
    }

    public void updateBottomLabel(int size) {
        bottomLabel.setText("Number of Record: " + size);
    }
}
