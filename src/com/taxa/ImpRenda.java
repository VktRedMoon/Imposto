package com.taxa;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

//import java.awt.Color;

//import java.awt.Color;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;

public class ImpRenda {

	protected Shell painel;
	private Text txtMensal;
	private Text txtAnual;
	private Text txtAliquota;
	private Text txtImpostoAn;
	private Text txtImpostoMen;
	private Text txtDependentes;
	//lblAliquota // lblIAnual // lblIMensal
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ImpRenda window = new ImpRenda();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		painel.open();
		painel.layout();
		while (!painel.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		painel = new Shell();
		//painel.setImage(SWTResourceManager.getImage(ImpRenda.class, "/com/taxa/ImpostoDeRenda.jpg"));
		painel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		painel.setBackgroundImage(SWTResourceManager.getImage(ImpRenda.class, "/com/taxa/IMPOSTODERENDA.png"));
		//painel.setBackground(SWTResourceManager.getColor(28, 113, 216)); //a opção acima serve para setar uma imagem de fundo, e esta serve para setar uma imagem, só deve escolher uma delas
		painel.setSize(550, 340);
		painel.setText("Imposto de Renda 2023");
		painel.setLayout(null);
		
		Label lblRendaMensal = new Label(painel, SWT.NONE);
		lblRendaMensal.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRendaMensal.setBounds(320, 62, 120, 25);
		lblRendaMensal.setText("Renda Mensal:");
		
		Label R$ = new Label(painel, SWT.NONE);
		R$.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		R$.setBounds(430, 63, 120, 25);
		R$.setText("R$");
		
		txtMensal = new Text(painel, SWT.BORDER);
		txtMensal.setBounds(450, 60, 83, 27);
		
		Label lblRendaAnual = new Label(painel, SWT.NONE);
		lblRendaAnual.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRendaAnual.setBounds(30, 60, 120, 25);
		lblRendaAnual.setText("Renda Anual:");
		
		Label R$2 = new Label(painel, SWT.NONE);
		R$2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		R$2.setBounds(133, 60, 120, 25);
		R$2.setText("R$");
		
		txtAnual = new Text(painel, SWT.BORDER);
		txtAnual.setBounds(155, 55, 83, 27);
				
		Label lblAliquota = new Label(painel, SWT.NONE);
		lblAliquota.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblAliquota.setBounds(230, 180, 120, 25);
		lblAliquota.setText("Aliquota:");
		
		txtAliquota = new Text(painel, SWT.BORDER);
		txtAliquota.setBounds(230, 205, 83, 27);
		
		Label lblIAnual = new Label(painel, SWT.NONE);
		lblIAnual.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblIAnual.setBounds(30, 180, 120, 25);
		lblIAnual.setText("Imp/ renda anual:");
		
		
		Label R$3 = new Label(painel, SWT.NONE);
		R$3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		R$3.setBounds(10, 208, 120, 25);
		R$3.setText("R$");
		
		txtImpostoAn = new Text(painel, SWT.BORDER);
		txtImpostoAn.setBounds(30, 205, 120, 25);
		
		Label lblIMensal = new Label(painel, SWT.NONE);
		lblIMensal.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblIMensal.setBounds(400, 180, 130, 25);
		lblIMensal.setText("Imp/ renda mensal:");
		
		Label R$4 = new Label(painel, SWT.NONE);
		R$4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		R$4.setBounds(380, 208, 120, 25);
		R$4.setText("R$");
		
		txtImpostoMen = new Text(painel, SWT.BORDER);
		txtImpostoMen.setBounds(400, 205, 130, 25);
		
		Label TextoDependentes = new Label(painel, SWT.NONE);
		TextoDependentes.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		TextoDependentes.setBounds(210, 260, 170, 25);
		TextoDependentes.setText("N* dependentes:");
		
		txtDependentes = new Text(painel, SWT.BORDER);
		txtDependentes.setBounds(230, 280, 60, 25);
		txtDependentes.setText(String.valueOf("0"));
		
		Button btnRendAnual = new Button(painel, SWT.NONE);
		btnRendAnual.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float impostoAN = Float.parseFloat(txtAnual.getText());//captura o texto da caixa de texto txtAnual				
				float dependentes = Float.parseFloat(txtDependentes.getText()); //Integer caso queira para inteiro
				//dependentes renda anual = 2.275,08// renda mensal = 189,59
				dependentes  = (float) (dependentes * 2275.08);
				//impostoAN = impostoAN - dependentes;
				if(impostoAN <= 21453.24)
				{
					txtImpostoAn.setText(String.valueOf("Isento"));
					txtAliquota.setText(String.valueOf("0,0%"));
				}
				else if(impostoAN <= 32151.48)
				{
					impostoAN = (float) ((impostoAN * 0.07) - dependentes - 1608.99);
					txtAliquota.setText(String.valueOf("7,0%"));
				}
				else if(impostoAN <= 42869.16)
				{
					impostoAN = (float) ((impostoAN * 0.15) - dependentes - 4020.35);
					txtAliquota.setText(String.valueOf("15,0%"));
				}
				else if(impostoAN <= 53565.72)
				{
					impostoAN = (float) ((impostoAN * 0.225) - dependentes - 7235.54);
					txtAliquota.setText(String.valueOf("22,5%"));
				}
				else //if(impostoAN >= 53565.73)
				{
					impostoAN = (float) ((impostoAN * 0.275) - dependentes - 9313.83);
					txtAliquota.sif(impostoAN <= 21453.24)
					{
						txtImpostoAn.setText(String.valueOf("Isento"));
						txtAliquota.setText(String.valueOf("0,0%"));
					}
					else if(impostoAN <= 32151.48)
					{
						impostoAN = (float) ((impostoAN * 0.07) - dependentes - 1608.99);
						txtAliquota.setText(String.valueOf("7,0%"));
					}
					else if(impostoAN <= 42869.16)
					{
						impostoAN = (float) ((impostoAN * 0.15) - dependentes - 4020.35);
						txtAliquota.setText(String.valueOf("15,0%"));
					}
					else if(impostoAN <= 53565.72)
					{
						impostoAN = (float) ((impostoAN * 0.225) - dependentes - 7235.54);
						txtAliquota.setText(String.valueOf("22,5%"));
					}
					else //if(impostoAN >= 53565.73)
					{
						impostoAN = (float) ((impostoAN * 0.275) - dependentes - 9313.83);
						txtAliquota.setText(String.valueOf("27,5%"));
					}
			etText(String.valueOf("27,5%"));
				}
				txtImpostoAn.setText(String.valueOf(impostoAN));;
				txtImpostoMen.setText(String.valueOf(""));
			}
		});
		btnRendAnual.setBounds(30, 119, 89, 34);
		btnRendAnual.setText("Calcular");		
		
		
		Button btnRendMensal = new Button(painel, SWT.NONE);
		btnRendMensal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float impostoMen = Float.parseFloat(txtMensal.getText());//captura o texto da caixa de texto txtAnual				
				float dependentes = Float.parseFloat(txtDependentes.getText()); //Integer caso queira para inteiro
				dependentes  = (float) (dependentes * 189.59);
				impostoMen = impostoMen - dependentes;
				if(impostoMen <= 1903.98)
				{
					txtImpostoAn.setText(String.valueOf("Isento"));
					txtAliquota.setText(String.valueOf("0,0%"));
				}
				else if(impostoMen <= 2826.65)
				{
					impostoMen = (float) ((impostoMen * 0.075) - dependentes - 142.80);
					txtAliquota.setText(String.valueOf("7,5%"));
				}
				else if(impostoMen <= 3751.05)
				{
					impostoMen = (float) ((impostoMen * 0.15) - 354.80);
					txtAliquota.setText(String.valueOf("15,0%"));
				}
				else if(impostoMen <= 4664.68)
				{
					impostoMen = (float) ((impostoMen * 0.225) - 636.13);
					txtAliquota.setText(String.valueOf("22,5%"));
				}
				else //if(impostoAN >= 53565.73)
				{
					impostoMen = (float) ((impostoMen * 0.275) - 869.36);
					txtAliquota.setText(String.valueOf("27,5%"));
				}
				txtImpostoMen.setText(String.valueOf(impostoMen));//nessa linha, txtImpostoMen recebe o valor que está em impostoAN;
				txtImpostoAn.setText(String.valueOf(""));
			}
		});
		btnRendMensal.setBounds(416, 119, 89, 34);
		btnRendMensal.setText("Calcular");
		
		
		//lblRendaMensal.setBounds(130, 30, 120, 25);
		Button INSS = new Button(painel, SWT.NONE);
		INSS.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//posso só fazer o calculo pegando o valor de txt impostoMen, e devolver o valor para a caixa do mesmo texto
				float salario = Float.parseFloat(txtMensal.getText());
				//float inss;
				if(salario <= 1302.00)
				{					
					salario = (float) (salario - (salario * 0.075));
				}
				else if(salario <= 2571.29)
				{
					salario = (float) (salario - (salario * 0.09));
				}
				else if(salario <= 3856.94)
				{
					salario = (float) (salario - (salario * 0.12));
				}
				else if(salario <= 7507.49)
				{
					salario = (float) (salario - (salario * 0.14));
				}
				else if(salario <= 12856.50)
				{
					salario = (float) (salario - (salario * 0.145));
				}
				else if(salario <= 25712.99)
				{
					salario = (float) (salario - (salario * 0.165));
				}
				else if(salario <= 50140.33)
				{
					salario = (float) (salario - (salario * 0.19));
				}
				else if(salario > 50140.33)
				{
					salario = (float) (salario - (salario * 0.22));
				}
				
				txtMensal.setText(String.valueOf(salario));//nessa linha, txtImpostoMen recebe o valor que está em impostoAN;
		
			}
		});
		INSS.setBounds(450, 35, 80, 25);
		INSS.setText("Desc INSS");
		
		Button btnLimpar = new Button(painel, SWT.NONE);
		btnLimpar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtMensal.setText(String.valueOf(0));
				txtAnual.setText(String.valueOf(""));
				txtImpostoMen.setText(String.valueOf(""));
				txtImpostoAn.setText(String.valueOf(""));
				txtAliquota.setText(String.valueOf(""));
				txtDependentes.setText(String.valueOf(0));
			}
		});
		btnLimpar.setBounds(230, 119, 89, 34);
		btnLimpar.setText("Limpar");
	}
}

//separar informações de imposto de renda anual de um lado e mensal do outro. interrogação no INSS para o usuário entender
