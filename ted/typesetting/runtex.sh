#!/usr/bin/zsh
pdflatex text.tex
rm text.log
rm text.aux
evince text.pdf
