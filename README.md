# ThinkDataStructures

LaTeX source and supporting code for *Think Data Structures: Algorithms and Information Retrieval in Java*


Data structures and algorithms are among the most important inventions
of the last 50 years, and they are fundamental tools
software engineers need to know.  But in my opinion, most of the books
on these topics are too theoretical, too big, and too bottom-up:

* Too theoretical:  Mathematical analysis of algorithms is based
on simplifying assumptions that limit its usefulness in practice.
Many presentations of this topic gloss over the simplifications and
focus on the math.  In this book I present the most practical subset
of this material and eliminate the rest.

* Too big: Most books on these topics are at least 500 pages,
and some are more than 1000.  By focusing on the topics I think are
most useful for software engineers, I kept this book under
250 pages.

* Too bottom-up: Many data structures books focus on how data
  structures work (the implementations), with less about how to use
  them (the interfaces).  In this book, I go "top down", starting
  with the interfaces.  Readers learn to use the structures in the
  Java Collections Framework before getting into the details of how
  they work.

Finally, many present this material out of context and without
motivation: it's just one damn data structure after another!

I try to alleviate the boredom by organizing the topics around an
application -- web search -- that uses data structures extensively,
and is an interesting and important topic in its own right.

This application also motivates some topics that are not usually
covered in an introductory data structures class, including persistent
data structures, with Redis, and streaming algorithms.

I have made difficult decisions about what to leave out, but 
I have made some compromises.  I include a few topics
that most readers will never use, but that they might be expected to
know, possibly in a technical interview.  For these topics, I
present both the conventional wisdom as well as my reasons to be
skeptical. 

This book also presents basic aspects of software engineering practice,
including version control and unit testing.  Each chapter ends with
an exercise that allows readers to apply what they have learned.
Each exercise includes automated tests that check the solution.
And for most exercises, I present my solution at the beginning of
the next chapter.

This book is intended for college students in computer science and related
fields, as well as professional software engineers, people training in
software engineering, and people preparing for technical interviews.

I assume that the reader knows Java at an intermediate level,
but I explain some Java features along the way, and provide pointers
to supplementary material.

People who have read *Think Java* or *Head First
Java* are prepared for this book.


## Working with the code

The code in this repository is organized in a way that should make it easy to work with in most Java IDEs.  Below I have detailed instructions for some IDEs; I hope to add more in the future.

### IntelliJ

1.  Decide whether you want to copy the files directly from GitHub, or make your own repository.  If you make your own repository, you will be able to save your work by pushing it back to GitHub.  In a web browser, navigate to [the main page of this repo](https://github.com/AllenDowney/ThinkDataStructures) and press the Fork button in the upper right.

2.  Launch IntelliJ.  From the File menu, select New, then "Project from Version Control", then GitHub.  The first time you do this, you might have to provide your GitHub username and password.  Then window should appear with the title "Clone Repository".

3. Paste in the URL of either my repository, which is `https://github.com/AllenDowney/ThinkDataStructures`, or your copy of my repository, which has your GitHub username instead of mine.  Then press the Clone button.  Your cloned copy of the repository should appear in the navigation window on the left side of the IntelliJ interface.

4. Use the little triangles to open the project directory (probably called `ThinkDataStructures`), then open `code`, then open `src`.  You should see a list of Java sources files.

5. Double-click on `ListClientExample.java`, which is the first example in the book.  The source code should appear in the code window of the IntelliJ interface.

6.  You might see a yellow warning message that says "Project SDK not defined".  If so, there should be a blue link that says "Setup SDK".  Press it.  A window should appear with the title "Select Project SDK".  Assuming that your installation of IntelliJ is working, there should be at least one SDK there.  If Version 1.8 is available, select it.  Otherwise 1.7 is sufficient to run this project.

7. From the `Run` menu, select `Run...`.  If the "Edit configurations" dialog appears, open the `Defaults` list and select `Application`.


4. In the 






Launch IntelliJ and select 
