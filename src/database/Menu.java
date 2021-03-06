package database;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ihm.Menu2;
import ihm.Navigation;

@SuppressWarnings("serial")
public class Menu extends JFrame {
	public static final int AJOUTER = 0 ;
	public static final int MODIFIER = 1 ;
	private Menu2 menu;
	
	
	
	/**
	 * Affiche un nouveau Menu pour ajouter ou modifier un model de la base
	 * @param nomPo nom
	 * @param pathPo chemin d'access
	 * @param tagsPo mots cles
	 * @param action 0 pour AJOUTER et 1 pour MODIFIER
	 */
	public Menu(String nomPo , String pathPo , String tagsPo , int action , Menu2 menu){
		this.menu = menu ;
		System.out.println(menu);
		setTitle("Nouveau Fichier");
		setLayout(new GridLayout(5, 2));
		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		// NOM
		JLabel nomlabel = new JLabel("Nom :");
		JTextField nom = new JTextField(nomPo);
		getContentPane().add(nomlabel);
		getContentPane().add(nom);
		
		//PATH
		add(new JLabel("Chemin d'acces :"));
		JTextField path = new JTextField(pathPo);
		add(path);
		
		//MOTS CLES
		add(new JLabel("Mots cles associ�e (separe par des espaces) :"));
		JTextField tags = new JTextField(tagsPo);
		add(tags);
		
		if(action == AJOUTER){
			JButton ajouter = new JButton("Ajouter");
			ajouter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Data.getInstance().add(nom.getText(), tags.getText(), path.getText());
					Menu.this.dispose();
					System.out.println(menu);
					menu.liste.refresh();
				}
			});
			add(ajouter);
		}else{
			JButton modifier = new JButton("Modifier");
			modifier.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Data.getInstance().update(nomPo, nom.getText(), tags.getText(), path.getText());
					Menu.this.dispose();
					menu.liste.refresh();
				}
			});
			add(modifier);
			
		}
		
		
		setSize(500, 250);
		setVisible(true);
	}
	/**
	 * Creer un menu preconstruit pour ajouter
	 */
	public Menu(Menu2 menu){
		new Menu("","","",0, menu);
	}
	
}