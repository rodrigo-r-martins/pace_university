// Find the largest value in R0-R3 and store result in R0 (RAM[0])


// Checking value of RAM[0]
@0
D=M		// D = RAM[0]

// Checking value of RAM[1]
@1
D=D-M		// D = D-RAM[1]	
D;JGE		// If D >= 0 

@1		// If condition is false (D=negative):
D=M		// D=RAM[1], and
@0
M=D		// RAM[0] = D, value of RAM[1]

// Checking value of RAM[2]
@2
D=D-M		// D = D-RAM[2]
D;JGE		// If D >= 0 

@2		// If condition is false (D=negative):
D=M		// D=RAM[2], and
@0
M=D		// RAM[0] = D, value of RAM[2]

// Checking value of RAM[3]
@3
D=D-M		// D = D-RAM[3]
D;JGE		// If D >= 0 

@3		// If condition is false (D=negative):
D=M		// D=RAM[3]
@0
M=D		// RAM[0]=D, value of RAM[3]

// Loop to end program
(end)
@end
0;JMP