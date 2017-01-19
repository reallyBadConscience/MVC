import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame {
	JButton btnAdd, btnSubtract, btnClear;
	JButton[] numkeys = new JButton[10];
	JPanel contentPane;
	Controller controller;

	public View(Controller c) {
		this.controller = c;
		contentPane = new JPanel(new FlowLayout());
		this.setBounds(100, 100, 200, 200);
		this.setContentPane(contentPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClick_Add();
			}
		});
		btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClick_Subtract();
			}
		});
		btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onClick_Clear();
			}
		});
		contentPane.add(btnAdd);
		contentPane.add(btnSubtract);
		contentPane.add(btnClear);
		for (int i = 0; i < numkeys.length; i++) {
			int num = i;
			numkeys[i] = new JButton(Integer.toString(i));
			numkeys[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.onClick_Num(num);
				}
			});
			contentPane.add(numkeys[i]);
		}
		this.setVisible(true);
	}

	public void onUpdate(int val) {
		System.out.printf("Val: %d\n", val);
	}
}
