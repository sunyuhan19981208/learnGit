package softwareSY;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class endFrame extends JFrame {
	public endFrame() {
		setTitle("À¿£°");
		setBounds(400, 400, 22*13, 22*18);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("À¿");
		lblNewLabel.setFont(new Font("ÀŒÃÂ", Font.BOLD, 20));
		lblNewLabel.setBounds(22*6, 22*9, 253, 56);
		getContentPane().add(lblNewLabel);
		
		JButton button = new JButton("≤ªÕÊ¡À");
		button.setBounds(22*4, 22*11, 93, 23);
		getContentPane().add(button);
		button.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						dispose();
					}
				});
		
		setVisible(true);
	}
	public static void main(String args[])
	{
		new endFrame();
	}
}
