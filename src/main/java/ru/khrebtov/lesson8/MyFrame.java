package ru.khrebtov.lesson8;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class MyFrame extends JFrame {

  private final JTextField textField;
  private char operation;
  private double total;
  private boolean isFirstDigit;
  private final JButton buttonMinus;
  private final JButton buttonMultiply;
  private final JButton buttonPlus;
  private final JButton buttonSplit;
  private final JButton buttonPoint;

  public MyFrame() throws HeadlessException {
    setTitle("Calculator");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(300, 300, 200, 220);
    isFirstDigit = true;

    JPanel jPanel = new JPanel();

    textField = new JTextField(18);
    textField.setEditable(false);

    JButton[] jbs = new JButton[9];
    jPanel.add(textField);
    for (int i = 0; i < jbs.length; i++) {
      jbs[i] = new JButton(String.valueOf(i + 1));
      jbs[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          action(e);
        }
      });
      jPanel.add(jbs[i]);
    }

    JButton buttonZero = new JButton("0");
    jPanel.add(buttonZero);
    buttonZero.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    buttonPlus = new JButton("+");
    jPanel.add(buttonPlus);
    buttonPlus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    buttonMinus = new JButton("-");
    jPanel.add(buttonMinus);
    buttonMinus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    buttonMultiply = new JButton("*");
    jPanel.add(buttonMultiply);
    buttonMultiply.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    buttonSplit = new JButton("/");
    jPanel.add(buttonSplit);
    buttonSplit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    buttonPoint = new JButton(".");
    jPanel.add(buttonPoint);
    buttonPoint.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        action(e);
      }
    });

    JButton buttonEquals = new JButton("=");
    jPanel.add(buttonEquals);
    buttonEquals.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField.setText(String.valueOf(calculating(e)));
      }
    });

    JButton buttonSqr = new JButton("Sqr");
    jPanel.add(buttonSqr);
    buttonSqr.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        double total = calculating(e);
        if (total == 0) {
          if (textField.getText().length() > 0) {
            total = Double.parseDouble(textField.getText());
          }
        }
        textField.setText(String.valueOf(total * total));
      }
    });

    JButton buttonClean = new JButton("C");
    jPanel.add(buttonClean);
    buttonClean.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField.setText("");
        buttonMinus.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonMultiply.setEnabled(true);
        buttonSplit.setEnabled(true);
        buttonPoint.setEnabled(true);
      }
    });

    add(jPanel);
    setResizable(false);
    setVisible(true);
  }

  private Double calculate(String text) {
    double answer = 0d;
    ArrayList<Character> mathSymbols = new ArrayList<>();
    for (int i = 0; i < text.length() - 1; i++) {
      char c = text.charAt(i);
      if (c == '-' || c == '+' || c == '*' || c == '/') {
        mathSymbols.add(c);
      }
    }
    //если 1 операция в строке
    if (mathSymbols.size() <= 1) {
      answer = calculating(text);
    } else {
      for (int i = 0; i <= mathSymbols.size() - 1; i++) {
        if (mathSymbols.get(i).equals('*') || mathSymbols.get(i).equals('/')) {
          //если * или / не первое и не последнее действие в строке
          if (i != 0 && i != mathSymbols.size() - 1) {
            //определяем индекс предыдущего знака и последующего
            char firstSymbol = mathSymbols.get(i - 1);
            char nextSymbol = mathSymbols.get(i + 1);

            String forFirstIndex = text.substring(0, text.lastIndexOf(firstSymbol) + 1);
            String forNextIndex = text.substring(text.indexOf(nextSymbol) + 1);

            int firstIndex = forFirstIndex.lastIndexOf(firstSymbol) + 1;
            int nextIndex = forNextIndex.indexOf(nextSymbol);
            // 1-это сам символ * или /
            int lastIndex = nextIndex + text.length() - forNextIndex.length();
            String s = text.substring(firstIndex, lastIndex);
            double someAnswer = calculating(s);
            String nextStep = text.substring(0, firstIndex) + someAnswer + text
                .substring(nextIndex + firstIndex + 2);
            answer = calculate(nextStep);
            break;
            //если * или / первое в строке
          } else if (i == 0) {
            //определяем индекс  последующего знака
            char nextSymbol = mathSymbols.get(i + 1);
            String forNextIndex = text.substring(text.indexOf(nextSymbol) + 1);
            int firstIndex = 0;
            int nextIndex = forNextIndex.indexOf(nextSymbol);
            if (nextIndex == -1) {
              forNextIndex = text.substring(text.indexOf(nextSymbol));
              nextIndex = forNextIndex.indexOf(nextSymbol);
            }
            // 1-это сам символ * или /
            int lastIndex = nextIndex + text.length() - forNextIndex.length();
            String s = text.substring(firstIndex, lastIndex);
            double someAnswer = calculating(s);
            String nextStep = someAnswer + text.substring(
                lastIndex);
            answer = calculate(nextStep);
            break;
            //если * или / последний в строке
          } else if (i == mathSymbols.size() - 1) {
            //определяем индекс предыдущего знака и последующего
            String forFirstIndex = text.substring(0, text.indexOf(mathSymbols.get(i)));
            char firstSymbol = mathSymbols.get(i - 1);
            int firstIndex = forFirstIndex.lastIndexOf(firstSymbol) + 1;
            // 1-это сам символ * или /
            String s = text.substring(firstIndex);
            double someAnswer = calculating(s);
            String nextStep = text.substring(0, firstIndex) + someAnswer;
            answer = calculate(nextStep);
            break;
          }
        } else {
          answer = calculating(text);
        }
      }
    }
    return answer;
  }

  private double calculating(ActionEvent e) {
    String text = textField.getText();
    return calculating(text);
  }

  private double calculating(String text) {

    StringBuilder digit = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '-' || c == '+' || c == '*' || c == '/') {
        double currentValue = Double.parseDouble(digit.toString());
        if (isFirstDigit) {
          total += currentValue;
          isFirstDigit = false;
        } else {
          choiceOfAction(currentValue);
        }

        digit = new StringBuilder();
        operation = c;
        continue;
      }
      digit.append(c);
    }

    double currentValue = Double.parseDouble(digit.toString());
    choiceOfAction(currentValue);

    isFirstDigit = true;
    double answer = total;
    total = 0;
    return answer;
  }

  private void choiceOfAction(double currentValue) {
    if (operation == '-') {
      total -= currentValue;
    } else if (operation == '+') {
      total += currentValue;
    } else if (operation == '*') {
      total *= currentValue;
    } else if (operation == '/') {
      total /= currentValue;
    }
  }

  public void action(ActionEvent e) {
    textField.setText(textField.getText() + e.getActionCommand());
    if (textField.getText().length() != 0) {
      isEnable();
    }
  }

  private void isEnable() {
    String text = textField.getText();
    if (text.lastIndexOf('-') == (text.length() - 1)
        || text.lastIndexOf('+') == text.length() - 1 || text.lastIndexOf('*') == text.length() - 1
        || text.lastIndexOf('/') == text.length() - 1) {
      buttonMinus.setEnabled(false);
      buttonPlus.setEnabled(false);
      buttonMultiply.setEnabled(false);
      buttonSplit.setEnabled(false);
      buttonPoint.setEnabled(false);
    } else {
      buttonMinus.setEnabled(true);
      buttonPlus.setEnabled(true);
      buttonMultiply.setEnabled(true);
      buttonSplit.setEnabled(true);
      buttonPoint.setEnabled(true);
    }
    if (text.lastIndexOf('.') == text.length() - 1) {
      buttonPoint.setEnabled(false);
    }
  }
}
