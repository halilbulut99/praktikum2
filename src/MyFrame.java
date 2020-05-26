import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = 3;
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	MyModel model = null;
	int id = -1;
	JTabbedPane tab = new JTabbedPane();
	
	JTable table = new JTable();
	JScrollPane scroller = new JScrollPane(table);
	
	JTable tableSec = new JTable();
	JScrollPane scrollerSec = new JScrollPane(tableSec);
	
	JTable tableThr = new JTable();
	JScrollPane scrollerThr = new JScrollPane(tableThr);
	
	JTable tableQue = new JTable();
	JScrollPane scrollerQue = new JScrollPane(tableQue);
	
	JTable tableQue2 = new JTable();
	JScrollPane scrollerQue2 = new JScrollPane(tableQue2);
	
	JPanel query = new JPanel();
	JPanel upQuPanel = new JPanel();
	JPanel midQuPanel = new JPanel();
	JPanel downQuPanel = new JPanel();
	
	JPanel query2 = new JPanel();
	JPanel upQue2Panel = new JPanel();
	JPanel midQue2Panel = new JPanel();
	JPanel downQue2Panel = new JPanel();
	
	JPanel first = new JPanel();
	JPanel second = new JPanel();
	JPanel third = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	JPanel upPanelSec = new JPanel();
	JPanel midPanelSec = new JPanel();
	JPanel downPanelSec = new JPanel();
	
	JPanel upPanelThr = new JPanel();
	JPanel midPanelThr = new JPanel();
	JPanel downPanelThr = new JPanel();
	
	JButton searchButton = new JButton ("Search by name");
	JButton refreshButton =  new JButton ("Refresh");
	JButton addButton = new JButton("Add");
	JButton delButton = new JButton("Delete");
	JButton editButton = new JButton("Edit");
	
	JButton searchButtonSec = new JButton ("Search by name");
	JButton refreshButtonSec =  new JButton ("Refresh");
	JButton addButtonSec = new JButton("Add");
	JButton delButtonSec = new JButton("Delete");
	JButton editButtonSec = new JButton("Edit");
	
	JButton searchButtonThr = new JButton ("Search by price");
	JButton refreshButtonThr =  new JButton ("Refresh");
	JButton addButtonThr = new JButton("Add");
	JButton delButtonThr = new JButton("Delete");
	JButton editButtonThr = new JButton("Edit");
	
	JButton doButtonQu = new JButton("Complex Action");
	JButton doButtonQue = new JButton("Complex Action");
	
	JLabel nameLabelsec = new JLabel("Name:");
	JLabel weightLabel = new JLabel("Weight:");
	
	JTextField nameTFSec = new JTextField();
	JTextField weightTFsec = new JTextField();
	
	JLabel priceLabel = new JLabel("Price:");
	JLabel dataLabel = new JLabel("Date:");
	JLabel nameComboLabel = new JLabel("Client Name:");
	JLabel productComboLabel = new JLabel("Product Name:");
	
	JLabel nameQueLabel = new JLabel("Enter client name:");
	JLabel priceQueLabel = new JLabel("Enter price:");
	JLabel nameQue2Label = new JLabel("Enter product name:");
	JLabel priceQue2Label = new JLabel("Enter price:");
	
	JTextField nameQueTField = new JTextField();
	JTextField priceQueTField = new JTextField();
	JTextField priceQue2TField = new JTextField();
	JTextField nameQue2TField = new JTextField();
	
	JTextField priceTField = new JTextField();
	JTextField dataTField = new JTextField();
	JComboBox<String> nameCombo = new JComboBox<>();
	JComboBox<String> productCombo = new JComboBox<>();
	
	JLabel nameLabel = new JLabel("Name:");
	JLabel ageLabel = new JLabel("Age:");
	JLabel lnameLabel = new JLabel("Last Name");
	JTextField nameTField = new JTextField();
	JTextField ageTField = new JTextField();
	JTextField lnameTField = new JTextField();

	
	public MyFrame() {
		this.setVisible(true);
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(tab);
		tab.addTab("Clients", first);
		tab.addTab("Products", second);
		tab.addTab("Orders", third);
		tab.addTab("Query-1" , query );
		tab.addTab("Query-2" , query2 );
		
		second.setLayout(new GridLayout(3,1));
		third.setLayout(new GridLayout(3,1));
		first.setLayout(new GridLayout(3,1));
		query.setLayout(new GridLayout(3,1));
		query2.setLayout(new GridLayout(3,1));
		query.add(upQuPanel);
		query.add(midQuPanel);
		query.add(downQuPanel);
		
		query2.add(upQue2Panel);
		query2.add(midQue2Panel);
		query2.add(downQue2Panel);
		
		first.add(upPanel);
		first.add(midPanel);
		first.add(downPanel);
		
		second.add(upPanelSec);
		second.add(midPanelSec);
		second.add(downPanelSec);
		
		third.add(upPanelThr);
		third.add(midPanelThr);
		third.add(downPanelThr);
		
		upPanel.setLayout(new GridLayout(4,2));
		upPanelSec.setLayout(new GridLayout(2,2));
		upPanelThr.setLayout(new GridLayout(4,2));
		upQuPanel.setLayout(new GridLayout(2,2));
		upQue2Panel.setLayout(new GridLayout(2,2));
		upQuPanel.add(nameQueLabel);
		upQuPanel.add(nameQueTField);
		upQuPanel.add(priceQueLabel);
		upQuPanel.add(priceQueTField);
		
		upQue2Panel.add(nameQue2Label);
		upQue2Panel.add(nameQue2TField);
		upQue2Panel.add(priceQue2Label);
		upQue2Panel.add(priceQue2TField);
		
		upPanel.add(nameLabel);
		upPanel.add(nameTField);
		upPanel.add(lnameLabel);
		upPanel.add(lnameTField);
		upPanel.add(ageLabel);
		upPanel.add(ageTField);
		
		upPanelSec.add(nameLabelsec);
		upPanelSec.add(nameTFSec);
		upPanelSec.add(weightLabel);
		upPanelSec.add(weightTFsec);
		
		
		upPanelThr.add(priceLabel);
		upPanelThr.add(priceTField);
		upPanelThr.add(dataLabel);
		upPanelThr.add(dataTField);
		upPanelThr.add(nameComboLabel);
		upPanelThr.add(nameCombo);
		upPanelThr.add(productComboLabel);
		upPanelThr.add(productCombo);
		refreshComboClId();
		refreshComboPrId();
		
		midQuPanel.add(doButtonQu);
		midQue2Panel.add(doButtonQue);
		doButtonQu.addActionListener(new doubleSearchCl());
		doButtonQue.addActionListener(new doubleSearch());
		
		midPanel.add(addButton);
		midPanel.add(delButton);
		midPanel.add(editButton);
		midPanel.add(searchButton);
		midPanel.add(refreshButton);
		addButton.addActionListener(new AddAction());
		delButton.addActionListener(new DeleteAction());
		searchButton.addActionListener(new SearchActionCl());
		editButton.addActionListener(new EditActionCl());
		refreshButton.addActionListener(new RefreshActionCl());
		
		midPanelSec.add(addButtonSec);
		midPanelSec.add(delButtonSec);
		midPanelSec.add(editButtonSec);
		midPanelSec.add(searchButtonSec);
		midPanelSec.add(refreshButtonSec);
		addButtonSec.addActionListener(new AddActionProducts());
		delButtonSec.addActionListener(new DeleteActionProducts());
		searchButtonSec.addActionListener(new SearchActionProducts());
		editButtonSec.addActionListener(new EditActionProducts());
		refreshButtonSec.addActionListener(new RefreshActionProducts());
		
		midPanelThr.add(addButtonThr);
		midPanelThr.add(delButtonThr);
		midPanelThr.add(editButtonThr);
		midPanelThr.add(searchButtonThr);
		midPanelThr.add(refreshButtonThr);
		addButtonThr.addActionListener(new AddActionOrders());
		delButtonThr.addActionListener(new DeleteActionOrders());
		searchButtonThr.addActionListener(new SearchActionOrders());
		editButtonThr.addActionListener(new EditActionOrders());
		refreshButtonThr.addActionListener(new RefreshActionOrders());
		
		
		scrollerQue.setPreferredSize(new Dimension(500,150));
		scrollerQue2.setPreferredSize(new Dimension(500,150));
		scroller.setPreferredSize(new Dimension(500,150));
		scrollerSec.setPreferredSize(new Dimension(500,150));
		scrollerThr.setPreferredSize(new Dimension(500,150));
		downQuPanel.add(scrollerQue);
		downQue2Panel.add(scrollerQue2);
		downPanel.add(scroller);
		downPanelSec.add(scrollerSec);
		downPanelThr.add(scrollerThr);
		tableThr.setModel(getFromTableOrders());
		refreshTable1("clients",table);
		refreshTable1("products",tableSec);
		table.addMouseListener(new MouseAction());
		tableSec.addMouseListener(new MouseActionProducts());
		tableThr.addMouseListener(new MouseActionOrders());
		
}//end constructor
	
	public void refreshTable1(String tableName,JTable output) {
		conn = DBConnector.getConnection();
		String sql = "select * from " + tableName;
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
			output.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	private MyModel getFromTableOrders() {
		conn = DBConnector.getConnection();
		String sql = "select order_id ,order_price,order_date,clients_name,products_name from orders join clients on clients_id = client_id join Products on products_id = product_id;";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return model;
		}
	}
	
	class AddAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTField.getText();
			int age = Integer.parseInt(ageTField.getText());
			String lname = lnameTField.getText();
			conn = DBConnector.getConnection();
			String query = "insert into clients values(null,?,?,?);";
			try {
				state = conn.prepareStatement(query);
				state.setString(1, name);
				state.setString(2, lname);
				state.setInt(3, age);
				state.execute();
				refreshTable1("clients",table);
				clearForm();
				refreshComboClId();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}	
	}
	
	class DeleteAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "delete from clients where clients_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable1("clients",table);
				id = -1;
				clearForm();
				refreshComboClId();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class EditActionCl implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTField.getText();
			String lname = lnameTField.getText();
			int age = Integer.parseInt(ageTField.getText());
			conn = DBConnector.getConnection();
			String sql = "update clients set clients_name = ?,clients_lname = ? ,clients_age = ? where clients_id = ?";
			try {
				state= conn.prepareStatement(sql);
				state.setString(1, name);
				state.setInt(3, age);
				state.setString(2, lname);
				state.setInt(4, id);
				state.execute();
				clearForm();
				refreshTable1("clients", table);
				tableThr.setModel(getFromTableOrders());
				refreshComboClId();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	class SearchActionCl implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTField.getText();
			conn = DBConnector.getConnection();
			String sql = "select * from clients where clients_name = ?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				result = state.executeQuery();
				model = new MyModel(result);
				table.setModel(model);
				clearForm();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class RefreshActionCl implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshTable1("clients", table);
			clearForm();
		}
	}
	
	class MouseAction implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			id = Integer.parseInt(table.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				nameTField.setText(table.getValueAt(row, 1).toString());
				ageTField.setText(table.getValueAt(row, 3).toString());
				lnameTField.setText(table.getValueAt(row, 2).toString());
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {	
		}
	}
	
	class AddActionProducts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = nameTFSec.getText();
			Float weight = Float.parseFloat(weightTFsec.getText());
			conn = DBConnector.getConnection();
			String query = "insert into products values(null,?,?);";
			try {
				state = conn.prepareStatement(query);
				state.setString(1, name);
				state.setFloat(2, weight);
				state.execute();
				refreshTable1("products",tableSec);
				clearFormProducts();
				refreshComboPrId();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}	
		}	
	}
	
	class DeleteActionProducts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "delete from products where products_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable1("products",tableSec);
				id = -1;
				clearFormProducts();
				refreshComboPrId();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	class EditActionProducts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTFSec.getText();
			Float weight = Float.parseFloat(weightTFsec.getText());
			conn = DBConnector.getConnection();
			String sql = "update products set products_name = ?,products_weight = ? where products_id = ?";
			try {
				state= conn.prepareStatement(sql);
				state.setString(1, name);
				state.setFloat(2, weight);
				state.setInt(3, id);
				state.execute();
				clearFormProducts();
				refreshTable1("products", tableSec);
				tableThr.setModel(getFromTableOrders());
				refreshComboPrId();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	class SearchActionProducts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = nameTFSec.getText();
			conn = DBConnector.getConnection();
			String sql = "select * from products where products_name = ?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, name);
				result = state.executeQuery();
				model = new MyModel(result);
				tableSec.setModel(model);
				clearFormProducts();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class RefreshActionProducts implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			refreshTable1("products", tableSec);
			clearFormProducts();
		}
	}
	
	class MouseActionProducts implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableSec.getSelectedRow();
			id = Integer.parseInt(tableSec.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				nameTFSec.setText(tableSec.getValueAt(row, 1).toString());
				weightTFsec.setText(tableSec.getValueAt(row, 2).toString());
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {	
		}
	}
	
	public void refreshComboClId() {
		nameCombo.removeAllItems();
		conn = DBConnector.getConnection();
		String sql ="select clients_id,clients_name from clients";
		String item = "";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			while(result.next()){
				item = result.getObject(1).toString()+"."+result.getObject(2).toString();
				nameCombo.addItem(item);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshComboPrId() {
		productCombo.removeAllItems();
		conn = DBConnector.getConnection();
		String sql ="select products_id,products_name from products";
		String item = "";
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			while(result.next()){
				item = result.getObject(1).toString()+"."+result.getObject(2).toString();
				productCombo.addItem(item);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	class AddActionOrders implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Float price = Float.parseFloat(priceTField.getText());
			String clid = nameCombo.getSelectedItem().toString().substring(0,nameCombo.getSelectedItem().toString().indexOf('.'));
			String prid = productCombo.getSelectedItem().toString().substring(0,productCombo.getSelectedItem().toString().indexOf('.'));
			String date = dataTField.getText();
			conn = DBConnector.getConnection();
			String query = "insert into orders values(null,?,?,?,?);";
			try {
				state = conn.prepareStatement(query);
				state.setFloat( 1, price);
				state.setInt(3,Integer.parseInt(clid));
				state.setInt(4,Integer.parseInt(prid));
				state.setString(2, date);
				state.execute();
				clearFormOrders();
				tableThr.setModel(getFromTableOrders());
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class EditActionOrders implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Float price = Float.parseFloat(priceTField.getText());
			String data = dataTField.getText();
			String client = nameCombo.getSelectedItem().toString().substring(0,nameCombo.getSelectedItem().toString().indexOf('.'));
			String product = productCombo.getSelectedItem().toString().substring(0,productCombo.getSelectedItem().toString().indexOf('.'));
			conn = DBConnector.getConnection();
			String sql = "update orders set order_price = ?,order_date = ?,client_id = ?,product_id = ? where order_id = ?";
			try {
				state= conn.prepareStatement(sql);
				state.setFloat(1, price);
				state.setString(2, data);
				state.setString(3, client);
				state.setString(4, product);
				state.setInt(5, id);
				state.execute();
				clearFormOrders();
				tableThr.setModel(getFromTableOrders());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	class DeleteActionOrders implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnector.getConnection();
			String sql = "delete from orders where order_id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				tableThr.setModel(getFromTableOrders());
				id = -1;
				clearFormOrders();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}	
	}
	
	class SearchActionOrders implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Float price = Float.parseFloat(priceTField.getText());
			conn = DBConnector.getConnection();
			String sql = "select order_id ,order_price,order_date,clients_name,products_name from orders join clients on clients_id = client_id join Products on products_id = product_id where order_price = ?";
			try {
				state = conn.prepareStatement(sql);
				state.setFloat(1, price);
				result = state.executeQuery();
				model = new MyModel(result);
				tableThr.setModel(model);
				clearFormOrders();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class RefreshActionOrders implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			tableThr.setModel(getFromTableOrders());
			clearFormOrders();
		}
	}
	
	class MouseActionOrders implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = tableThr.getSelectedRow();
			id = Integer.parseInt(tableThr.getValueAt(row, 0).toString());
			if(e.getClickCount() > 1) {
				priceTField.setText(tableThr.getValueAt(row, 1).toString());
				dataTField.setText(tableThr.getValueAt(row, 2).toString());
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {	
		}
	}
	
	class doubleSearch implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Float first = Float.parseFloat(priceQue2TField.getText());
			String second = nameQue2TField.getText();
			conn = DBConnector.getConnection();
			String sql = "select order_id ,order_price,order_date,clients_name,products_name from orders join clients on clients_id = client_id join Products on products_id = product_id where order_price = ? and products_name = ?;";
			try {
				state = conn.prepareStatement(sql);
				state.setFloat(1, first);
				state.setString(2, second);
				result = state.executeQuery();
				model = new MyModel(result);
				tableQue2.setModel(model);
				clearFormQue2();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	class doubleSearchCl implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			float price = Float.parseFloat(priceQueTField.getText());
			String second = nameQueTField.getText();
			conn = DBConnector.getConnection();
			String sql = "select order_id ,order_price,order_date,clients_name,products_name from orders join clients on clients_id = client_id join Products on products_id = product_id where order_price = ? and clients_name = ?;";
			try {
				state = conn.prepareStatement(sql);
				state.setFloat(1, price);
				state.setString(2, second);
				result = state.executeQuery();
				model = new MyModel(result);
				tableQue.setModel(model);
				clearFormQue();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void clearForm() {
		nameTField.setText("");
		ageTField.setText("");
		lnameTField.setText("");
	}
	public void clearFormProducts() {
		nameTFSec.setText("");
		weightTFsec.setText("");
	}
	public void clearFormOrders() {
		priceTField.setText("");
		dataTField.setText("");
	}
	public void clearFormQue() {
		nameQueTField.setText("");
		priceQueTField.setText("");
	}
	public void clearFormQue2() {
		nameQue2TField.setText("");
		priceQue2TField.setText("");
	}
}
