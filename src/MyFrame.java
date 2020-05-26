import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	MyModel model = null;
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);

	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	JButton addButton = new JButton("Add");
	JButton delButton = new JButton("Delete");
	JButton editButton = new JButton("Edit");
	
	JLabel nameLabel = new JLabel("Name:");
	JLabel ageLabel = new JLabel("Age:");
	JLabel gradeLabel = new JLabel("Avarage Grade");
	JLabel genderLabel = new JLabel("Gender:");
	JTextField nameTField = new JTextField();
	JTextField ageTField = new JTextField();
	JTextField gradeTField = new JTextField();
	String[] genders = {"Female","Male"};
	JComboBox<String> genderCombo = new JComboBox<>(genders);
	
	public MyFrame() {
		this.setVisible(true);
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3,1));
		this.add(upPanel);
		this.add(midPanel);
		this.add(downPanel);
		
		//upPanel
		upPanel.setLayout(new GridLayout(4,2));
		upPanel.add(nameLabel);
		upPanel.add(nameTField);
		upPanel.add(ageLabel);
		upPanel.add(ageTField);
		upPanel.add(gradeLabel);
		upPanel.add(gradeTField);
		upPanel.add(genderLabel);
		upPanel.add(genderCombo);
		//midPanel
		midPanel.add(addButton);
		midPanel.add(delButton);
		midPanel.add(editButton);
		addButton.addActionListener(new AddAction());
		//downPanel
		scroller.setPreferredSize(new Dimension(300,100));
		downPanel.add(scroller);
		refreshTable("students");
		
	}//end constructor
	
	public void refreshTable(String tableName) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class AddAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTField.getText();
			int age = Integer.parseInt(ageTField.getText());
			float avrGrade = Float.parseFloat(gradeTField.getText());
			String gender;
			if(genderCombo.getSelectedIndex() == 0) {
				gender = "f";
			}else {
				gender = "m";
			}
			
			conn = DBConnector.getConnection();
			String query = "insert into students values(null,?,?,?,?);";
			
			try {
				state = conn.prepareStatement(query);
				state.setString(1, name);
				state.setInt(2, age);
				state.setFloat(3, avrGrade);
				state.setString(4, gender);
				state.execute();
				refreshTable("students");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}//end method
		
	}//end AddAction
	
}//end class MyFrame
