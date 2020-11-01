# blackboard  

by David Whitehurst

The blackboard model probably came about in 1962 when Allen Newell put these words to
paper, "metaphorically we can think of a set of workers, all looking at the same
blackboard: each is able to read everything that is on it, and to judge when he has 
something worthwhile to add to it. This conception is just that of Selfridge's pandemonium: 
a set of demons, each independently looking at the total situation and shrieking in 
proportion to what they see that fits their natures[1].

The blackboard model is a problem solving model where the management of knowledge sources
is organized and controlled by a mix of hierarchical and opportunistic suggestions. This
opportunistic reasoning is not predictable.  If outcomes could be predicted, the blackboard
model could have been an evolutionary computational specification. The blackboard model
has been a conceptual entity and very difficult to model as a computer system[2].

The blackboard project is an attempt to model and implement a working solution to a 
cryptogram or coded sentence problem using Newell's concept of the blackboard model. The
specific problem and larger portion of the high-level design is that of Grady Booch[3]. 
Booch's design uses C++ snippets to describe UML designs, however this project will use
Java for implementation.

The example cryptogram is a grammatically correct sentence, however the cipher letters have 
corresponding alphabets that replace or decode this sentence into a sensible english 
statement. While the author outlines the problem using C++ classes and methods, he does
not completely solve the problem or provide specific code implementations. A similar problem 
was implemented in the early 70's called HEARSAY.

The cryptogram is "Q AZWS DSSC KAS DXZNN DASNN" ... 
and the solution is "I HAVE SEEN THE SMALL SHELL".

Try solving the cryptogram by hand, and note your methods wisely.  It's not easy but if 
you can solve it with a computer program, please share your code.  I'd love to see it.

A hint is given by Booch to start the knowledge source suggestions. The cipher letter W 
is a plaintext V. 

David L. Whitehurst  (August 30, 2010)


REFERENCES:

[1] Newell, Allen (1962) Some problems of basic organization in problem solving programs. In
    M.C. Yovits, G.T. Jacobi, & G.D. Goldstein (Eds.), Conference on Self-Organizing Systems.
    Washington D.C.: Spartan Books, 393-423
    
[2] Nii, Penny Summer (1986). Blackboard Systems: The Blackboard Model of Problem Solving and
    the Evolution of Blackboard Architectures. AI Magazine Vol. 7, No. 2
    
[3] Booch, Grady (1994) Object Oriented Analysis and Design with Applications, Second Edition. 
    Menlo Park, California: Addison-Wesley, 413-444
