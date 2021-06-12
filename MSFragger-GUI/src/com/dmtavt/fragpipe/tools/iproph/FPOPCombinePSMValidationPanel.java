package com.dmtavt.fragpipe.tools.iproph;

import com.dmtavt.fragpipe.Fragpipe;
import com.dmtavt.fragpipe.messages.MessageSearchType;
import com.dmtavt.fragpipe.messages.NoteConfigPhilosopher;
import com.dmtavt.fragpipe.params.ThisAppProps;
import com.github.chhh.utils.SwingUtils;
import com.github.chhh.utils.swing.*;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.dmtavt.fragpipe.Fragpipe.fe;

public class FPOPCombinePSMValidationPanel extends JPanelBase {
  private static final Logger log = LoggerFactory.getLogger(FPOPCombinePSMValidationPanel.class);
  public static final String PREFIX = "iprophet.";
  private UiCheck checkRun;
  private JButton btnAllowMassShifted;
  private JButton btnDisallowMassShifted;
  private UiText uiTextCmdOpts;
  private UiText uiTextFolder;
  private JPanel pTop;
  private JPanel pContent;

  public boolean isRun() {
    return SwingUtils.isEnabledAndChecked(checkRun);
  }

  public String getCmdOpts() {
    return uiTextCmdOpts.getNonGhostText().trim();
  }

  public String getPepXmlFolder() {
    return uiTextFolder.getNonGhostText().trim();
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

  private void loadDefaults(String type) {
    String v = Fragpipe.getPropFix(ThisAppProps.PROP_TEXT_CMD_IPROPHET, type);
    if (v == null) {
      v = "--nonsp";
      log.warn("Property [{}] not found in Bundle.properties, default to hardcoded value: {}", ThisAppProps.PROP_TEXT_CMD_IPROPHET, v);
    }
    uiTextCmdOpts.setText(v);
  }

  private static JFileChooser createIProphDirchooser() {
    JFileChooser fc = FileChooserUtils.create("Select Python 3 binary", "Select",
            false, FileChooserUtils.FcMode.DIRS_ONLY, true);
    return fc;
  }

  @Override
  public void init() {
    checkRun = UiUtils.createUiCheck("Run IProphet", true);
    checkRun.setName("run-iprophet");
    JButton btnDefaults = UiUtils.createButton("Load defaults", e -> {
      loadDefaults(null);
    });
    final String ghost = "select folder with the interact.pep.xmls";
    uiTextFolder = UiUtils.uiTextBuilder().ghost(ghost).create();
    FormEntry feInputFolder = fe(uiTextFolder, "interact-pep-xml-directory", PREFIX)
            .tooltip(ghost).label("input folder:").create();
    uiTextCmdOpts = UiUtils.uiTextBuilder().cols(20).text(defaultCmdOpt()).create();
//    JButton btnBrowse = feInputFolder.browseButton("Browse", ghost, CombinePSMValidationPanel::createIProphDirchooser, paths ->
//            paths.stream().findFirst()
//                    .ifPresent(bin -> Bus.post(new MessagePythonNewBin(bin.toString()))));
    final String interact_pep_xml_folder = uiTextCmdOpts.getNonGhostText();
//    final String interact_pep_xml_folder = "/storage/dpolasky/sharing/Guo_Ci/";

    System.out.println("interact_pep_xml_folder = " + interact_pep_xml_folder);
    for (Path f:getInteractPepXMLFiles(interact_pep_xml_folder))
      System.out.println("f = " + f);

    FormEntry feCmdOpts = mu.feb("cmd-opts", uiTextCmdOpts).label("Cmd line opts:").create();

    mu.layout(this, mu.lcFillXNoInsetsTopBottom());
    mu.border(this, "Combine PSM validation with IProphet");

    pTop = mu.newPanel(null, mu.lcFillXNoInsetsTopBottom());
    mu.add(pTop, checkRun).split();
//    mu.add(pTop, btnDefaults).gapLeft("20px");
    pContent = mu.newPanel(null, mu.lcFillXNoInsetsTopBottom());
    mu.add(pContent, feInputFolder.label()).alignX("right");
    mu.add(pContent, feInputFolder.comp).growX().pushX().wrap();
//    mu.add(pContent, feInputFolder.comp).growX().pushX();
//    mu.add(pContent, btnBrowse).growX().pushX().wrap();
//    mu.add(pContent, feCmdOpts.label()).alignX("right");
//    mu.add(pContent, feCmdOpts.comp).growX().pushX().wrap();

    mu.add(this, pTop).growX().wrap();
    mu.add(this, pContent).growX().wrap();
  }

  static public List<Path> getInteractPepXMLFiles(String interact_pep_xml_folder){
    try (Stream<Path> walkStream = Files.walk(Paths.get(interact_pep_xml_folder))) {
      return walkStream.filter(Files::exists).filter(f -> f.getFileName().toString().equals("interact.pep.xml")).collect(Collectors.toList());
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }
  private String defaultCmdOpt() {
    return Fragpipe.getPropFix(ThisAppProps.PROP_TEXT_CMD_IPROPHET, "open");
  }

  @Override
  public void initMore() {
    updateEnabledStatus(this, false); // will get enabled when Philosopher is selected
    super.initMore();
  }

  @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
  public void on(MessageSearchType m) {
    loadDefaults(m.type.name());
  }

  @Subscribe(sticky = true, threadMode = ThreadMode.MAIN_ORDERED)
  public void on(NoteConfigPhilosopher m) {
    updateEnabledStatus(this, m.isValid());
  }
}
