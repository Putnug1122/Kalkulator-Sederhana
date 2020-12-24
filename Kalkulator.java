//import library yang dibutuhkan
package com.mycompany.kalkulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Membuat Interface Class
public class Kalkulator implements ActionListener {

    //Setting GUI
    JFrame frame;
	JTextField ruangText;
	JButton[] tombolAngka = new JButton[10];
	JButton[] tombolOperasi = new JButton[9];
	JButton tombolJumlah,tombolKurang,tombolKali,tombolBagi;
	JButton tombolDesimal, tombolSamaDengan, tombolDelete, tombolClear, tombolNegatif;
	JPanel panel;
        
    Font myFont = new Font("Calculator",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
        
        Kalkulator() {
                
        frame = new JFrame("Kalkulator Sederhana");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
        frame.getContentPane().setBackground(Color.darkGray);
		
		ruangText = new JTextField();
		ruangText.setBounds(50, 25, 300, 50);
		ruangText.setFont(myFont);
        ruangText.setBackground(Color.gray);
        ruangText.setForeground(Color.white);
		ruangText.setEditable(false);
		
		tombolJumlah = new JButton("+");
		tombolKurang = new JButton("-");
		tombolKali = new JButton("*");
		tombolBagi = new JButton("/");
		tombolDesimal = new JButton(".");
		tombolSamaDengan = new JButton("=");
		tombolDelete = new JButton("Del");
		tombolClear = new JButton("Clr");
		tombolNegatif = new JButton("(-)");
		
		tombolOperasi[0] = tombolJumlah;
		tombolOperasi[1] = tombolKurang;
		tombolOperasi[2] = tombolKali;
		tombolOperasi[3] = tombolBagi;
		tombolOperasi[4] = tombolDesimal;
		tombolOperasi[5] = tombolSamaDengan;
		tombolOperasi[6] = tombolDelete;
		tombolOperasi[7] = tombolClear;
		tombolOperasi[8] = tombolNegatif;
		
		for(int i =0;i<9;i++) {
			tombolOperasi[i].addActionListener(this);
			tombolOperasi[i].setFont(myFont);
			tombolOperasi[i].setFocusable(false);
            for (int j=0;j<4;j++){
                tombolOperasi[j].setBackground(Color.ORANGE);
            }
            for (int k = 4; k<9; k++){
                tombolOperasi[k].setBackground(Color.CYAN);
            }
		}
		
		for(int i =0;i<10;i++) {
			tombolAngka[i] = new JButton(String.valueOf(i));
			tombolAngka[i].addActionListener(this);
			tombolAngka[i].setFont(myFont);
			tombolAngka[i].setFocusable(false);
            tombolAngka[i].setBackground(Color.CYAN);
		}
		
		tombolNegatif.setBounds(50,430,100,50);
		tombolDelete.setBounds(150,430,100,50);
		tombolClear.setBounds(250,430,100,50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.darkGray);

		panel.add(tombolAngka[1]);
		panel.add(tombolAngka[2]);
		panel.add(tombolAngka[3]);
		panel.add(tombolJumlah);
		panel.add(tombolAngka[4]);
		panel.add(tombolAngka[5]);
		panel.add(tombolAngka[6]);
		panel.add(tombolKurang);
		panel.add(tombolAngka[7]);
		panel.add(tombolAngka[8]);
		panel.add(tombolAngka[9]);
		panel.add(tombolKali);
		panel.add(tombolDesimal);
		panel.add(tombolAngka[0]);
		panel.add(tombolSamaDengan);
		panel.add(tombolBagi);
		
		frame.add(panel);
		frame.add(tombolNegatif);
		frame.add(tombolDelete);
		frame.add(tombolClear);
		frame.add(ruangText);
		frame.setVisible(true);
        }
        
        public static void main(String[] args) {
		
		Kalkulator calc = new Kalkulator();
	}
	
	//Pengaturan Operasi/Function
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == tombolAngka[i]) {
				ruangText.setText(ruangText.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==tombolDesimal) {
			ruangText.setText(ruangText.getText().concat("."));
		}
		if(e.getSource()==tombolJumlah) {
			num1 = Double.parseDouble(ruangText.getText());
			operator ='+';
			ruangText.setText("");
		}
		if(e.getSource()==tombolKurang) {
			num1 = Double.parseDouble(ruangText.getText());
			operator ='-';
			ruangText.setText("");
		}
		if(e.getSource()==tombolKali) {
			num1 = Double.parseDouble(ruangText.getText());
			operator ='*';
			ruangText.setText("");
		}
		if(e.getSource()==tombolBagi) {
			num1 = Double.parseDouble(ruangText.getText());
			operator ='/';
			ruangText.setText("");
		}
		if(e.getSource()==tombolSamaDengan) {
			num2=Double.parseDouble(ruangText.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			ruangText.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==tombolClear) {
			ruangText.setText("");
		}
		if(e.getSource()==tombolDelete) {
			String hapus = ruangText.getText();
			ruangText.setText("");
			for(int i=0;i<hapus.length()-1;i++) {
				ruangText.setText(ruangText.getText()+hapus.charAt(i));
			}
		}
		if(e.getSource()==tombolNegatif) {
			double min = Double.parseDouble(ruangText.getText());
			min*=-1;
			ruangText.setText(String.valueOf(min));
		}
	}
        
}
