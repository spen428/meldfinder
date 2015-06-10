MeldFinder
==========

A small program that I hacked together in order to attempt to find legal
hands from within an arbitrary set of random mahjong tiles. It's nowhere near
as efficient as it could be, but it does the job!

Used to verify the solution to the mathematical problem:

> "What is the minimum number of *random* mahjong tiles required to guarantee
> that at least one legal hand of 14 tiles can be formed from the tiles?"

The answer - like the answer to the ultimate question of life, the universe
and everything - appears to be 42 (136-94), which is immensely satisfying.

Requirements
---
* Apache Ant
* JDK 1.7+

Build & Run
---
To build the project, call `ant` from root of the project folder.
To run, call `java -jar dist/MeldFinder.jar`.

Changing parameters requires modification of the source code itself, as no 
arguments can be passed to the executable. It may therefore be more benefitial
to run this program from within an Integraded Development Environment.

Licence
---
Licenced under the MIT open source licence. See the LICENCE file for details.

