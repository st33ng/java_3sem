import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

import static java.lang.Math.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.math.*;
@SuppressWarnings("serial")
// Главный класс приложения, он же класс фрейма
public class Main extends JFrame {
    // Размеры окна приложения в виде констант
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    // Текстовые поля для считывания значений переменных,
// как компоненты, совместно используемые в различных методах
    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;


    // Текстовое поле для отображения результата,
// как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private ImageIcon im1=new ImageIcon("D:\\dowland\\uLo2QMgl-2o.jpg");
    private ImageIcon im=new ImageIcon("D:\\dowland\\JdBAFYf4Nik.jpg");
    // Контейнер для отображения радио-кнопок
    private ButtonGroup radioButtons1 = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxFormulaType1 = Box.createHorizontalBox();
    private Box kekw=Box.createHorizontalBox();
    private Box kekw1=Box.createHorizontalBox();
    private int formulaId = 1;
    // Формула №1 для рассчѐта
    private int formulaId1 = 1;
    private double mem1=0;
    private double mem3=0;
    private double mem2=0;

    private JPanel img1;
    private JTextField textFieldmem1;
    private JTextField textFieldmem2;
    private JTextField textFieldmem3;

    public Double calculate1(Double x, Double y,Double z)  {

        return sin(log(y)+sin(PI*y*y))*pow(x*x+sin(z)+exp(cos(z)),1/4);
    }
    // Формула №2 для рассчѐта
    public Double calculate2(Double x, Double y,Double z) {
        return pow(cos(exp(x))+log(1+y)*log(1+y)+sqrt(exp(cos(x))+sin(PI*z)*sin(PI*z))+sqrt(1/x)+cos(y)*cos(y),sin(z));
    }

    // Вспомогательный метод для добавления кнопок на панель
    private void addRadioButton2(String buttonName, final int formulaId,JLabel imh,JLabel imh1) {
        JRadioButton button = new JRadioButton(buttonName);
        JPanel imagePane=new JPanel();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Main.this.formulaId = formulaId;
                imagePane.updateUI();
                kekw.add(imh);
                kekw.add(imh1);
                if(formulaId==1){
                    imh1.setVisible(false);
                    imh.setVisible(true);
                }
                else {
                    imh.setVisible(false);
                    imh1.setVisible(true);
                }

            }
        });

        radioButtons.add(button);
        hboxFormulaType.add(button);
    }
    private void addRadioButton1(String buttonName, final int formulaId12) {
        JRadioButton button = new JRadioButton(buttonName);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Main.this.formulaId1 = formulaId12;

            }
        });
        radioButtons1.add(button);
        hboxFormulaType1.add(button);
    }

    // Конструктор класса

    public Main() {
        super("Вычисление формулы");

        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
// Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);

        JLabel imh=new JLabel(im);
        JLabel imh1=new JLabel(im1);
        kekw.add(imh);
        hboxFormulaType.add(Box.createHorizontalGlue());

        addRadioButton2("Формула 1", 1,imh,imh1);
        addRadioButton2("Формула 2", 2,imh,imh1);

        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(
                BorderFactory.createLineBorder(Color.YELLOW));
// Создать область с полями ввода для X и Y
        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForz=new JLabel("Z:");
        textFieldZ=new JTextField("0",10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        Box hboxVariables = Box.createHorizontalBox();
        hboxVariables.setBorder(
                BorderFactory.createLineBorder(Color.RED));
        hboxVariables.add(Box.createHorizontalGlue());
        hboxVariables.add(Box.createHorizontalStrut(100));
        hboxVariables.add(labelForX);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldX);
        hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(labelForY);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldY);
        hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(labelForz);
        hboxVariables.add(Box.createHorizontalStrut(10));
        hboxVariables.add(textFieldZ);
        hboxVariables.add(Box.createHorizontalStrut(30));
        hboxVariables.add(Box.createHorizontalGlue());
// Создать область для вывода результата
        JLabel labelForResult = new JLabel("Результат:");
//labelResult = new JLabel("0");
        textFieldResult = new JTextField("0", 10);
        textFieldResult.setMaximumSize(
                textFieldResult.getPreferredSize());
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
// Создать область для кнопок
        JButton buttonCalc = new JButton("Вычислить");

        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;

                    if (formulaId==1) {
                        result = calculate1(x, y, z);

                    }
                    else {

                        result = calculate2(x, y, z);

                    }
                    if(result==Float.NaN || result==Double.POSITIVE_INFINITY || result==Double.NEGATIVE_INFINITY){
                        JOptionPane.showMessageDialog(Main.this,
                                "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException  ex) {
                    JOptionPane.showMessageDialog(Main.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton buttonReset = new JButton("Очистить поля");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(30));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.setBorder(
                BorderFactory.createLineBorder(Color.GREEN));
        hboxFormulaType1.add(Box.createHorizontalGlue());
        //добавление памяти
        textFieldmem1 = new JTextField("0", 10);
        textFieldmem2 = new JTextField("0", 10);
        textFieldmem3 = new JTextField("0", 10);
        textFieldmem1.setMaximumSize(
                textFieldmem1.getPreferredSize());
        textFieldmem2.setMaximumSize(
                textFieldmem1.getPreferredSize());
        textFieldmem3.setMaximumSize(
                textFieldmem1.getPreferredSize());
        Box textFieldMem= Box.createHorizontalBox();
        textFieldMem.add(Box.createHorizontalGlue());
        textFieldMem.add(textFieldmem1);
        textFieldMem.add(Box.createHorizontalStrut(30));
        textFieldMem.add(textFieldmem2);
        textFieldMem.add(Box.createHorizontalStrut(30));
        textFieldMem.add(textFieldmem3);
        textFieldMem.add(Box.createHorizontalGlue());
        //радиокнопки
        addRadioButton1("mem1", 1);
        addRadioButton1("mem2", 2);
        addRadioButton1("mem3", 3);

        radioButtons.setSelected(
                radioButtons.getElements().nextElement().getModel(), true);
        hboxFormulaType1.add(Box.createHorizontalGlue());
        hboxFormulaType1.setBorder(
                BorderFactory.createLineBorder(Color.GRAY));

        JButton M = new JButton("MC+");
        M.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double m1;
                    if (formulaId1==1  && formulaId==1) {
                        m1 = calculate1(x, y, z) + mem1;
                        mem1=m1;
                        textFieldmem1.setText(m1.toString());
                    }
                    else if (formulaId1==1 && formulaId==2) {
                        m1 = calculate2(x, y,z)+mem1;
                        mem1=m1;
                        textFieldmem1.setText(m1.toString());
                    }
                    else if (formulaId1==2  && formulaId==1) {
                        m1 = calculate1(x, y, z) + mem2;
                        mem2=m1;
                        textFieldmem2.setText(m1.toString());
                    }
                    else if (formulaId1==2 && formulaId==2) {
                        m1 = calculate2(x, y,z)+mem2;
                        mem2=m1;
                        textFieldmem2.setText(m1.toString());
                    }
                    else if (formulaId1==3  && formulaId==1) {
                        m1 = calculate1(x, y, z) + mem3;
                        mem3=m1;
                        textFieldmem3.setText(m1.toString());
                    }
                    else if (formulaId1==3 && formulaId==2) {
                        m1 = calculate2(x, y,z)+mem3;
                        mem3=m1;
                        textFieldmem3.setText(m1.toString());
                    }


                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Main.this,
                            "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        JButton Mc = new JButton("MC");
        Mc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                Double m1;
                if(formulaId1==1){
                    mem1=0;
                    m1=mem1;
                    textFieldmem1.setText(m1.toString());
                }
                else if(formulaId1==2){
                    mem2=0;
                    m1=mem2;
                    textFieldmem2.setText(m1.toString());
                }
                else{
                    mem3=0;
                    m1=mem3;
                    textFieldmem3.setText(m1.toString());
                }
            }
        });

        Box hboxButtons1 = Box.createHorizontalBox();
        hboxButtons1.add(Box.createHorizontalGlue());
        hboxButtons1.add(M);
        hboxButtons1.add(Box.createHorizontalStrut(30));
        hboxButtons1.add(Mc);
        hboxButtons1.add(Box.createHorizontalGlue());
        hboxButtons1.setBorder(
                BorderFactory.createLineBorder(Color.RED));
// Связать области воедино в компоновке BoxLayout
        Box contentBox = Box.createVerticalBox();
        contentBox.add(Box.createVerticalGlue());
        contentBox.add(kekw);
        contentBox.add(kekw1);
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxVariables);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        contentBox.add(hboxFormulaType1);
        contentBox.add(hboxButtons1);
        contentBox.add(textFieldMem);
        contentBox.add(Box.createVerticalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }
    // Главный метод класса
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}