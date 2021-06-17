// Given a value to find in R0 and a memory address in R1 (>= 2)
// Value of R1 indicates the last position in memory of the values to search through
// Search through RAM[2]-RAM[n] (where n is the value in R1) for the value R0. 
// Value found, R0 = 1. Otherwise, R0 = 0. 

// R[1] value = maximum position of number in R0
// Loop through RAM positions and compare values to R0
// R[i], where i maximum value will be the value of R[1]
// i will be incremented by 1 during each loop


@2
D=A		// D=2
@i
M=D		// Starting with RAM[2]

(loopStart)
@1
D=M		// Getting value of RAM[1]
@i
D=M-D		// Checking loop condition: i-RAM[1]
@notFound
D;JGT	 	// if i>RAM[1] goto notFound
		// else keep looping
@i
A=M
D=M		// D=RAM[i]
@0
D=D-M		// Checking value of RAM[i] and RAM[0]

@found
D;JEQ		// Equality statement, if RAM[i]==D jump to found statement

@i		
M=M+1		// Incrementing i

@loopStart	// Loop again until condition is false
0;JMP		

(found)
@0
M=1		// If found R0=1

(loopEnd)
@loopEnd
0;JMP

(notFound)
@0
M=0		// If not found R0=0

(end)
@end
0;JMP		// Infinite loop to end