package pl.coalatransport.util;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.TextFormatter;

import java.util.regex.Pattern;

public class TextFieldFormatter {

    final char separatorChar = '/';
    final Pattern p = Pattern.compile("[0-9" + separatorChar + "]*");


    public void formatOrderNumberTextField(JFXTextField jfxTextField) {
        jfxTextField.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.isContentChange()) {
                return c;
            }
            String newText = c.getControlNewText();
            if (newText.isEmpty()) {
                return c;
            }
            if (!p.matcher(newText).matches()) {
                return null;
            }

            StringBuilder sb = new StringBuilder();
            int digits = 0;

            // Connect input numbers into order number in format **/**/****
            int separatorCounter = 0;
            for (int i = 0; i < c.getControlNewText().length(); i++) {
                char letter = newText.charAt(i);

                if (Character.isDigit(letter)) {
                    sb.append(letter);
                    digits++;

                    if (separatorCounter < 2 && digits % 2 == 0) {
                        sb.append(separatorChar);
                        separatorCounter++;
                    }
                }
            }


            //Remove separator when using backspace
            if (digits % 2 == 0 && digits % 6 != 0 && digits % 8 != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }


            int maxLength = 10;
            int newLength = c.getControlNewText().length();

            //Create result text
            String resultText = c.getControlNewText();
            if (newLength > maxLength) {
                resultText = c.getControlNewText().substring(0, maxLength);
                sb.delete(0, newLength);
                sb.append(resultText);
            } else {

            }

            //Replace old text with new result text
            int resultTextActualLength = sb.length();
            c.setRange(0, c.getRangeEnd());
            c.setText(sb.toString());
            c.setCaretPosition(resultTextActualLength);
            c.setAnchor(resultTextActualLength);

            return c;
        }));
    }
}
