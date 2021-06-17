// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/02/MiniALU.tst

load MiniALU.hdl,
output-file MiniALU.out,
compare-to MiniALU.cmp,
output-list a%B1.16.1 b%B1.16.1 f%B1.3.1 out%B1.16.1;

set a %B0000000000000000,
set b %B1111111111111111;

// Compute 0
set f %B000,
eval,
output;

// Compute 1
set f %B001,
eval,
output;

// Compute 2
set f %B010,
eval,
output;

// Compute 4
set f %B100,
eval,
output;

// Compute 5
set f %B101,
eval,
output;

// Compute 6
set f %B110,
eval,
output;

// Compute 7
set f %B111,
eval,
output;

set a %B0000000000010001,
set b %B0000000000000011;

// Compute 0
set f %B000,
eval,
output;

// Compute 1
set f %B001,
eval,
output;

// Compute 2
set f %B010,
eval,
output;

// Compute 4
set f %B100,
eval,
output;

// Compute 5
set f %B101,
eval,
output;

// Compute 6
set f %B110,
eval,
output;

// Compute 7
set f %B111,
eval,
output;
