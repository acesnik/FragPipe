package com.github.chhh.utils.swing;

import com.github.chhh.utils.StringUtils;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.github.chhh.utils.SwingUtils;

public class FormEntry {

  public static final String LABEL_NOT_SHOWN = "not-shown";
  public final JComponent comp;
  public String propName;
  public final String labelText;
  public final String tooltip;

  public FormEntry(String propName, String labelText, JComponent comp) {
    this(propName, labelText, comp, null);
  }

  public FormEntry(String propName, JComponent comp) {
    this(propName, LABEL_NOT_SHOWN, comp, null);
  }

  public FormEntry(String propName, String labelText, JComponent comp, String tooltip) {
    this.comp = comp;
    this.propName = propName;
    this.labelText = labelText;
    this.tooltip = tooltip;
    init();
  }

  public static Builder builder(JComponent comp) {
    return new Builder(comp);
  }

  public static Builder builder(JComponent comp, String propName) {
    return new Builder(comp, propName);
  }

  private void init() {
    comp.setName(propName);
    comp.setToolTipText(SwingUtils.makeHtml(tooltip));
  }

  public JLabel label() {
    JLabel l = new JLabel(labelText);
    l.setLabelFor(comp);
    l.setToolTipText(tooltip);
    return l;
  }

  public static void registerGhost(JComponent comp, String ghostText) {
    final JTextField tf = (JTextField) comp;
    if (!StringUtils.isNullOrWhitespace(ghostText)) {
      if (tf instanceof GhostedTextComponent) {
        ((GhostedTextComponent) tf).setGhostText(ghostText);
      }
      GhostText.register(tf, ghostText, GhostText.LIGHT_GREY);
    }
  }

  public JButton button(String buttonText, final String ghostText, ActionListener onClick) {
    if (!(comp instanceof JTextField)) {
      throw new IllegalStateException(
          "Can only call button() method for FormEntries which are JTextField");
    }

    registerGhost(comp, ghostText);

    final JButton btn = new JButton(buttonText);
    btn.setToolTipText(tooltip);
    btn.addActionListener(onClick);
    return btn;
  }

  public JButton browseButton(Supplier<JFileChooser> fcProvider,
    final String ghostText, Consumer<List<Path>> onSuccess) {
    return browseButton("Browse", ghostText, fcProvider, onSuccess);
  }

  public JButton browseButton(String buttonText, final String ghostText,
      Supplier<JFileChooser> fcProvider,
      Consumer<List<Path>> onSuccess) {
    if (!(comp instanceof JTextField)) {
      throw new IllegalStateException(
          "Can only call browseButton() method for FormEntries which are JTextField");
    }

    final JTextField tf = (JTextField) comp;
    if (!StringUtils.isNullOrWhitespace(ghostText)) {
      if (tf instanceof GhostedTextComponent) {
        ((GhostedTextComponent) tf).setGhostText(ghostText);
      }
      GhostText.register(tf, ghostText, GhostText.LIGHT_GREY);
    }

    final JButton btn = new JButton(buttonText);
    btn.setToolTipText(tooltip);
    btn.addActionListener(e -> {
      JFileChooser fc = fcProvider.get();

      Component parent = SwingUtils.findParentFrameForDialog(comp);
      if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(parent)) {
        File[] fs = fc.getSelectedFiles();
        if (fs != null && fs.length > 0) {
          onSuccess.accept(Arrays.stream(fs).map(File::toPath).collect(Collectors.toList()));
        } else {
          onSuccess.accept(Collections.singletonList(fc.getSelectedFile().toPath()));
        }
      }
    });
    return btn;
  }

  public static class Builder {

    JComponent comp;
    String propName;
    String labelText;
    String tooltip;

    public Builder(JComponent comp) {
      this(comp, null);
    }

    public Builder(JComponent comp, String propName) {
      this.comp = comp;
      this.propName = propName;
      labelText = LABEL_NOT_SHOWN;
      tooltip = null;
    }

    public Builder name(String name) {
      this.propName = name;
      return this;
    }

    public Builder label(String label) {
      this.labelText = label;
      return this;
    }

    public Builder tooltip(String tooltip) {
      this.tooltip = tooltip;
      return this;
    }

    public FormEntry create() {
      return new FormEntry(propName, labelText, comp, SwingUtils.makeHtml(tooltip));
    }
  }
}