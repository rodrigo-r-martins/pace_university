/*
Complete the following MPI program to work for 1, 2, 4, 8, 16, 32, 64, 128, … processes by only using the MPI built in function MPI_Recv and MPI_Send. Each process generates a random integers in the range 0-10.

Note: Assume the user enters power of 2 for the numbers of processes.
Note: In my solution I have a nested for-loop with an if-else if to do the major work and after this nested for-loop I have a simple if-statement to print the sum. It is ok if you do not follow my footsteps. However you must use MPI_Send and MPI_Recv.

For: mpiexec -n 128 ./a.out
Output:
9, 8, 2, 2, 0, 0, 7, 6, 8, 4, 0, 8, 7, 0, 1, 9, 5, 6, 4, 5, 0, 0, 1, 2, 6, 4, 0, 3, 6, 3, 3, 0, 9, 7, 7, 8, 7, 9, 3, 5, 4, 1, 3, 1, 6, 1, 8, 1, 7, 8, 7, 6, 3, 1, 0, 2, 5, 2, 7, 5, 3, 6, 1, 9, 6, 5, 4, 9, 3, 1, 0, 0, 8, 0, 8, 4, 5, 7, 5, 2, 2, 2, 4, 8, 0, 2, 6, 2, 9, 5, 2, 7, 8, 9, 5, 3, 1, 9, 8, 2, 8, 6, 5, 6, 7, 5, 7, 7, 6, 7, 9, 2, 1, 7, 4, 1, 3, 5, 1, 6, 3, 4, 4, 8, 6, 8, 0, 6,
Sum = 574
*/

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <mpi.h> 

int main(void) {

	int sum, comm_sz, my_rank, i, next, value;

	MPI_Init(NULL, NULL); 
	MPI_Comm_size(MPI_COMM_WORLD, &comm_sz); 
	MPI_Comm_rank(MPI_COMM_WORLD, &my_rank);
    
	srandom((unsigned)time(NULL) + my_rank);
	sum = random() % 10;
	printf("%d, ", sum);
   
	for (next = 1; next < comm_sz; next *= 2) {
		for (i = 0; i < comm_sz; i += 2*next) {
			if (my_rank == i+next) {
				value = sum;
				MPI_Send(&value, 1, MPI_INT, i, 0, MPI_COMM_WORLD);								
			} else {
				if (my_rank == i) {
					MPI_Recv(&value, 1, MPI_INT, i+next, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
					sum = sum+value;
				}
			}
		}
	}

	if (my_rank == 0) {
		printf("\nSum = %d\n", sum);
	}	
	MPI_Finalize(); 
	return 0;
}


