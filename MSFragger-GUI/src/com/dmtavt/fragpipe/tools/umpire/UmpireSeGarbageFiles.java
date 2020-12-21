package com.dmtavt.fragpipe.tools.umpire;

import com.github.chhh.utils.StringUtils;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UmpireSeGarbageFiles {
  public static final List<String> filesToMoveSansLog = Collections.emptyList();
  public static final List<String> logFile = Collections.singletonList("diaumpire_se.log");
  public static final List<String> filesToMove = Stream.concat(logFile.stream(), filesToMoveSansLog.stream())
          .collect(Collectors.toList());
  public static final List<String> fileNameSuffixesToMove = Arrays.asList(
      "_Peak", ".DIAWindowsFS", ".RTidxFS",
      ".ScanClusterMapping_Q1", ".ScanClusterMapping_Q2", ".ScanClusterMapping_Q3",
      ".ScanidxFS", ".ScanPosFS", ".ScanRTFS", "_diasetting.ser", "_params.ser",
      "_Q1.mgf", "_Q2.mgf", "_Q3.mgf");
  private UmpireSeGarbageFiles() {}

  public static List<Path> getGarbageFiles(Path lcmsFilePath, final boolean withLog) {
    List<Path> toMove = new ArrayList<>();
    String fnLessExt = StringUtils.upToLastDot(lcmsFilePath.getFileName().toString());
    Path filePath = lcmsFilePath.getParent();

    for (String fileToMove : withLog ? filesToMove : filesToMoveSansLog) {
      toMove.add(filePath.resolve(fileToMove));
    }

    for (String suffix : UmpireSeGarbageFiles.fileNameSuffixesToMove) {
      String filenameToMove = fnLessExt + suffix;
      toMove.add(filePath.resolve(filenameToMove));
    }
    return toMove;
  }
}
