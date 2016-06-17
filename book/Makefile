F=book

all:
	pdflatex $(F)
	makeindex $(F).idx        # shouldn't need .idx here, but we do
	pdflatex $(F)
	evince $(F).pdf

clean:
	rm -f $(F).aux $(F).idx $(F).ilg $(F).ind $(F).log $(F).out $(F).toc

plastex:
	# Before running plastex, we need the current directory in PYTHONPATH
	# export PYTHONPATH=$PYTHONPATH:.
	python preprocess.py $(F).tex > $(F).plastex
	plastex --renderer=DocBook --theme=book --image-resolution=300 --filename=$(F).xml $(F).plastex
	cd $(F); python ../postprocess.py $(F).xml > temp; mv temp $(F).xml

xxe:
	xmlcopyeditor ~/ThinkAlgorithms/$(F)/$(F).xml &

lint:
	xmllint -noout $(F)/$(F).xml

oreilly:
	rsync -a thinkalgorithms/thinkalgorithms.xml atlas	
	rsync -a figs/*.pdf atlas/figs/
	rsync -a figs/*.png atlas/figs/
	cd atlas; git add thinkalgorithms.xml figs/*	
	cd atlas; git commit -m "Automated check in."
	cd atlas; git push

hevea:	thinkalgorithms.tex header.html footer.html
	cp $(F).tex thinkalgorithms.tex
	rm -rf html
	mkdir html
	hevea -O -exec xxdate.exe -e latexonly htmlonly thinkalgorithms.tex
	imagen -png -pdf thinkalgorithms.tex
	hacha thinkalgorithms.html
	cp up.png next.png back.png html
	mv index.html thinkalgorithms.css thinkalgorithms*.html thinkalgorithms*.png html
	rm *motif.gif

DEST = /home/downey/public_html/greent/thinkalgorithms

distrib:
	rm -rf dist
	mkdir dist
	rsync -a $(F).pdf html dist
	rsync -a dist/* $(DEST)
	chmod -R o+r $(DEST)/*
	cd $(DEST)/..; sh back
