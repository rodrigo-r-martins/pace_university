/* 
Write a PThread program that uses a Monte Carlo method to estimate PI value.
The main thread shoul read in the total number of tosses and print the estimate.
You may want to use long long ints for the number of hits in the circle and the number of tosses, since both may have to be very large to get a reasonable estimate of PI.
*/


// HEAD DEFINITIONS
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

long long int total_number_of_tosses;		//Total number of tosses
long long int number_in_circle = 0; 		//Each thread is adding its result to this variable.
int thread_count; 							//Number of threads.
pthread_mutex_t hitNum_mutex; 				//To guard the share variable.
void *thread_toss(void* rank); 				//Each thread calls this function.


// MAIN
int main()
{
	double pi_estimate;						//At the end the function main stores the output into this variable and print it.
	long thread; 							//Use as a control variable in a for-loop.
	pthread_t* thread_handles;

	printf("Enter number of threads and the total number of tosses: ");
	scanf("%d%lld", &thread_count, &total_number_of_tosses);
  
	//Using the following loop to make it divisible by thread_count.
	while (total_number_of_tosses % thread_count != 0) 
	{
		total_number_of_tosses++;
	}
  
	//Complete the rest of this function.
	thread_handles = malloc(thread_count*sizeof(pthread_t));
	pthread_mutex_init(&hitNum_mutex, NULL);
	
	for (thread = 0; thread < thread_count; thread++)
	{
		pthread_create(&thread_handles[thread], NULL, thread_toss, (void*) thread);
	}

	for (thread = 0; thread < thread_count; thread++) 
	{
		pthread_join(thread_handles[thread], NULL);
	}

	pthread_mutex_destroy(&hitNum_mutex);
	free(thread_handles);	
	pi_estimate = 4 * number_in_circle / ((double)total_number_of_tosses);
	printf("Estimated pi = %f\n", pi_estimate); 

	return 0;
}



// FUNCTIONS

//Returns a random number in the range -1 to 1.
double rand_double() 
{
	return 2 * (rand() / (double)RAND_MAX) - 1;
}

void *thread_toss(void* rank) {
	//Complete this function
	long toss, i, circle_counter;
	toss = (long)rank;
	double x, y, distance_squared;

	long long my_n = total_number_of_tosses / thread_count;
	long long my_first_i = my_n * toss;
	long long my_last_i = my_first_i + my_n;

	for (i=my_first_i; i<my_last_i; i++)
	{
		x = rand_double();
		y = rand_double();
		distance_squared = x*x + y*y;
		if (distance_squared <= 1)
			circle_counter++;   
	}
	pthread_mutex_lock(&hitNum_mutex);
	number_in_circle += circle_counter;
	pthread_mutex_unlock(&hitNum_mutex);
	return NULL;
}
