package com.lazytext.texteditor;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

public class NewLineListener implements DocumentListener {
  private final LazyText window;

  public NewLineListener(LazyText window) { this.window = window; }


  private String getLineNumber() {
    // Number of lines in the textArea
    int caretPosition = this.window.getTextArea().getDocument().getLength();

    Element root =
        this.window.getTextArea().getDocument().getDefaultRootElement();

    // Line number StringBuilder
    StringBuilder lineNumbersBuilder = new StringBuilder();

    lineNumbersBuilder.append("1"
                              + "\n");

    for (int elementIndex = 2;
         elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++)
      lineNumbersBuilder.append(elementIndex).append("\n");


    return lineNumbersBuilder.toString();
  }

  private void checkIfNewLineWasInserted() {
    String numberToBeAdded = getLineNumber();
    int currentlyDisplayedNumbers =
        window.getLinedNumberArea().getText().length();


    if (numberToBeAdded.length() != currentlyDisplayedNumbers) {
      window.getLinedNumberArea().setText(numberToBeAdded);
    }
  }

  public void changedUpdate(DocumentEvent de) {}

  public void insertUpdate(DocumentEvent de) {
    this.checkIfNewLineWasInserted();
  }

  public void removeUpdate(DocumentEvent de) {
    this.checkIfNewLineWasInserted();
  }
}