# ThinkDataStructures Project Board

Numbered tasks for tracking work. Each task has a permanent number; add new tasks at the end. Update status as work progresses.

### Current focus (2026-10-10)

- **Task 1:** Releases — see below.

---

## Task 1: Releases (PDF on GitHub and greenteapress.com)

**Status:** Ongoing (added 2026-10-10)

### Released

- **v1.0.0** (tag only) — `1fb58bf`, the source of the PDF built 2017-06-16 (committed an hour after the build).
- **v1.1.0** (2026-10-10, latest) — `88c1d12`: the 85 printed `thinkdast.com/KEY` links (that domain lapsed and belongs to someone else) are now `greenteapress.com/dast/KEY` with the same keys, so readers of older copies can swap the domain; includes the 2017 1.0.1 edits that were never built; adds `latexonly.tex`/`localdef.sty`. 191 pages (1.0.0: 187; chapter 6 grew a few lines and pushed chapter 7 to the next odd page). Same file on greenteapress.com.
- Redirects: `greenteapress.com/dast/KEY` (76 keys, all tested) plus an older copy at `greenteapress.com/thinkdast/KEY`. Dead targets fixed 2026-10-10: `explorer` → Wayback copy; `myarraylist` → `solutions/src/com/allendowney/thinkdast/MyArrayList.java`; `redissign` → redistogo.com.

### How to release a new version

The pattern (GreenTeaPress `PROJECT_BOARD.md`, Task 7): the GitHub release asset is the canonical, versioned PDF; an identical copy lives on greenteapress.com (the WordPress page links that copy, which opens in the browser); the two must be the same file.

1. **Bump the version** (`\newcommand{\theversion}` in `book/book.tex`) and commit the source changes.
2. **Build** in a clean copy (not in a working tree with stray files): copy `book/`, then `pdflatex book; makeindex book.idx; pdflatex book; pdflatex book`; rename `book.pdf` to `thinkdast.pdf`. `book/latexonly.tex` and `book/localdef.sty` (from the Think Java 2 template) were added in 1.1.0 — before that the book could not be built from this repo
3. **Check the build:** no `^!` errors or "Rerun" warnings in the log; same page count unless content changed; compare the text with the previous PDF and read every difference:
   `diff <(pdftotext OLD.pdf - | tr -s ' \n' ' ') <(pdftotext NEW.pdf - | tr -s ' \n' ' ')` (or line-by-line `pdftotext` + `diff`); render any page that looks suspicious (`pdftoppm -f N -l N -r 60 -png`).
   Links: the book prints `\url{https://greenteapress.com/dast/KEY}`. To add or change one, edit `~/GreenTeaPress/greenteapress/dast/.htaccess` (one `Redirect 302 /dast/KEY TARGET` per key) and deploy it with `scripts/deploy_gtp.sh dast`; check `curl -sI https://greenteapress.com/dast/KEY`. Keys are permanent.
4. **Commit and push** the source (and anything the repo keeps in git); note the full SHA: `git rev-parse HEAD`.
5. **greenteapress.com:** `cp thinkdast.pdf ~/GreenTeaPress/greenteapress/thinkdast/`; in `~/GreenTeaPress`: commit, `scripts/deploy_gtp.sh -n thinkdast/thinkdast.pdf`, then without `-n`; check `curl -s https://greenteapress.com/thinkdast/thinkdast.pdf | cmp - greenteapress/thinkdast/thinkdast.pdf`.
6. **GitHub release:** `gh release create vX.Y.Z ~/GreenTeaPress/greenteapress/thinkdast/thinkdast.pdf -R AllenDowney/ThinkDataStructures --target FULL_SHA --title "Think Data Structures, version X.Y.Z" --notes-file NOTES.md --latest` (`--target` needs the **full** SHA). Verify: `curl -sL https://github.com/AllenDowney/ThinkDataStructures/releases/latest/download/thinkdast.pdf | cmp - ~/GreenTeaPress/greenteapress/thinkdast/thinkdast.pdf`.
7. Record the release here and in GreenTeaPress Task 7. Download counts for release assets are archived weekly by `~/GreenTeaPress/scripts/github_traffic.py`; GTP downloads appear in the weekly log report.

---

