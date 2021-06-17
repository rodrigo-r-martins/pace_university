
// HEAD DEFINITIONS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>


// MAIN
int main()
{
	int thread_count; 				//Number of threads.
	long long int number_of_tosses;			//Total number of tosses
	int i;
	double x, y, distance_squared;
	long long int number_in_circle = 0; 		//Each thread is adding its result to this variable
	double pi_estimate;				//At the end the function main stores the output into this variable and print it.
	
	srandom((long)time(NULL));

	printf("Enter number of threads and the total number of tosses: ");
	scanf("%d%lld", &thread_count, &number_of_tosses);
	
	//Using the following loop to make it divisible by thread_count.
	while (number_of_tosses % thread_count != 0) 
	{
		number_of_tosses++;
	}

	#pragma omp parallel for num_threads(thread_count) reduction(+: number_in_circle) private(x, y, distance_squared)
	for (i = 0; i < number_of_tosses; i++) 
	{
		x = 2 * (double)random() / (double)RAND_MAX - 1;
		y = 2 * (double)random() / (double)RAND_MAX - 1;
		distance_squared = x*x + y*y;
		if (distance_squared <= 1)
		{	
			number_in_circle++;
		}	   	
	}

	pi_estimate = 4 * number_in_circle / ((double)number_of_tosses);
	printf("Estimated pi = %f\n", pi_estimate); 

	return 0;
}