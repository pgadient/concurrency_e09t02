package geom.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import geom.shape.Shape;
import geom.shape.locksplitting.LockSplittingShape;
import geom.shape.passthrough.PassThroughShape;

/**
 * Geometry Simulation Environment (GSE)
 * November 2017
 * 
 * 
 * @author Pascal Gadient (gadient@inf.unibe.ch) 
 * 
 * SCG University of Bern, Concurrency Course
 * 
 */
public class GeomUI {
	JFrame frame;
	private int frameHeight = 470;					// window height
	private int frameWidth = 710;					// window width
	private JPanel canvas_left;
	private JPanel canvas_right;
	private Graphics2D g2d_left;
	private Graphics2D g2d_right;
	private Shape currentShape;
	private JComboBox<String> combobox;

	public static void main(String[] args) {
		GeomUI instance = new GeomUI();
		instance.resetGUI();
	}
	
	public GeomUI() {
		this.frame = new JFrame();
		this.frame.setTitle("SCG - Geometry Simulation Environment (GSE) - Solution");
		this.frame.setBackground(new Color(255, 255, 255));
		this.frame.setSize(this.frameWidth, this.frameHeight);
		this.frame.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent we) {
                 System.exit(0);
             }
         } );
		
		URL iconURL = getClass().getResource("/geom/main/scg-logo.png");
		ImageIcon icon = new ImageIcon(iconURL);
		this.frame.setIconImage(icon.getImage());
		GridBagLayout gbl = new GridBagLayout();
		this.frame.setLayout(gbl);
		
		GridBagConstraints gbc_label_left = new GridBagConstraints();
		gbc_label_left.gridx = 0;
		gbc_label_left.gridwidth = 2;
		gbc_label_left.gridy = 0;
		gbc_label_left.fill = GridBagConstraints.BOTH;
		gbc_label_left.anchor = GridBagConstraints.CENTER;
		JLabel label_left = new JLabel("PROTOTYPE");
		label_left.setHorizontalAlignment(SwingConstants.CENTER);
		label_left.setFont(new Font("Arial", Font.BOLD, 32));
		this.frame.add(label_left, gbc_label_left);
		
		GridBagConstraints gbc_label_right = new GridBagConstraints();
		gbc_label_right.gridx = 2;
		gbc_label_right.gridwidth = 2;
		gbc_label_right.gridy = 0;
		gbc_label_right.fill = GridBagConstraints.BOTH;
		gbc_label_right.anchor = GridBagConstraints.CENTER;
		JLabel label_right = new JLabel("RESULT");
		label_right.setHorizontalAlignment(SwingConstants.CENTER);
		label_right.setFont(new Font("Arial", Font.BOLD, 32));
		this.frame.add(label_right, gbc_label_right);
		
		GridBagConstraints gbc_button_canvas_left = new GridBagConstraints();
		gbc_button_canvas_left.gridx = 0;
		gbc_button_canvas_left.gridwidth = 2;
		gbc_button_canvas_left.gridy = 1;
		gbc_button_canvas_left.fill = GridBagConstraints.BOTH;
		this.canvas_left = new JPanel();
		this.canvas_left.setPreferredSize(new Dimension(300, 300));
		this.frame.add(this.canvas_left, gbc_button_canvas_left);
		
		GridBagConstraints gbc_button_canvas_right = new GridBagConstraints();
		gbc_button_canvas_right.gridx = 2;
		gbc_button_canvas_right.gridwidth = 2;
		gbc_button_canvas_right.gridy = 1;
		gbc_button_canvas_right.fill = GridBagConstraints.BOTH;
		this.canvas_right = new JPanel();
		this.canvas_right.setPreferredSize(new Dimension(300, 300));
		this.frame.add(this.canvas_right, gbc_button_canvas_right);
		
		GridBagConstraints gbc_combobox = new GridBagConstraints();
		gbc_combobox.gridx = 0;
		gbc_combobox.gridwidth = 4;
		gbc_combobox.gridy = 2;
		gbc_combobox.fill = GridBagConstraints.BOTH;
		String[] entries = {"<html><font color=green>LockSplittingShape implementation</font></html>", "<html><font color=blue>PassThroughShape implementation</font></html>"};
		this.combobox = new JComboBox<String>(entries);
		this.combobox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
					resetGUI();
			}
		});
		this.frame.add(this.combobox, gbc_combobox);
		
		
		GridBagConstraints gbc_button_reset = new GridBagConstraints();
		gbc_button_reset.gridx = 0;
		gbc_button_reset.gridy = 3;
		gbc_button_reset.fill = GridBagConstraints.BOTH;
		JButton jbutton_clear = new JButton("Reset");
		jbutton_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetGUI();
			}
		});
		this.frame.add(jbutton_clear, gbc_button_reset);
		
		GridBagConstraints gbc_button_chgPos = new GridBagConstraints();
		gbc_button_chgPos.gridx = 1;
		gbc_button_chgPos.gridy = 3;
		gbc_button_chgPos.fill = GridBagConstraints.BOTH;
		JButton jbutton_chgPos = new JButton("Change Position");
		jbutton_chgPos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentShape.changePosition();
				drawShape(g2d_right, currentShape);
			}
		});
		this.frame.add(jbutton_chgPos, gbc_button_chgPos);
		
		GridBagConstraints gbc_button_chgDim = new GridBagConstraints();
		gbc_button_chgDim.gridx = 2;
		gbc_button_chgDim.gridy = 3;
		gbc_button_chgDim.fill = GridBagConstraints.BOTH;
		JButton jbutton_chgDim = new JButton("Change Dimension");
		jbutton_chgDim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentShape.changeDimension();
				drawShape(g2d_right, currentShape);
			}
		});
		this.frame.add(jbutton_chgDim, gbc_button_chgDim);
		
		GridBagConstraints gbc_button_chgPosDim = new GridBagConstraints();
		gbc_button_chgPosDim.gridx = 3;
		gbc_button_chgPosDim.gridy = 3;
		gbc_button_chgPosDim.fill = GridBagConstraints.BOTH;
		JButton jbutton_chgPosDim = new JButton("Change Position and Dimension");
		jbutton_chgPosDim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentShape.changePositionAndDimension();
				drawShape(g2d_right, currentShape);
			}
		});
		this.frame.add(jbutton_chgPosDim, gbc_button_chgPosDim);
		
		frame.setVisible(true);
		
		try {
			Thread.sleep(1000);					// waiting for the GUI to be displayed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		canvas_left.setBackground(new Color(255, 255, 255));
		canvas_right.setBackground(new Color(255, 255, 255));
		
		this.g2d_left = (Graphics2D) this.canvas_left.getGraphics();
		this.g2d_right = (Graphics2D) this.canvas_right.getGraphics();
	}
	
	private void resetGUI() {
		this.canvas_left.paint(this.g2d_left);
		this.canvas_right.paint(this.g2d_right);
		
		if (this.combobox.getSelectedIndex() == 0) {
			this.g2d_left.setColor(new Color(0, 128, 0));
			this.g2d_right.setColor(new Color(0, 128, 0));
			currentShape = this.createRandomLockSplittingShape();
		} else {
			this.g2d_left.setColor(new Color(0, 0, 255));
			this.g2d_right.setColor(new Color(0, 0, 255));
			currentShape = this.createRandomPassThroughShape();
		}
		
		this.drawShape(this.g2d_left, currentShape);
	}
	
	private void drawShape(Graphics2D g, Shape s) {
		g.drawRect(s.getX(), s.getY(), s.getWidth(), s.getHeight());
	}

	private LockSplittingShape createRandomLockSplittingShape() {
		Random r = new Random();
		r.nextInt();
		LockSplittingShape shape = new LockSplittingShape();
		shape.setRectangle(10 + r.nextInt(50), 10 + r.nextInt(50), 10 + r.nextInt(200), 10 + r.nextInt(200));
		return shape;
	}
	
	private PassThroughShape createRandomPassThroughShape() {
		Random r = new Random();
		r.nextInt();
		PassThroughShape shape = new PassThroughShape();
		shape.setRectangle(10 + r.nextInt(50), 10 + r.nextInt(50), 10 + r.nextInt(200), 10 + r.nextInt(200));
		return shape;
	}

}
