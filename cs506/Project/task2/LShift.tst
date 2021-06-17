load LShift.hdl,
output-file LShift.out,
compare-to LShift.cmp,
output-list in%D1.16.1 out%D1.16.1;

set in 1,			
eval,
output;

set in -1,			
eval,
output;

set in 2,			
eval,
output;

set in -2,			
eval,
output;

set in %X8000,			
eval,
output;

set in 256,			
eval,
output;

set in -256,			
eval,
output;

set in %XFFF0,			
eval,
output;





