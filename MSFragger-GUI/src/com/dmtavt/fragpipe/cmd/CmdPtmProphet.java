package com.dmtavt.fragpipe.cmd;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;

public class CmdPtmProphet extends CmdBase {
  public static String NAME = "PtmProphet";

  public CmdPtmProphet(boolean isRun, Path workDir) {
    super(isRun, workDir);
  }

  @Override
  public String getCmdName() {
    return NAME;
  }

  public boolean configure() {

    initPreConfig();

    List<String> cmd = new ArrayList<>();
    cmd.add("echo");
    cmd.add("ho-ho-ho");
    ProcessBuilder pb = new ProcessBuilder(cmd);
    pb.directory(Paths.get("D:\\ms-data\\").toFile());
    pbis.add(PbiBuilder.from(pb));

    isConfigured = true;
    return true;
  }

  @Override
  public boolean usesPhi() {
    return true;
  }
}
