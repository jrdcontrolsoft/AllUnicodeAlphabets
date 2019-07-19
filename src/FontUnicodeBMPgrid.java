
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


import java.sql.*;

public class FontUnicodeBMPgrid extends JFrame {
	
	private PopupErrorHandler allErrors = new PopupErrorHandler();
	
	private class PopupErrorHandler {
		//show a popup window to the user with (default) error info
		public void handle(Exception passedExp) {
	        JOptionPane.showMessageDialog(null, passedExp.toString());
		}
	}
	
    
	//program methods
	public void shutdownRequested() {
	}
	
	public void closeProgram() {
		FontUnicodeBMPgrid.this.dispose();	//disposing the Frame closes the program
	}
	
	public FontUnicodeBMPgrid(JComponent mainComp, JComponent topComp) {
		//constructor
		add(mainComp);
		add(BorderLayout.PAGE_START, topComp);
	}
	
	public static void main(String[] args) {
		//main instances the program (all in a Swing JPanel)
		
		//Look and Feel: native Mac, Windows, or whatever 
    	try {
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
        	//swallow error: default Look-and-Feel will result anyway
        }
        
        final int gridDim = 256;	//128;	//64;
        final int cellDim = 15;	//10;
        /*
        dataTable.setDragEnabled(false);
        dataTable.setCellSelectionEnabled(true);
        //dataTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        //single cell selection only:
        dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        */
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] allFonts = ge.getAvailableFontFamilyNames();
        Font uniFont = new JTable().getFont();	//default font
        //System.out.println(uniFont.getSize());
        //Font uniFont = new Font("Times New Roman", Font.PLAIN, 11);
        //Font uniFont = new Font("Tahoma", Font.PLAIN, 11);
        final AllBMPtableModel dataModel = new AllBMPtableModel(gridDim, uniFont);
        //final JTable dataTable = new SquareGridTable(new AllBMPtableModel(gridDim, uniFont), cellDim, uniFont);
        final JTable dataTable = new SquareGridTable(dataModel, cellDim, uniFont);
        //System.out.println(dataTable.getFont().getSize());
        //dataTable.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        //dataTable.setFont(dataTable.getFont().deriveFont(11f));
        /*
        dataTable.setDefaultRenderer(String.class, new DefaultTableCellRenderer(){
        	public Component getTableCellRendererComponent(JTable table, Object value, 
        			boolean isSelected, boolean hasFocus, int row, int column) {
            	Component stdRend = super.getTableCellRendererComponent(table, value, isSelected, hasFocus
                	, row, column);
            	stdRend.setBackground(new Color(255, row, column));
            	return stdRend;
        	}
        });
        */
        //dataTable.setDefaultRenderer(String.class, new PlaneBMPrenderer(uniFont));
        dataTable.setDefaultRenderer(String.class, new PlaneBMPrenderer());
        
        JComboBox fontPicker = new JComboBox(allFonts);
        fontPicker.setEditable(false);
        fontPicker.setSelectedItem(uniFont.getFontName());
        fontPicker.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) { 
            	//uniFont = new Font((String) ((JComboBox)e.getSource()).getSelectedItem(), Font.PLAIN, 11);
            	Font pickedFont = new Font((String) ((JComboBox)e.getSource()).getSelectedItem(), Font.PLAIN, 11);
            	dataTable.setFont(pickedFont);
            	dataModel.setFont(pickedFont);
            }
        });
        
    	final FontUnicodeBMPgrid f 
			= new FontUnicodeBMPgrid(new JScrollPane(dataTable), fontPicker);
    	
		SwingUtilities.invokeLater(
			//the usual way to start a Swing program: stuff everything in a Runnable
			new Runnable() {
				public void run() {
					f.setTitle(f.getClass().getSimpleName());
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							f.shutdownRequested();
						}
					});
					f.setSize(1900, 1024);
					//f.setSize(20*11, 20*12);
					//f.setSize(cellDim*gridDim+16, cellDim*gridDim+38);
					/*
					f.setIconImage(new ImageIcon(getClass().getResource(
						"bitmaps/progicon.gif")).getImage());
					*/
					f.setVisible(true);
				}
			}
		);
		
	}
	
}
