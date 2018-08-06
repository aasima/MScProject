
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;


/**
 * 
 * @author Aasima
 *
 */

public class AddUserGUI extends JFrame implements Observer, ActionListener {

    private JLabel ID_Label;
    private JTextField ID_TextField;
    private JPanel UserPanel;
    private JFormattedTextField attendanceField; // format to 2 decimal places 
    private JLabel attendanceLabel;
    private JPanel buttonPanel;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JFormattedTextField expiryField;
    private JLabel expiryLabel;
    private JLabel firstLabel;
    private JTextField firstTextField;
    private JComboBox homeComboBox;
    private JLabel homeLabel;
    private JLabel instructionLabel;
    private JPanel instructionPanel;
    private JPasswordField jPasswordField1;
    private JLabel lastLabel;
    private JTextField lastTextField;
    private JLabel passwordLabel;
    private JLabel sponsorLabel;
    private JTextField sponsorTextField;
    private JFormattedTextField startField;
    private JLabel startLabel;
    private JComboBox statusComboBox;
    private JLabel statusLabel;
    private JPanel studentPanel;
    private JButton submitButton1;
    private JLabel supervisorLabel;
    private JTextField supervisorTextField;
    private JComboBox usertypeComboBox;
    private JLabel usertypeLabel;
    private JLabel visaLabel;
    private JPanel visaPanel;
    private JTextField visaTextField;
    
    
    public AddUserGUI() {
        initComponents();
    }


	private void initComponents() {
			UserPanel = new JPanel();
	       	ID_Label = new JLabel();
	        emailLabel = new JLabel();
	        emailTextField = new JTextField();
	        ID_TextField = new JTextField();
	        passwordLabel = new JLabel();
	        firstLabel = new JLabel();
	        firstTextField = new JTextField();
	        lastLabel = new JLabel();
	        lastTextField = new JTextField();
	        usertypeComboBox = new JComboBox();
	        usertypeLabel = new JLabel();
	        jPasswordField1 = new JPasswordField();
	        instructionPanel = new JPanel();
	        instructionLabel = new JLabel();
	        buttonPanel = new JPanel();
	        submitButton1 = new JButton();
	        studentPanel = new JPanel();
	        statusLabel = new JLabel();
	        statusComboBox = new JComboBox();
	        homeLabel = new JLabel();
	        homeComboBox = new JComboBox();
	        supervisorLabel = new JLabel();
	        attendanceLabel = new JLabel();
	        attendanceField = new JFormattedTextField();
	        supervisorTextField = new JTextField();
	        visaPanel = new JPanel();
	        visaLabel = new JLabel();
	        visaTextField = new JTextField();
	        startLabel = new JLabel();
	        expiryLabel = new JLabel();
	        sponsorLabel = new JLabel();
	        sponsorTextField = new JTextField();
	        startField = new JFormattedTextField();
	        expiryField = new JFormattedTextField();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        UserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

	        ID_Label.setText("ID:");

	        emailLabel.setText("Email Address:");

	        passwordLabel.setText("Password:");

	        firstLabel.setText("First Name:");

	        lastLabel.setText("Last Name:");

	        usertypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Supervisor", "Admin" }));
	        usertypeComboBox.setName("userTypeSelection"); // NOI18N
	        usertypeComboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                comboBoxActionPerformed(evt);
	            }
	        });

	        usertypeLabel.setLabelFor(usertypeComboBox);
	        usertypeLabel.setText("User Type:");

	        javax.swing.GroupLayout UserPanelLayout = new javax.swing.GroupLayout(UserPanel);
	        UserPanel.setLayout(UserPanelLayout);
	        UserPanelLayout.setHorizontalGroup(
	            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(UserPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(emailLabel)
	                    .addComponent(emailTextField)
	                    .addGroup(UserPanelLayout.createSequentialGroup()
	                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                                .addComponent(firstLabel)
	                                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(ID_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(passwordLabel)))
	                            .addComponent(lastLabel)
	                            .addComponent(usertypeLabel))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(usertypeComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
	                            .addComponent(ID_TextField)
	                            .addComponent(firstTextField)
	                            .addComponent(lastTextField))))
	                .addContainerGap(18, Short.MAX_VALUE))
	        );
	        UserPanelLayout.setVerticalGroup(
	            UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(UserPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(usertypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(usertypeLabel))
	                .addGap(18, 18, 18)
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(ID_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(ID_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(18, 18, 18)
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(passwordLabel)
	                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(firstTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(firstLabel))
	                .addGap(18, 18, 18)
	                .addGroup(UserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(lastTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(lastLabel))
	                .addGap(18, 18, 18)
	                .addComponent(emailLabel)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(151, 151, 151))
	        );

	        instructionLabel.setText("Instructions go here!");

	        javax.swing.GroupLayout instructionPanelLayout = new javax.swing.GroupLayout(instructionPanel);
	        instructionPanel.setLayout(instructionPanelLayout);
	        instructionPanelLayout.setHorizontalGroup(
	            instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(instructionPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(instructionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        instructionPanelLayout.setVerticalGroup(
	            instructionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(instructionPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(instructionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
	                .addContainerGap())
	        );

	        submitButton1.setText("Submit");
	        submitButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                submitActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
	        buttonPanel.setLayout(buttonPanelLayout);
	        buttonPanelLayout.setHorizontalGroup(
	            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(submitButton1)
	                .addContainerGap())
	        );
	        buttonPanelLayout.setVerticalGroup(
	            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(buttonPanelLayout.createSequentialGroup()
	                .addComponent(submitButton1)
	                .addGap(0, 12, Short.MAX_VALUE))
	        );

	        studentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

	        statusLabel.setLabelFor(statusComboBox);
	        statusLabel.setText("Status:");

	        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Registered", "Writing thesis", "Awaiting viva", "Awaiting viva feedback", "Revising thesis", "Awaiting approval", "Awaiting binding", "Thesis submitted" }));

	        homeLabel.setText("Home/Overseas:");

	        homeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Overseas", "Home/EU" }));
	        homeComboBox.setName("homeSelection"); // NOI18N
	        homeComboBox.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                comboBoxActionPerformed(evt);
	            }
	        });

	        supervisorLabel.setText("Supervisor ID:");

	        attendanceLabel.setText("Attendance:");

	        attendanceField.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
	        attendanceField.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                attendanceFieldActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
	        studentPanel.setLayout(studentPanelLayout);
	        studentPanelLayout.setHorizontalGroup(
	            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(studentPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(homeLabel)
	                    .addComponent(statusLabel)
	                    .addComponent(supervisorLabel)
	                    .addComponent(attendanceLabel))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(statusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(homeComboBox, 0, 172, Short.MAX_VALUE)
	                    .addGroup(studentPanelLayout.createSequentialGroup()
	                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(attendanceField)
	                            .addComponent(supervisorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        studentPanelLayout.setVerticalGroup(
	            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(studentPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(statusLabel)
	                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(homeLabel)
	                    .addComponent(homeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(supervisorLabel)
	                    .addComponent(supervisorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(attendanceLabel)
	                    .addComponent(attendanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(39, Short.MAX_VALUE))
	        );

	        visaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visa Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

	        visaLabel.setText("Visa Number:");

	        startLabel.setText("Start Date:");

	        expiryLabel.setText("Expiry Date:");

	        sponsorLabel.setText("Sponsor Number:");

	        startField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
	        startField.setText("yyyy-MM-dd");

	        expiryField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
	        expiryField.setText("yyyy-MM-dd");
	        
	        javax.swing.GroupLayout visaPanelLayout = new javax.swing.GroupLayout(visaPanel);
	        visaPanel.setLayout(visaPanelLayout);
	        visaPanelLayout.setHorizontalGroup(
	            visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(visaPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(visaPanelLayout.createSequentialGroup()
	                        .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(visaLabel)
	                            .addComponent(startLabel)
	                            .addComponent(expiryLabel))
	                        .addGap(24, 24, 24)
	                        .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(visaTextField)
	                            .addGroup(visaPanelLayout.createSequentialGroup()
	                                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                    .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addComponent(expiryField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGap(0, 0, Short.MAX_VALUE))))
	                    .addGroup(visaPanelLayout.createSequentialGroup()
	                        .addComponent(sponsorLabel)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(sponsorTextField)))
	                .addContainerGap())
	        );
	        visaPanelLayout.setVerticalGroup(
	            visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(visaPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(visaLabel)
	                    .addComponent(visaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(startLabel)
	                    .addComponent(startField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(expiryLabel)
	                    .addComponent(expiryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(visaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(sponsorLabel)
	                    .addComponent(sponsorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(UserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(studentPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(visaPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(instructionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(instructionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(studentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(visaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                    .addComponent(UserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	        );

	        pack();
	    }
		
	


	@SuppressWarnings("deprecation")
	protected void submitActionPerformed(ActionEvent evt) {
		User user;
		Object selected = usertypeComboBox.getSelectedItem();
		Object homeSelect = homeComboBox.getSelectedItem();
		if (selected.toString().equals("Supervisor")){
			user = new User(ID_TextField.getText(), jPasswordField1.getText(), firstTextField.getText(), lastTextField.getText(), emailTextField.getText() , 2);	
		}
		else if (selected.toString().equals("Admin")){
			user = new User(ID_TextField.getText(), jPasswordField1.getText(), firstTextField.getText(), lastTextField.getText(), emailTextField.getText() , 3);	
		}
		else if (selected.toString().equals("Student") && homeSelect.toString().equals("Overseas")){
			//user = new User(ID_TextField.getText(), jPasswordField1.getText(), firstTextField.getText(), lastTextField.getText(), emailTextField.getText() , 1, statusComboBox.getSelectedItem().toString(), homeComboBox.getSelectedItem().toString(), supervisorTextField.getText(), attendanceField.getText() ,visaTextField.getText(), startField.getText(), expiryField.getText(), sponsorTextField.getText());	
		}
		else {
			//user = new Student(ID_TextField.getText(), jPasswordField1.getText(), firstTextField.getText(), lastTextField.getText(), emailTextField.getText() , 1, statusComboBox.getSelectedItem().toString(), homeComboBox.getSelectedItem().toString(), supervisorTextField.getText(), attendanceField.getText());
		}
		

		
	}


	private void comboBoxActionPerformed(ActionEvent evt) {                                                 
		Object selected = usertypeComboBox.getSelectedItem();
		Object homeSelect = homeComboBox.getSelectedItem();
    	if(selected.toString().equals("Supervisor") || selected.toString().equals("Admin")){
            studentPanel.setVisible(false); 
            visaPanel.setVisible(false);
    	
    	}
    	else if(selected.toString().equals("Student") && !homeSelect.toString().equals("Overseas")){ 
            studentPanel.setVisible(true); 
            visaPanel.setVisible(false);
    	}
    	else {
    		studentPanel.setVisible(true); visaPanel.setVisible(true);
    	}
    }                                                

    private void attendanceFieldActionPerformed(ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUserGUI().setVisible(true);
            }
        });
    }



	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
    
}
