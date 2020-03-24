package com.dmtavt.fragpipe;

import com.github.chhh.utils.SwingUtils;
import javax.swing.JScrollPane;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import com.github.chhh.utils.swing.JPanelWithEnablement;
import com.github.chhh.utils.swing.TextConsole;

public class TabRun extends JPanelWithEnablement {
  final TextConsole console;
  JScrollPane scrollConsole;

  public TabRun(TextConsole console) {
    this.console = console;

    init();
  }

  private void init() {
    this.setLayout(new MigLayout(new LC().fill()));

    scrollConsole = SwingUtils.scroll(console);
    add(scrollConsole, new CC().grow().wrap());
  }
}
