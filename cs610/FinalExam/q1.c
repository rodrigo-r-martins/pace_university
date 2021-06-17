#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <mpi.h>

int main ()
{
	int rank, size;
	long long int number_of_tosses;
	long long int number_in_circle = 0;
	long long int sum=0;
	long long int toss;
	double pi_estimate;
	double x, y, distance_squared;
    
	MPI_Init (NULL, NULL);
	MPI_Comm_rank (MPI_COMM_WORLD, &rank);
	MPI_Comm_size (MPI_COMM_WORLD, &size);
	srandom((unsigned)time(NULL) + rank);

	if (rank == 0) 
	{
		printf("Enter number of tosses: ");
		scanf("%lld", &number_of_tosses);
	}

	if (number_of_tosses % size != 0)
	{
        	number_of_tosses = ((number_of_tosses + size - 1) / size) * size;
	}

	MPI_Bcast(&number_of_tosses, 1, MPI_LONG_LONG_INT, 0, MPI_COMM_WORLD);

	for (toss = 0; toss < number_of_tosses / size; toss++)
	{
		x = 2 * (double)random() / (double)RAND_MAX - 1;
		y = 2 * (double)random() / (double)RAND_MAX - 1;		
		distance_squared = x*x + y*y;
		if (distance_squared <= 1)
		{	
			number_in_circle++;
		}
	}
	
	MPI_Reduce(&number_in_circle, &sum, 1, MPI_LONG_LONG_INT, MPI_SUM, 0, MPI_COMM_WORLD);	//Sum of all number_in_circle
    
	if (rank == 0)
	{
		pi_estimate = 4 * ((double)sum) / ((double)number_of_tosses);
		printf("Estimated pi = %f\n", pi_estimate);
	}
    
	MPI_Finalize();
}