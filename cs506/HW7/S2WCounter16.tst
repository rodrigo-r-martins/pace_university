load S2WCounter16.hdl,
output-file S2WCounter16.out,
compare-to S2WCounter16.cmp,
output-list time%S1.4.1 in%D1.6.1 op%B1.2.1 out%D1.6.1;

set in 0,
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

set in 10000,
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

set in -10,
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

set in 0,
set op 1,
tick,
output;
tock,
output;

set op 3,
repeat 255 {
    tick;
    output;
    tock;
    output;
}

