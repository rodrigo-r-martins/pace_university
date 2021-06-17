load PC2.hdl,
output-file PC2.out,
compare-to PC2.cmp,
output-list time%S1.4.1 din%D1.6.1 op%B1.2.1 dout%D1.6.1;

set din 0,
set op 1,

tick,
output;
tock,
output;

set op 2,

repeat 10 {
    tick;
    output;
    tock;
    output;
}

set op 3,

repeat 12 {
    tick;
    output;
    tock;
    output;
}

set din 10000,
set op 1,

tick,
output;
tock,
output;

set op 2,

repeat 20 {
    tick,
    output;
    tock,
    output;
}

set op 0,

repeat 20 {
    tick,
    output;
    tock,
    output;
}

set op 3,

repeat 20 {
    tick,
    output;
    tock,
    output;
}
set op 0,

repeat 20 {
    tick,
    output;
    tock,
    output;
}

set din -10,
set op 1,

tick,
output;
tock,
output;

set op 2,

repeat 12 {
    tick;
    output;
    tock;
    output;
}

set op 3,

repeat 12 {
    tick;
    output;
    tock;
    output;
}

set din 0,
set op 1,
tick,
output;
tock,
output;

set op 3,
repeat 10 {
    tick;
    output;
    tock;
    output;
}

