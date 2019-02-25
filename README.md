![Release](https://img.shields.io/github/release/Nesvilab/FragPipe.svg) ![Downloads](https://img.shields.io/github/downloads/Nesvilab/FragPipe/total.svg)

<img src="frag-pipe/images/fragpipe-01.png" width="350px"/>
<img src="logo/msfragger-logo.png" width="350px"/>

# FragPipe (previously - MSfragger GUI)
This is a very basic Java GUI wrapper for [MSFragger](http://www.nature.com/nmeth/journal/v14/n5/full/nmeth.4256.html) - ultrafast proteomic search engine.  
It will help you launch MSFragger for Open and Closed searches and can also run post-processing of results with Peptide/Protein Prophets as well as generate tabular summary results using [Philosopher](https://nesvilab.github.io/philosopher/).

## Download
Download precompiled binaries from the [Releases](https://github.com/Nesvilab/FragPipe/releases/) section of this repository

## Running
- on **Windows** use one of the following:
  - Run the Windows executable (*.exe*)
  - `start javaw -jar FragPipe.jar`
  - `java -jar FragPipe.jar`
- **Linux/MacOS**
  - Run the shell script included in the release zip file
  - `java -jar FragPipe.jar`


## Citing the work
Please refer to the following paper:  
[Andy Kong, Felipe Leprevost, Dmitry Avtonomov, Dattatreya Mellacheruvu, Alexey Nesvizhskii. "MSFragger: ultrafast and comprehensive peptide identification in mass spectrometry-based proteomics". Nat Meth, May 2017. DOI: 10.1038/nmeth.4256](http://dx.doi.org/10.1038/nmeth.4256)

## Build

### Updating build version
The version of the build is stored in 2 separate places:
 - File: `MSFragger-GUI/src/umich/msfragger/gui/Bundle.properties`  
   Property: `msfragger.gui.version`

 - File: `MSFragger-GUI/build.gradle`  
   Property: `version`


### Building with Gradle (preferred)
You don't need to have Gradle installed. This method uses Gradle Wrapper,
which is included in this repository. Eeverything needed for the build will 
be downloaded.

- To get the jar with all dependencies included, from the directory with 
the `gradle.build` file:  
  `./gradlew clean shadowJar`

- If you're on Windows you can also build a Windows binary (*requires [launch4j](http://launch4j.sourceforge.net/) installed*):  
  `./gradlew clean createAllExecutables`

- To create a zip file with the jar and startup scripts/bat files:  
  `./gradlew distZip`

Inspect the output in `MSFragger-GUI/build/lbis` and 
  `MSFragger-GUI/build/distributions` folders.



#### Building with NetBeans/Ant (deprecated)
**Deprecated:** Use Gradle build instead.  
Open the source project in NetBeans and do "Clean Build". You will get the jar in ./dist directory and a zip file with the current version in the file name and start scripts bundled.

[![Analytics](https://ga-beacon-nocache.appspot.com/UA-5572974-15/github/chhh/msfragger-gui/landing-page?flat&useReferer)](https://github.com/igrigorik/ga-beacon)
