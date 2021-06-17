
load Search.asm,
output-file Search.out,
compare-to Search.cmp,
output-list RAM[0]%D2.6.2;

set RAM[0] 0,
set RAM[1] 4,
set RAM[2] 1,
set RAM[3] 1,
set RAM[4] 1,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 0,
set RAM[1] 4,
set RAM[2] 1,
set RAM[3] 1,
set RAM[4] 0,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 0,
set RAM[1] 4,
set RAM[2] 1,
set RAM[3] 1,
set RAM[4] 1,
set RAM[5] 0,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 5,
set RAM[1] 6,
set RAM[2] 5,
set RAM[3] 1,
set RAM[4] 5,
set RAM[5] 0,
set RAM[6] 10,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 5,
set RAM[1] 6,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 0,
set RAM[6] 10,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 2,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 0,
set RAM[6] 10,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 2,
set RAM[2] 8,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 0,
set RAM[6] 10,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 10,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 0,
set RAM[6] 10,
set RAM[7] 9,
set RAM[8] -20,
set RAM[9] -10,
set RAM[10] 0,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 10,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 8,
set RAM[6] 10,
set RAM[7] 9,
set RAM[8] -20,
set RAM[9] -10,
set RAM[10] 0,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 10,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 0,
set RAM[6] 10,
set RAM[7] 9,
set RAM[8] -20,
set RAM[9] -10,
set RAM[10] 8,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 10,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 5,
set RAM[6] 10,
set RAM[7] 9,
set RAM[8] -20,
set RAM[9] -10,
set RAM[10] 0,
set RAM[11] 8,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 8,
set RAM[1] 10,
set RAM[2] 0,
set RAM[3] 1,
set RAM[4] -5,
set RAM[5] 5,
set RAM[6] 10,
set RAM[7] 9,
set RAM[8] -20,
set RAM[9] -10,
set RAM[10] 0,
set RAM[11] 7,
set RAM[12] 8,
repeat 200 {
  ticktock;
}
output;
