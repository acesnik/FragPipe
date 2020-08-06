package com.dmtavt.fragpipe.params.ptmprophet;

import com.github.chhh.utils.SwingUtils;
import com.github.chhh.utils.swing.FormEntry;
import com.github.chhh.utils.swing.JPanelBase;
import com.github.chhh.utils.swing.MigUtils;
import com.github.chhh.utils.swing.UiCheck;
import com.github.chhh.utils.swing.UiText;
import com.github.chhh.utils.swing.UiUtils;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ItemSelectable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

public class PtmProphetPanel extends JPanelBase {
  private static final String PREFIX = "ptmprophet.";
  protected final static MigUtils mu = MigUtils.get();
  private JPanel pTop;
  private JPanel pContent;
  private UiCheck checkRun;
  private UiText uitextCmdLine;

  public PtmProphetPanel() {
    super();
  }

  @Override
  protected ItemSelectable getRunCheckbox() {
    return checkRun;
  }

  @Override
  protected Component getEnablementToggleComponent() {
    return pContent;
  }

  @Override
  protected String getComponentNamePrefix() {
    return PREFIX;
  }

  @Override
  protected void init() {
    this.setLayout(new BorderLayout());
    this.setBorder(new TitledBorder("PTM Prophet"));

    pTop = createPanelTop();
    pContent = createPanelContent();

    this.add(pTop, BorderLayout.NORTH);
    this.add(pContent, BorderLayout.CENTER);
  }

  private JPanel createPanelContent() {
    JPanel p = new JPanel(new MigLayout(new LC().fillX()));
    mu.borderEmpty(p);

    uitextCmdLine = UiUtils.uiTextBuilder().text("some default text").create();
    FormEntry feCmdLineArgs = mu.feb("command-line-args", uitextCmdLine).tooltip("some help text")
        .label("Cmd line args").create();

    mu.add(p, feCmdLineArgs.label(), mu.ccR());
    mu.add(p, feCmdLineArgs.comp).wrap();

    return p;
  }

  private JPanel createPanelTop() {
    JPanel p = mu.newPanel(new LC());
    mu.borderEmpty(p);

    checkRun = new UiCheck("Run PTM Prophet", null, false);
    checkRun.setName("run-ptmprophet");

    mu.add(p, checkRun).wrap();

    return p;
  }

  public boolean isRun() {
    return SwingUtils.isEnabledAndChecked(checkRun);
  }
}
