package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Axis;

public final class RotateXRight extends ModelController implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		model.rotateModel(Axis.X, 2);
		space.repaint();
	}
}
