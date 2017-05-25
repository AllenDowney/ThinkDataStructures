F = thinkdast

all:
	pdflatex book
	makeindex book.idx        # shouldn't need .idx here, but we do
	pdflatex book
	evince book.pdf

hevea:	book.tex header.html footer.html
	cp book.tex $(F).tex
	rm -rf html
	mkdir html
	hevea -O -exec xxdate.exe -e latexonly htmlonly $(F).tex
	imagen -png -pdf $(F)
	hacha $(F).html
	cp up.png next.png back.png html
	# TODO: might have to bring back $(F).png
	mv -i index.html $(F).css $(F)*.html html
	rm *motif.gif

plastex:
	# Before running plastex, we need the current directory in PYTHONPATH
	# export PYTHONPATH=$PYTHONPATH:.
	python preprocess.py book.tex > $(F).plastex
	plastex --renderer=DocBook --theme=book --image-resolution=300 --filename=$(F).xml $(F).plastex
	cd $(F); python ../postprocess.py $(F).xml > temp; mv temp $(F).xml

xxe:
	xmlcopyeditor ~/ThinkDataStructures/$(F)/$(F).xml &

lint:
	xmllint -noout $(F)/$(F).xml

oreilly:
	rsync -a $(F)/$(F).xml atlas	
	rsync -a figs/*.pdf atlas/figs/
	rsync -a figs/*.png atlas/figs/
	cd atlas; git add $(F).xml figs/*	
	cd atlas; git commit -m "Automated check in."
	cd atlas; git push

DEST = /home/downey/public_html/greent/$(F)

distrib:
	rm -rf dist
	mkdir dist
	cp book.pdf $(F).pdf
	rsync -a $(F).pdf html dist
	rsync -a dist/* $(DEST)
	chmod -R o+r $(DEST)/*
	cd $(DEST)/..; sh back
