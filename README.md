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
  them (the interfaces).  In this book, I go ``top down'', starting
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
