
 package database;
 
 import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
 
 import javax.swing.BoxLayout;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
 
 public class Menu extends JFrame{
 	
 	public Menu(){
 		setTitle("Menu");
 		setSize(500, 500);
 		setDefaultCloseOperation(EXIT_ON_CLOSE);
 		
 		// PANEL
 		JPanel panel = new JPanel();
 		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 		getContentPane().add(panel, BorderLayout.CENTER);
 		
 		// CONTENU
 		
 		ArrayList<Fichier> fichiers = Data.getData();
 		String[] entete = new String[]{"Nom", "Points" , "Segments" , "Faces" };
 		Object[][] donnees = new String[fichiers.size()][4];
 		for(int i = 0 ; i < fichiers.size() ; i++){
 			donnees[i][0] = fichiers.get(i).nom ;
 			donnees[i][1] = fichiers.get(i).points + "" ;
 			donnees[i][2] = fichiers.get(i).segments  + "";
 			donnees[i][3] = fichiers.get(i).faces + "";
 		}
 		
 		// TABLEAU
 		
 		JTable tableau = new JTable(donnees, entete);
 		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 		panel.add(tableau);
 		
 		// BOUTTONS
 		
 	 	JPanel boutons = new JPanel() ;
 	 	boutons.setLayout(new BoxLayout(boutons, BoxLayout.X_AXIS));
 	 	getContentPane().add(boutons, BorderLayout.SOUTH);
 	 		
 	 	JButton ouvrir = new JButton("Ouvrir");
 	 	ouvrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Fichier f = fichiers.get(tableau.getSelectedRow()) ;
				System.out.println("Ouverture de '" + f.nom + "'");
				
			}
		});
 	 	boutons.add(ouvrir);
 		
 		
 		setVisible(true);
 	}
 }