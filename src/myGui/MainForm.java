package myGui;

import model.Model;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by suad on 12/27/2014.
 */
public class MainForm extends JFrame{

    private JTextField txtSurname;
    private JTextField txtName;
    private JTable myTable ;
    private JButton btnDeleteAll;
    private JButton btnAdd;
    private JLabel lblName;
    private JLabel lblSurname;
    private JPanel mainForm;
    private int counter=0;

    public MainForm() {
        super("Main Form");
        pack();
        setContentPane(mainForm);
        setDefaultCloseOperation(MainForm.EXIT_ON_CLOSE);

        final List<Model> myListData=new ArrayList<Model>();

        final TableModel dataModel=new AbstractTableModel() {
            private String[] columnNames = {"Name","Surname"};
            private Object[][] data = new Object[10][2];

            public int getColumnCount() {
                return columnNames.length;
            }

            public int getRowCount() {
                return data.length;
            }

            public String getColumnName(int col) {
                return columnNames[col];
            }

            public Object getValueAt(int row, int col) {
                return data[row][col];
            }

            /*
             * Don't need to implement this method unless your table's
             * editable.
             */
            public boolean isCellEditable(int row, int col) {
                //Note that the data/cell address is constant,
                //no matter where the cell appears onscreen.
                    return true;
            }

            /*
             * Don't need to implement this method unless your table's
             * data can change.
             */
            public void setValueAt(Object value, int row, int col) {
                data[row][col] = value;
                fireTableCellUpdated(row, col);
            }


        };


        myTable.setModel(dataModel);

        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String two = txtSurname.getText();
                String one = txtName.getText();

                myListData.add(new Model(one,two));
                if(counter<10 && counter>=0){
                    myTable.setValueAt(two,counter,1);
                    myTable.setValueAt(one,counter,0);
                    counter++;
                }
            }
        });
        btnDeleteAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                for(int i=0;i<10;i++){
                    for (int j =0; j<2;j++){
                        myTable.setValueAt("",i,j);
                    }
                }
                counter =0;
            }
        });

        setVisible(true);

    }
}
