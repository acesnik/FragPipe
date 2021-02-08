# Workflow: common-mass-offsets

AdjustFragIntensity=true
BoostComplementaryIon=false
CorrThreshold=0
DeltaApex=0.2
RFmax=500
RPmax=25
RTOverlap=0.3
SE.EstimateBG=false
SE.MS1PPM=10
SE.MS2PPM=20
SE.MassDefectFilter=true
SE.MinMSIntensity=1
SE.MinMSMSIntensity=1
SE.NoMissedScan=1
WindowSize=10
SE.SN=1.1
SE.MS2SN=1.1
SE.IsoPattern=0.3
SE.MassDefectOffset=0.1
ExportPrecursorPeak=false
run-diaumpire=false
crystalc.run-crystalc=false
database.decoy-tag=rev_
freequant.mz-tol=10
freequant.rt-tol=0.4
freequant.run-freequant=false
ionquant.excludemods=
ionquant.heavy=
ionquant.imtol=0.05
ionquant.ionfdr=0.01
ionquant.light=
ionquant.mbr=0
ionquant.mbrimtol=0.05
ionquant.mbrmincorr=0
ionquant.mbrrttol=1
ionquant.mbrtoprun=10
ionquant.medium=
ionquant.minexps=1
ionquant.minfreq=0.5
ionquant.minions=2
ionquant.minisotopes=2
ionquant.minscans=3
ionquant.mztol=10
ionquant.normalization=1
ionquant.peptidefdr=1
ionquant.proteinfdr=1
ionquant.proteinquant=2
ionquant.requantify=1
ionquant.rttol=0.4
ionquant.run-ionquant=true
ionquant.tp=3
ionquant.writeindex=0
msfragger.dia=0
msfragger.Y_type_masses=0 203.07937 406.15874 568.21156 730.26438 892.3172 349.137279
msfragger.add_topN_complementary=0
msfragger.allow_multiple_variable_mods_on_residue=false
msfragger.allowed_missed_cleavage=2
msfragger.calibrate_mass=2
msfragger.clip_nTerm_M=true
msfragger.deisotope=1
msfragger.delta_mass_exclude_ranges=(-1.5,3.5)
msfragger.diagnostic_fragments=204.086646 186.076086 168.065526 366.139466 144.0656 138.055 126.055 163.060096 512.197375 292.1026925 274.0921325 657.2349 243.026426 405.079246 485.045576 308.09761
msfragger.diagnostic_intensity_filter=0
msfragger.digest_max_length=50
msfragger.digest_min_length=7
msfragger.fragment_ion_series=b,y
msfragger.fragment_mass_tolerance=20
msfragger.fragment_mass_units=1
msfragger.intensity_transform=0
msfragger.ion_series_definitions=
msfragger.isotope_error=0/1
msfragger.labile_search_mode=off
msfragger.localize_delta_mass=true
msfragger.mass_diff_to_variable_mod=0
msfragger.mass_offsets=-105.0248 -89.0299 -33.9877 -32.0085 -30.0106 -18.0106 -17.0265 -2.0157 -1.007825 -0.984 0 0.984 3.9949 12.0 13.9793 14.0157 15.9949 19.9898 21.969392 21.9819 23.95806 26.0157 27.9949 28.0313 28.990164 29.9742 31.972071 31.9898 37.9469 37.955882 42.0106 42.047 43.0058 43.9898 44.985078 47.9847 53.9193 57.0215 58.0055 61.9135 61.921774 68.026215 70.041865 71.0371 79.9568 79.9663 86.000394 100.016 114.042927 119.004099 128.095 146.0579 156.1011 162.0528 173.051 176.0321 178.0477 183.035399 189.046 203.0794 204.1878 210.1984 228.111 229.014009 238.2297 301.9865 340.1006 349.1373 365.1322 365.1322 406.1587 541.06111
msfragger.max_fragment_charge=1
msfragger.max_variable_mods_combinations=5000
msfragger.max_variable_mods_per_peptide=3
msfragger.min_fragments_modelling=2
msfragger.min_matched_fragments=4
msfragger.minimum_peaks=15
msfragger.minimum_ratio=0.01
msfragger.misc.fragger.clear-mz-hi=0
msfragger.misc.fragger.clear-mz-lo=0
msfragger.misc.fragger.digest-mass-hi=5000
msfragger.misc.fragger.digest-mass-lo=500
msfragger.misc.fragger.enzyme-dropdown=stricttrypsin
msfragger.misc.fragger.precursor-charge-hi=4
msfragger.misc.fragger.precursor-charge-lo=1
msfragger.misc.fragger.remove-precursor-range-hi=1.5
msfragger.misc.fragger.remove-precursor-range-lo=-1.5
msfragger.misc.slice-db=1
msfragger.num_enzyme_termini=2
msfragger.output_format=pepXML
msfragger.output_max_expect=50
msfragger.output_report_topN=1
msfragger.override_charge=false
msfragger.precursor_mass_lower=-10
msfragger.precursor_mass_mode=corrected
msfragger.precursor_mass_units=1
msfragger.precursor_mass_upper=10
msfragger.precursor_true_tolerance=20
msfragger.precursor_true_units=1
msfragger.remove_precursor_peak=0
msfragger.report_alternative_proteins=false
msfragger.restrict_deltamass_to=all
msfragger.run-msfragger=true
msfragger.search_enzyme_butnotafter=
msfragger.search_enzyme_cutafter=KR
msfragger.search_enzyme_name=stricttrypsin
msfragger.table.fix-mods=0.000000,C-Term Peptide,true,-1; 0.000000,N-Term Peptide,true,-1; 0.000000,C-Term Protein,true,-1; 0.000000,N-Term Protein,true,-1; 0.000000,G (glycine),true,-1; 0.000000,A (alanine),true,-1; 0.000000,S (serine),true,-1; 0.000000,P (proline),true,-1; 0.000000,V (valine),true,-1; 0.000000,T (threonine),true,-1; 57.021460,C (cysteine),true,-1; 0.000000,L (leucine),true,-1; 0.000000,I (isoleucine),true,-1; 0.000000,N (asparagine),true,-1; 0.000000,D (aspartic acid),true,-1; 0.000000,Q (glutamine),true,-1; 0.000000,K (lysine),true,-1; 0.000000,E (glutamic acid),true,-1; 0.000000,M (methionine),true,-1; 0.000000,H (histidine),true,-1; 0.000000,F (phenylalanine),true,-1; 0.000000,R (arginine),true,-1; 0.000000,Y (tyrosine),true,-1; 0.000000,W (tryptophan),true,-1; 0.000000,B ,true,-1; 0.000000,J,true,-1; 0.000000,O,true,-1; 0.000000,U,true,-1; 0.000000,X,true,-1; 0.000000,Z,true,-1
msfragger.table.var-mods=15.994900,M,false,3; 42.010600,[^,false,1; 79.966330,STY,false,3; -17.026500,nQnC,false,1; -18.010600,nE,false,1; 4.025107,K,false,2; 6.020129,R,false,2; 8.014199,K,false,2; 10.008269,R,false,2; 0.000000,site_10,false,1; 0.000000,site_11,false,1; 0.000000,site_12,false,1; 0.000000,site_13,false,1; 0.000000,site_14,false,1; 0.000000,site_15,false,1; 0.000000,site_16,false,1
msfragger.track_zero_topN=0
msfragger.use_topN_peaks=150
msfragger.write_calibrated_mgf=false
msfragger.zero_bin_accept_expect=0
msfragger.zero_bin_mult_expect=1
peptide-prophet.cmd-opts=--nonparam --expectscore --decoyprobs --masswidth 1000.0 --clevel -2
peptide-prophet.combine-pepxml=true
peptide-prophet.run-peptide-prophet=true
phi-report.dont-use-prot-proph-file=false
phi-report.filter=--sequential --razor --mapmods --prot 0.01
phi-report.pep-level-summary=false
phi-report.print-decoys=false
phi-report.run-report=true
protein-prophet.cmd-opts=--maxppmdiff 2000000
protein-prophet.run-protein-prophet=true
ptmprophet.cmdline=--keepold --static --em 1 --nions b --mods STY\:79.966331,M\:15.9949 --minprob 0.5
ptmprophet.run-ptmprophet=false
ptmshepherd.annotation-common=true
ptmshepherd.annotation-custom=false
ptmshepherd.annotation-unimod=false
ptmshepherd.annotation_file=
ptmshepherd.annotation_tol=0.01
ptmshepherd.cap_y_ions=
ptmshepherd.diag_ions=
ptmshepherd.glyco_mode=false
ptmshepherd.histo_smoothbins=2
ptmshepherd.iontype_a=false
ptmshepherd.iontype_b=true
ptmshepherd.iontype_c=false
ptmshepherd.iontype_x=false
ptmshepherd.iontype_y=true
ptmshepherd.iontype_z=false
ptmshepherd.localization_background=4
ptmshepherd.output_extended=false
ptmshepherd.peakpicking_mass_units=1
ptmshepherd.peakpicking_promRatio=0.3
ptmshepherd.peakpicking_width=3
ptmshepherd.precursor_mass_units=1
ptmshepherd.precursor_tol=3
ptmshepherd.remainder_masses=
ptmshepherd.run-shepherd=true
ptmshepherd.spectra_maxfragcharge=2
ptmshepherd.varmod_masses=
quantitation.run-label-free-quant=false
speclibgen.easypqp.extras.rt_lowess_fraction=0.01
speclibgen.easypqp.rt-cal=noiRT
speclibgen.easypqp.select-file.text=
speclibgen.run-speclibgen=false
speclibgen.use-easypqp=false
speclibgen.use-spectrast=true
tmtintegrator.add_Ref=1
tmtintegrator.allow_overlabel=true
tmtintegrator.allow_unlabeled=false
tmtintegrator.best_psm=true
tmtintegrator.channel_num=4
tmtintegrator.dont-run-fq-lq=false
tmtintegrator.freequant=--ptw 0.4 --tol 10 --isolated
tmtintegrator.groupby=0
tmtintegrator.labelquant=--tol 20
tmtintegrator.quant_level=2
tmtintegrator.max_pep_prob_thres=0.9
tmtintegrator.min_ntt=0
tmtintegrator.aggregation_method=0
tmtintegrator.min_pep_prob=0.9
tmtintegrator.min_percent=0.05
tmtintegrator.min_purity=0.5
tmtintegrator.min_site_prob=-1
tmtintegrator.mod_tag=none
tmtintegrator.ms1_int=true
tmtintegrator.outlier_removal=true
tmtintegrator.print_RefInt=false
tmtintegrator.prot_exclude=none
tmtintegrator.prot_norm=1
tmtintegrator.psm_norm=false
tmtintegrator.ref_tag=Bridge
tmtintegrator.run-tmtintegrator=false
tmtintegrator.top3_pep=true
tmtintegrator.unique_gene=0
tmtintegrator.unique_pep=false
workflow.description=<p style\="margin-top\: 0in"> Mass Offset (also known as Multinotch) search workflow for a fast search for most common modifications (list of mass shifts specified in MSFragger 'Mass Offset' field). MSFragger localization-aware open search (LOS) algorithm, filtered to report PSMs with specified mass shifts only (with isotope errors allowed). No variable modifications are specified. Mass calibration, parameter optimization, and precursor monoisotope error correction are enabled. PeptideProphet with extended mass model. PTM-Shepherd for mass shift summarization. </p>
workflow.input.data-type.im-ms=false
workflow.input.data-type.regular-ms=true
workflow.process-exps-separately=false
workflow.saved-with-ver=14.0-rc2
