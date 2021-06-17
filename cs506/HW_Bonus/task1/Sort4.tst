
load Sort4.asm,
output-file Sort4.out,
compare-to Sort4.cmp,
output-list RAM[0]%D2.6.2 RAM[1]%D2.6.2 RAM[2]%D2.6.2 RAM[3]%D2.6.2;

set RAM[0] 1,
set RAM[1] 2,
set RAM[2] 3,
set RAM[3] 4,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 4,
set RAM[1] 3,
set RAM[2] 2,
set RAM[3] 1,
repeat 200 {
  ticktock;
}
output;


set PC 0,
set RAM[0] 0,
set RAM[1] 0,
set RAM[2] 0,
set RAM[3] 0,
repeat 200 {
  ticktock;
}
output;


set PC 0,
set RAM[0] 1,
set RAM[1] 1,
set RAM[2] 1,
set RAM[3] 1,
repeat 200 {
  ticktock;
}
output;


set PC 0,
set RAM[0] -1,
set RAM[1] -1,
set RAM[2] -1,
set RAM[3] -1,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -10,
set RAM[1] 5,
set RAM[2] 100,
set RAM[3] 9,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -25,
set RAM[1] -20,
set RAM[2] -10,
set RAM[3] -30,
repeat 200 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -50,
set RAM[1] 0,
set RAM[2] -15,
set RAM[3] -30,
repeat 200 {
  ticktock;
}
output;
