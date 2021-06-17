"""
In this program we will look at affinity analysis which determines when objects occur frequently together.
The aim is to discover when objects occur simultaneously.
In a case where we wish to work out when two movies are recommended by the same reviewers.
Then we simply rank the results and choose the recommendations.
We will do it using the algorithm for affinity analysis called Apriori algorithm.
"""

import os
import pandas as pd
data_folder = os.path.join(os.path.expanduser("~"), "OneDrive", "Desktop", "Pace", "CS619", "Chapter04", "ml-100k")
ratings_filename = os.path.join(data_folder, "u.data")

# Making changes into datafile since it is separated by tabs, not commas, and there is no heading line.
# Setting delimiter parameter to tab character, not reading first row as header and setting column names.
all_ratings = pd.read_csv(ratings_filename, delimiter="\t", header=None, names=["UserID", "MovieID", "Rating", "Datetime"])

# Parsing dates for reviews
all_ratings["Datetime"] = pd.to_datetime(all_ratings["Datetime"], unit='s')

# Reviewing first records
print('===== PRINTING FIRST RECORDS =====')
print(all_ratings.head())
print('')

# Getting description of data
print('===== PRINTING DATASET DESCRIPTION =====')
print(all_ratings.describe())
print('')

"""
The goal here is to produce rule of the form: "if a person recommends the set of movies, they will also recommend this movie"
It will also be discussed extensions where a person who recommends a set of movies is likely to recommend another particular movie.
"""

# First of all, determining if a person recommends a movie
all_ratings["Favorable"] = all_ratings["Rating"] > 3

# Checking new feature
print('===== CHECKING NEW FEATURE =====')
print(all_ratings[10:15])
print('')

# Sampling the dataset to form training data by obtaining all reviews from the first 200 users
ratings = all_ratings[all_ratings["UserID"].isin(range(200))]

# Next, creating a dataset of only the favorable reviews in our sample
favorable_ratings_mask = ratings["Favorable"]
favorable_ratings = ratings[favorable_ratings_mask]

# Grouping the dataset by UserID and iterating over the movies in each group to get which one user has given favorable rating
favorable_reviews_by_users = dict((k, frozenset(v.values)) for k, v in favorable_ratings.groupby("UserID")["MovieID"])

# Finally, creating a dataframe that tell how frequently each movie has been given a favorable review
num_favorable_by_movie = ratings[["MovieID", "Favorable"]].groupby("MovieID").sum()

# Checking top five movies
print('===== CHECKING TOP FIVE MOVIES =====')
print(num_favorable_by_movie.sort_values(by="Favorable", ascending=False).head())
print('')

# Creating a dictionary to store discovered frequent itemsets where the key is the length of the itemsets
frequent_itemsets = {}

# Setting a minumum support value to be considered frequent
min_support = 50

# First step of Apriori:
# - Creating an itemset with each movie and test if the itemset is frequent
frequent_itemsets[1] = dict((frozenset((movie_id,)), row["Favorable"])
                           for movie_id, row in num_favorable_by_movie.iterrows()
                           if row["Favorable"] > min_support)

# Second and Third steps of Apriori:
# - Creating a function that takes the newly discovered frequent itemsets, creates the supersets, and then tests if they are frequent
from collections import defaultdict


def find_frequent_itemsets(favorable_reviews_by_users, k_1_itemsets, min_support):
    counts = defaultdict(int)
    for user, reviews in favorable_reviews_by_users.items():
        for itemset in k_1_itemsets:
            if itemset.issubset(reviews):
                for other_reviewed_movie in reviews - itemset:
                    current_superset = itemset | frozenset((other_reviewed_movie,))
                    counts[current_superset] += 1
    return dict([(itemset, frequency) for itemset, frequency in counts.items()
                if frequency >= min_support])


# Creating a loop that iterates over the steps of the algorithm, storing the new itemsets as k is increased from 1 to max value
import sys          # We will get an error if we don't import this library because we need to use sys.stdout.flush()

print('===== GETTING THE NUMBER OF FREQUENCY ITEMSETS OF EACH LENGTH =====')
for k in range(2, 20):
    # Generate candidates of length k, using the frequent itemsets of length k-1
    # Only store the frequent itemsets
    cur_frequent_itemsets = find_frequent_itemsets(favorable_reviews_by_users, frequent_itemsets[k-1], min_support)
    if len(cur_frequent_itemsets) == 0:
        print(f'Did not find any frequent itemsets of length {k}')
        sys.stdout.flush()
        break
    else:
        print(f'I found {len(cur_frequent_itemsets)} frequent itemsets of length {k}')
        sys.stdout.flush()
        frequent_itemsets[k] = cur_frequent_itemsets
print('')

# Generating a number of association rules by setting each movie to be the conclusion and the remaining as the premise
candidate_rules = []
for itemset_length, itemset_counts in frequent_itemsets.items():
    for itemset in itemset_counts.keys():
        for conclusion in itemset:
            premise = itemset - set((conclusion,))
            candidate_rules.append((premise, conclusion))

# Checking first five rules created
print('===== CHECKING FIRST FIVE RULES CREATED =====')
print(candidate_rules[:5])
print('')

# Computing confidence:
# - Creating dictionaries to store how many times we see the premise leading to the conclusion and how many times it doesn't
# - Then iterating over all reviews and rules, working out whether the premise of the rule applies and, if it does, whether the conclusion is accurate
correct_counts = defaultdict(int)
incorrect_counts = defaultdict(int)

for user, reviews in favorable_reviews_by_users.items():
    for candidate_rule in candidate_rules:
        premise, conclusion = candidate_rule
        if premise.issubset(reviews):
            if conclusion in reviews:
                correct_counts[candidate_rule] += 1
            else:
                incorrect_counts[candidate_rule] += 1

# Computing confidence for each rule
rule_confidence = {candidate_rule:
                   (correct_counts[candidate_rule] / float(correct_counts[candidate_rule] + incorrect_counts[candidate_rule])) for candidate_rule in candidate_rules}

# Printing top five rules
from operator import itemgetter

sorted_confidence = sorted(rule_confidence.items(), key=itemgetter(1), reverse=True)
print('===== PRINTING TOP FIVE RULES =====')
for index in range(5):
    print(f'Rule #{index+1}')
    premise, conclusion = sorted_confidence[index][0]
    print(f'Rule: If a person recommends {premise} they will also recommend {conclusion}')
    print(f'- Confidence: {rule_confidence[(premise, conclusion)]:.3f}')
    print('')
print('')

# Loading dataset that stores the movie names and their corresponding MovieID to show the result
movie_name_filename = os.path.join(data_folder, "u.item")
movie_name_data = pd.read_csv(movie_name_filename, delimiter="|", header=None, encoding="mac-roman")
movie_name_data.columns = ["MovieID", "Title", "Release Date", "Video Release", "IMDB", "<UNK>", "Action", "Adventure",
                           "Animation", "Children's", "Comedy", "Crime", "Documentary", "Drama", "Fantasy", "Film-Noir",
                          "Horror", "Musical", "Mistery", "Romance", "Sci-Fi", "Thriller", "War", "Western"]

# Creating a function that returns a movie's title from its MovieID


def get_movie_name(movie_id):
    title_object = movie_name_data[movie_name_data["MovieID"] == movie_id]["Title"]
    title = title_object.values[0]
    return title


# Printing top five rules including movie titles
print('===== PRINTING TOP FIVE RULES INCLUDING MOVING TITLES =====')
for index in range(5):
    print(f'Rule #{index+1}')
    premise, conclusion = sorted_confidence[index][0]
    premise_names = ", ".join(get_movie_name(idx) for idx in premise)
    conclusion_name = get_movie_name(conclusion)
    print(f'Rule: If a person recommends {premise_names} they will also recommend {conclusion_name}')
    print(f'- Confidence: {rule_confidence[(premise, conclusion)]:.3f}')
    print('')
print('')

# Extracting test dataset which is all of the records we didn't use in training set (first 200 users)
test_dataset = all_ratings[~all_ratings["UserID"].isin(range(200))]
test_favorable = test_dataset[test_dataset["Favorable"]]
test_favorable_by_users = dict((k, frozenset(v.values))
                               for k, v in test_favorable.groupby("UserID")["MovieID"])

# Counting correct instances where the premise leads to the conclusion using test dataset
correct_counts = defaultdict(int)
incorrect_counts = defaultdict(int)
for user, reviews in test_favorable_by_users.items():
    for candidate_rule in candidate_rules:
        premise, conclusion = candidate_rule
        if premise.issubset(reviews):
            if conclusion in reviews:
                correct_counts[candidate_rule] += 1
            else:
                incorrect_counts[candidate_rule] += 1

# Computing the confidence of each rule from the correct counts
test_confidence = {candidate_rule:
                  (correct_counts[candidate_rule] / float(correct_counts[candidate_rule] + incorrect_counts[candidate_rule])) for candidate_rule in rule_confidence}
sorted_test_confidence = sorted(test_confidence.items(), key=itemgetter(1), reverse=True)

# Printing the best association rules with the titles instead of movie IDs
print('===== PRINTING THE BEST ASSOCIATION RULES WITH MOVIE TITLES =====')
for index in range(10):
    print(f'Rule #{index+1}')
    premise, conclusion = sorted_confidence[index][0]
    premise_names = ", ".join(get_movie_name(idx) for idx in premise)
    conclusion_name = get_movie_name(conclusion)
    print(f'Rule: If a person recommends {premise_names} they will also recommend {conclusion_name}')
    print(f'- Train Confidence: {rule_confidence.get((premise, conclusion), -1):.3f}')
    print(f'- Test Confidence: {test_confidence.get((premise, conclusion), -1):.3f}')
    print('')
print('')
