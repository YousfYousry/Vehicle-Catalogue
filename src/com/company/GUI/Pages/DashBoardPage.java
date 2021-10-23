package com.company.GUI.Pages;
import com.company.GUI.CustomElements.HintTextField;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class DashBoardPage extends JFrame{

    public DashBoardPage(String title){
        setTitle(title);
        JLabel searchLabel = new JLabel("Search: ");
//        searchLabel.setBorder(new EmptyBorder(new Insets(0,-5,0,0)));
        HintTextField searchField = new HintTextField("Enter Name Or ...");
        searchField.setPreferredSize(new Dimension(50, 25));
//        JButton filterButton = new JButton();
//        filterButton.addActionListener(e->{
//            ImageIcon img = new ImageIcon(System.getProperty("user.dir")+"\\assets\\fliter.png");
//            JFrame jframe = new JFrame("Filter");
//            new SetDashboardMenu();
//            jframe.setIconImage(img.getImage());
//            jframe.setLayout(new BorderLayout());
//            jframe.add(new DashBoardPage(), BorderLayout.CENTER);
//            jframe.setPreferredSize(new Dimension(300, 400));
//            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            jframe.pack();
//            jframe.setVisible(true);
//            jframe.setLocationRelativeTo(null);
//        });
//        ImageIcon img = new ImageIcon(System.getProperty("user.dir")+"\\assets\\fliter.png");
//        filterButton.setIcon(new ImageIcon(getScaledImage(img.getImage(),20, 20)));
//        filterButton.setPreferredSize(new Dimension(30, 30));
//        JPanel SearchPanel = new JPanel();
//        SearchPanel.setLayout(new GridBagLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,0,0);
        add(searchLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,5,5,5);
        add(searchField, gbc);

//        ArrayList<String> myList = new ArrayList<>();
//        myList.add("sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1sdaffdsdfsdfsfds1");
//        myList.add("1");
//        myList.add("1");
//        myList.add("1");
//        myList.add("1");
//        myList.add("1");

//        final JList<String> list = new JList<>(myList.toArray(new String[myList.size()]));
//        JScrollPane scrollPane = new JScrollPane();
//        list.setLayoutOrientation(JList.VERTICAL_WRAP);


//        HintTextField searchField2 = new HintTextField("");
//        searchField2.setPreferredSize(new Dimension(50, 25));

//        Object data[][]={
//                {100,new JButton("Amit"),"670000","700000" ,"700000","700000","700000","700000","700000","700000","700000","700000","700000"},
//                {102,new JButton("Jai"),"780000"           ,"700000","700000","700000","700000","700000","700000","700000","700000","700000","700000"},
//                {101,new JButton("Sachin"),"700000"        ,"700000","700000","700000","700000","700000","700000","700000","700000","700000","700000"}};
//        String column[]={"ID","NAME","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY","SALARY"};
        JTable jt;
//                =new JTable(data,column)
        TableCellRenderer tableRenderer;
        jt = new JTable(new JTableButtonModel());
        tableRenderer = jt.getDefaultRenderer(JButton.class);
        jt.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));


//        {
//            DefaultTableCellRenderer renderRight = new DefaultTableCellRenderer();
//
//            { // initializer block
//                renderRight.setHorizontalAlignment(SwingConstants.LEFT);
//            }
//
//            @Override
//            public TableCellRenderer getCellRenderer (int arg0, int arg1) {
//                return renderRight;
//            }
//        };
//        jt.setModel(new DefaultTableModel(data, column) {
//            Class[] types = { Integer.class, JButton.class,  JButton.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class };
//
//            @Override
//            public Class getColumnClass(int columnIndex) {
//                return this.types[columnIndex];
//            }
//
//            @Override
//            public Object getValueAt(int row, int column) {
//                return (column==1)? new JButton():super.getValueAt(row, column);
//            }
//        });
        jt.setUpdateSelectionOnSort(true);
        jt.setAutoCreateRowSorter(true);
        jt.setRowSelectionAllowed(true);
//        jt.setCellSelectionEnabled(false);
        jt.setAutoCreateRowSorter(true);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jt.setFillsViewportHeight(true);
        jt.setFillsViewportHeight(true);

//        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
//        jt.getColumn("NAME").setCellRenderer(buttonRenderer);
//        jt.getColumn("SALARY").setCellRenderer(buttonRenderer);

//        jt.setShowHorizontalLines(true);
//        jt.setShowVerticalLines(false);

        JScrollPane scrollPane = new JScrollPane(jt);
//        scrollPane.setViewportView(list);
//        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane,BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,20,0);
        add(contentPane, gbc);

//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.weightx = 1;
//        gbc.weighty = 1;
//        gbc.fill = GridBagConstraints.BOTH;
//        add(searchField, gbc);
//        gbc.fill = GridBagConstraints.BOTH;
//        SearchPanel.setLayout(new BoxLayout(SearchPanel, BoxLayout.Y_AXIS));
//        SearchPanel.add(searchLabel);
//        SearchPanel.add(searchField);
//        add(searchLabel, BorderLayout.NORTH);
//        add(searchField, BorderLayout.CENTER);
//        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    class JTableButtonRenderer implements TableCellRenderer {
        private TableCellRenderer defaultRenderer;
        public JTableButtonRenderer(TableCellRenderer renderer) {
            defaultRenderer = renderer;
        }
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(value instanceof Component)
                return (Component)value;
            return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    class JTableButtonModel extends AbstractTableModel {
        private Object[][] rows = {{"Button1", new JButton("Button1")},{"Button2", new JButton("Button2")},{"Button3", new JButton("Button3")}, {"Button4", new JButton("Button4")}};
        private String[] columns = {"Count", "Buttons"};
        public String getColumnName(int column) {
            return columns[column];
        }
        public int getRowCount() {
            return rows.length;
        }
        public int getColumnCount() {
            return columns.length;
        }
        public Object getValueAt(int row, int column) {
            return rows[row][column];
        }
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
        }
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
