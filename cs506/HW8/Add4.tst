
load Add4.asm,
output-file Add4.out,
compare-to Add4.cmp,
output-list RAM[0]%D2.6.2;

set RAM[0] 1,
set RAM[1] 2,
set RAM[2] 3,
set RAM[3] 4,
repeat 30 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 0,
set RAM[1] 0,
set RAM[2] 0,
set RAM[3] 0,
repeat 30 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -10,
set RAM[1] 5,
set RAM[2] 100,
set RAM[3] 9,
repeat 30 {
  ticktock;
}
output;
