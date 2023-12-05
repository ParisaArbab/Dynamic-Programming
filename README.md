# Dynamic-Programming:
The process of solving the rod-cutting problem is a technique that is called dynamic programming (DP).


In this project, we analyzed 2 problems of dynamic programming. 
I.	Rod-Cutting problem
II.	Matrix chain multiplication problem


Solving problems
We want to implementing 3 algorithms for each problem. The implementation has done based off pseudocodes in below:

I.	Rod-Cutting problem: 
Rod cutting problem is very much related to any real-world problem we face. You have a rod of some size and you want to cut it into parts and sell in such a way that you get the maximum revenue out of it
The designated programs for this problem accepts n arguments. The program will execute 3 solutions and output 3 lines for one input.

Rod Cutting implementations Time Complexities
 * Naive implementation using recursion ==> Time O(2^n)
 * memoizedCutRod: DP solution using top-down approach ==> Time O(n^2)
 * bottomUpCutRod: DP solution using bottom-up approach ==> Time: O(n^2)

INPUT:
– P is an array of prices, P[i] represents the price of an i-inch rod.
– n is the length of the original array.

OUTPUT:
After running the program, there are 3 lines of returned value by 3 different algorithms, and each algorithm indicates execution time.
Line 1- CUT-ROD ()
Naive implementation using recursion ==> Time O(2^n)

Line 2- MEMOIZED-CUT-ROD ()
The running time of procedure BOTTOM-UP-CUT-ROD is O(n2)

Line 3- BOTTOM-UP-CUT-ROD () 
The running time of procedure BOTTOM-UP-CUT-ROD is O(n2)


II.	Matrix chain multiplication problem:
Matrix chain multiplication is an optimization problem concerning the most efficient way to multiply a given sequence of matrices. The problem is not actually to perform the multiplications, but merely to decide the sequence of the matrix multiplications involved.
This programs accepts n+1 arguments which is the dimension of the matrix. 
There are n matrix to be multiplied.


MatrixChainMultiplication implementations Time Complexities
 * Naive implementation using recursion ==> Time O(2^n)
 * memoizedMatrixChain: DP solution using top-down approach ==> Time O(n^3)
 * bottomUp: DP solution using bottom-up approach ==> Time: O(n^3)

 where n is the total number of matrices.
INPUT:
• Input
–	P is an array of dimensions.
–  i and j are the indexes of the two matrices on the two ends

OUTPUT:
In output, there are three lines, which solve matrix-chain problem with 3 different algorithms that indicates by an element of optimal number of scalar multiplication.

Line 1: RECURSIVE-MATRIX-CHAIN ()
Naive implementation using recursion ==> Time O(2^n)

Line 2: MEMOIZED-MATRIX-CHAIN ()
DP solution using top-down approach ==> Time O(n^3)

Line 3: MATRIX-CHAIN-ORDER ()


What solution are implemented?
For each problem, we implemented 3 different solutions:
o	Straight forward recursive solution (Non- dynamic programming technic)
o	Top-down, memorized solution
o	The bottom-up, dynamic programming solution

At the beginning of each program, ask user to type at least one input, but it designated to enter up to n input value. All these value should be a positive and integer type.


The Result
In cutting-rod problem, the bottom-up algorithm has the less Execution has

In analyzing 3 algorithms for Matrix, chain-order () has less time execution.
We analyze this problem, with data below the graph.
