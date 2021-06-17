// Add four numbers (found in R0, R1, R2 and R3) 
// and store result in RAM[0] (a.k.a. R0)

@0
D=M	// D = RAM[0]
@1
D=D+M	// D = D+RAM[1]
@2
D=D+M	// D = D+RAM[2]
@3
D=D+M	// D = D+RAM[3]
@0
M=D	// RAM[0] = D

(end)
@end	// loop to end program
0;JMP
