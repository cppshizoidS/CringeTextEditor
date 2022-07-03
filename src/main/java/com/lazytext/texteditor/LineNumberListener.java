package com.lazytext.texteditor;

import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class LineNumberListener implements CaretListener {
  private final LazyText window;

  public LineNumberListener(LazyText window) { this.window = window; }
  // End of LineNumberListener Contructor

  private void updateCaretPaneText(int currentLine, int columnPosition) {
    ((JTextPane)this.window.getStatusBarComponent(0))
        .setText("Line: " + currentLine + "  Column: " + columnPosition);
  } // End of updateCaretPaneText

  @Override
  public void caretUpdate(CaretEvent e) {

    int lineNumber = 1;
    int columnNumber = 1;

    try {
      int caretPosition = this.window.getTextArea().getCaretPosition();
      lineNumber = this.window.getTextArea().getLineOfOffset(caretPosition);


      columnNumber = caretPosition -
                     this.window.getTextArea().getLineStartOffset(lineNumber);


      lineNumber += 1;
      columnNumber += 1;
    } catch (Exception ignored) {
    }

    updateCaretPaneText(lineNumber, columnNumber);
  } // End of caretUpdate

} // End of LineNumberListener Class
