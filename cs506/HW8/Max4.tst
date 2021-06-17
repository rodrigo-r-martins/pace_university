
load Max4.asm,
output-file Max4.out,
compare-to Max4.cmp,
output-list RAM[0]%D2.6.2;

set RAM[0] 1,
set RAM[1] 2,
set RAM[2] 3,
set RAM[3] 4,
repeat 100 {
  ticktock;
}
output;

set PC 0,
set RAM[0] 0,
set RAM[1] 0,
set RAM[2] 0,
set RAM[3] 0,
repeat 100 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -10,
set RAM[1] 5,
set RAM[2] 100,
set RAM[3] 9,
repeat 100 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -10,
set RAM[1] 5,
set RAM[2] 9,
set RAM[3] 100,
repeat 100 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -10,
set RAM[1] -20,
set RAM[2] -25,
set RAM[3] -30,
repeat 100 {
  ticktock;
}
output;

set PC 0,
set RAM[0] -50,
set RAM[1] -20,
set RAM[2] -15,
set RAM[3] -30,
repeat 100 {
  ticktock;
}
output;
