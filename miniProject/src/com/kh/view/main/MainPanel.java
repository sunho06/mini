package com.kh.view.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.view.admin.AdminViewManager;

public class MainPanel extends JPanel {

	private Main main;
	private Thread t1;
	JLabel lblTime;
	JLabel lblEvent;
	private double sTime;
	private AdminViewManager avm;

	public void ThreadTime() {
		t1 = new Thread() {
			public void run() {
				try {
					while (true) {
						long dTimeI = 0L;
						long systemTime = System.currentTimeMillis();
						SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
						String dTime = formatter.format(systemTime);
						SimpleDateFormat formatter1 = new SimpleDateFormat("현재시각 : yyyy년 MM월 dd일 HH시 mm분 ss초",
								Locale.KOREA);
						String dTime1 = formatter1.format(systemTime);
						dTimeI = Long.parseLong(dTime);
						System.out.println(dTimeI);

						lblTime.setText(dTime1);
						lblTime.setBounds(42, 500, 280, 20);
						add(lblTime);

						lblEvent.setText("Event가 진행중이지 않습니다.");
						lblEvent.setBounds(42, 71, 57, 15);
						add(lblEvent);

						sleep(1000);

					}
				} catch (Exception e) {

				}
			}
		};
		t1.start();
	}

	public MainPanel() {
		initPanel();
	}

	public MainPanel(Main main) {
		this.main = main;
		initPanel();
	}

	public MainPanel(Main main, AdminViewManager adminManager) {
		this.main = main;
		this.avm = adminManager;
		initPanel();
	}

	public void initPanel() {
		sTime = avm.getEventSetting().getsTimeI();

		setLayout(null);
		setBounds(0, 0, 360, 600);
		setBackground(Color.white);
		JButton btnNewButton = new JButton("개인정보 변경");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("update");
				System.out.println("Update Part 이동");
			}
		});
		btnNewButton.setBounds(12, 10, 124, 51);
		add(btnNewButton);
		ImageIcon Run = new ImageIcon("images/Run.PNG");
		Image runImg = Run.getImage();
		Image updateRunImg = runImg.getScaledInstance(124, 124, Image.SCALE_SMOOTH);
		ImageIcon updateRunIcon = new ImageIcon(updateRunImg);
		JButton btnNewButton_1 = new JButton(updateRunIcon);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("record");
				System.out.println("Record Part 이동");
			}
		});

		ImageIcon check = new ImageIcon("images/check.PNG");
		Image checkImg = check.getImage();
		Image updateCheckImg = checkImg.getScaledInstance(118, 118, Image.SCALE_SMOOTH);
		ImageIcon updateCheckIcon = new ImageIcon(updateCheckImg);
		JButton btnNewButton_1_1 = new JButton(updateCheckIcon);
		btnNewButton_1.setBounds(41, 159, 118, 118);
		add(btnNewButton_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("result");
				System.out.println("Result Part 이동");
			}
		});

		btnNewButton_1_1.setBounds(185, 159, 118, 118);
		add(btnNewButton_1_1);
		ImageIcon Crew = new ImageIcon("images/Crew.PNG");
		Image runCrew = Crew.getImage();
		Image updateCrewImg = runCrew.getScaledInstance(262, 118, Image.SCALE_SMOOTH);
		ImageIcon updateCrewIcon = new ImageIcon(updateCrewImg);
		JButton btnNewButton_1_2 = new JButton(updateCrewIcon);
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.convertPanel("crew");
				System.out.println("Crew Part 이동");
			}
		});
		btnNewButton_1_2.setBounds(41, 315, 262, 118);
		add(btnNewButton_1_2);

		ThreadTime();

		lblEvent = new JLabel("event");

		lblTime = new JLabel("time");

		JLabel label = new JLabel("러닝 프로그램");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label.setBounds(41, 122, 146, 27);
		add(label);

		JButton btnNewButton_2 = new JButton("admin test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("admin");
			}
		});
		btnNewButton_2.setBounds(185, 24, 97, 23);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("login test");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.convertPanel("login");
			}
		});
		btnNewButton_3.setBounds(185, 67, 97, 23);
		add(btnNewButton_3);
	}
}