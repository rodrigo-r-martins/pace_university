// Sort4 - Assign numbers in order from lowest to highest

(loop)
@0
D=M		// D=R0
@1
D=D-M		// D=R0-R1

@checkR2
D;JLE		// If D is negative, goto checkR2 and check R2, 
		// else, change positions of R0 and R1 because R0>R1:
@1
D=M		// D=R1
@temp
M=D		// temp=D	
@0
D=M		// D=R0
@1
M=D		// R1=D -> assigning value of R0 to R1
@temp
D=M		// D=temp
@0
M=D		// R0=D	-> assigning value of R1 to R0
		// Now R0 < R1

(checkR2)	// R0 < R1, so I jump to check R1 and R2
@1
D=M		// D=R1
@2
D=D-M		// D=R1-R2
@checkR3
D;JLE		// If D is negative, goto checkR3 and check R3,
		// else, change positions of R1 and R2 because R1>R2:

@2
D=M		// D=R2
@temp
M=D		// temp=D
@1
D=M		// D=R1
@2
M=D		// R2=D -> assigning value of R1 to R2
@temp
D=M		// D=temp
@1
M=D		// R1=D -> assigning value of R2 to R1
		// Now R1 < R2

(checkR3)	// R1 < R2, so I jump to check R2 and R3
@2		
D=M		// D=R2
@3
D=D-M		// D=R2-R3
@loopCheck
D;JLE		// If D is negative, goto loopCheck and loop again until numbers are sorted,
		// else, change positions of R2 and R3 because R2>R3:
@3
D=M		// D=R3
@temp
M=D		// temp=D
@2
D=M		// D=R2
@3
M=D		// R3=D -> assigning value of R2 to R3
@temp
D=M		// D=temp
@2
M=D		// R2=D -> assigning value of R3 to R2
		// Now R2 < R3

(loopCheck)
@loop		// goto loop

0;JMP		// Infinite loop to end