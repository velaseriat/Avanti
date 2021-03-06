package Avanti;





import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;



public class GameControl extends JPanel{
	private Avanti avanti;
	private JButton moveEnemyButton, addEnemyButton, placeTowerButton;
	boolean moveButtonClicked = false;

	public GameControl(Avanti avanti) {
		this.avanti = avanti;
		setLayout(new GridLayout(0,3));
		setPreferredSize(new Dimension(15, 30));
		moveEnemyButton = new JButton("Move Enemy");
		moveEnemyButton.addActionListener(new MoveEnemyListener());
		add(moveEnemyButton);
		addEnemyButton = new JButton("Add Enemy");
		addEnemyButton.addActionListener(new AddEnemyListener());
		add(addEnemyButton);
		new JPanel();
		placeTowerButton = new JButton("Tower");
		placeTowerButton.addActionListener(new AddTowerListener());
		add(placeTowerButton);
	}

	class AddTowerListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (!avanti.towerTypeDialogOpen){
				new TowerTypeDialog(avanti);
				avanti.towerTypeDialogOpen = true;
				
			}
		}
	}
	
	class MoveEnemyListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if (!moveButtonClicked){
				moveButtonClicked = true;
				avanti.startEnemies();
			}
		}
	}
	
	class AddEnemyListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			avanti.addEnemy();
		}
	}
	

}

