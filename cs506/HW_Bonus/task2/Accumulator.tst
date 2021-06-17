load Accumulator.hdl,
output-file Accumulator.out,
compare-to Accumulator.cmp,
output-list time%S1.4.1 XOUT%D1.8.1 SOUT%B1.8.1;

set X 0,
set S 0,
set loadS 1,
set loadX 1,
tick;
output;
tock;
output;

set loadS 0,
set loadX 0,
repeat 25 {
    tick;
    output;
    tock;
    output;
}


