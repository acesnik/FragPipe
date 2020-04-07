package com.github.chhh.utils.swing;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class UiUtils {
  private UiUtils() {}

  public static void name(Component component, String name) {
    component.setName(name);
  }
  /**
   * Loads icon from current
   * @param resourcePath E.g. "/umich/msfragger/gui/icons/dia-umpire-16x16.png"
   */
  public static ImageIcon loadIcon(Class<?> clazz, String resourcePath) {
    return new ImageIcon(clazz.getResource(resourcePath));
  }

  public static UiCheck createUiCheck(String label, boolean selected, ActionListener listener) {
    UiCheck ui = new UiCheck(label, null, selected);
    ui.addActionListener(listener);
    return ui;
  }
  public static UiCheck createUiCheck(String label, boolean selected) {
    return new UiCheck(label, null, selected);
  }

  public static JButton createButton(String text, ActionListener listener) {
    JButton b = new JButton(text);
    b.addActionListener(listener);
    return b;
  }

  public static JButton createButton(String text, String tooltip, ActionListener listener) {
    JButton b = new JButton(text);
    b.setToolTipText(tooltip);
    b.addActionListener(listener);
    return b;
  }

  public static UiText createUiText(String filteredCharsRegex) {
    UiText uiText = new UiText();
    uiText.setDocument(DocumentFilters.getFilter(filteredCharsRegex));
    return uiText;
  }

  public static UiTextBuilder uiTextBuilder() {
    return new UiTextBuilder();
  }

  public static class UiTextBuilder {
    private final UiText uiText;

    public UiTextBuilder() {
      this.uiText = new UiText();
    }

    public UiTextBuilder cols(int cols) {
      uiText.setColumns(cols);
      return this;
    }

    public UiTextBuilder ghost(String ghostText) {
      uiText.setGhostText(ghostText);
      return this;
    }

    public UiTextBuilder filter(String filterRegex) {
      uiText.setDocument(DocumentFilters.getFilter(filterRegex));
      return this;
    }

    public UiTextBuilder text(String text) {
      uiText.setText(text);
      return this;
    }

    public UiText create() {
      return uiText;
    }
  }

  public static UiCombo createUiCombo(String[] options) {
    UiCombo uiCombo = new UiCombo();
    uiCombo.setModel(new DefaultComboBoxModel<>(options));
    return uiCombo;
  }

  public static UiCombo createUiCombo(List<String> options) {
    return createUiCombo(options.toArray(new String[0]));
  }

  /**
   * Use '#values()' method of enum to create a dropdown.
   */
  public static UiCombo createUiCombo(Enum<?>[] enumValues) {
    return createUiCombo(Stream.of(enumValues).map(Enum::name).toArray(String[]::new));
  }
}
