"""
In this program we will look at predicting the winner of sports matches using a different type of classification algorithm: decision trees.
Advantages of decision trees:
a) They are readable by human, allowing for their use in human-driven decision making.
b) They work with a variety of features, including categorical.
We will look at predicting the winner of games of the NBA using an entry level basketball match prediction algorithm.
"""
import pandas as pd
data_filename = "basketball.csv"
dataset = pd.read_csv(data_filename)

print('===== PRINTING FIRST FIVE ROWS =====')
print(dataset.head(5))
print('')


# Changing the headings after loading the file
dataset = pd.read_csv(data_filename, parse_dates=["Date"])
dataset.columns = ["Date", "Start (ET)", "Visitor Team", "VisitorPts", "Home Team", "HomePts", "OT?", "Score Type", "Attend.", "Notes"]

print('===== PRINTING FIRST FIVE ROWS AGAIN TO CHECKING CHANGES =====')
print(dataset.head(5))
print('')

print('===== DATA TYPES OF THE DATA =====')             # Checking the data type of the data
print(dataset.dtypes)
print('')


# Specifying class value as 1 if the home team wins and 0 if the visitor team wins
dataset["HomeWin"] = dataset["VisitorPts"] < dataset["HomePts"]
y_true = dataset["HomeWin"].values      # Extracting the values to use with scikit-learn

print('===== CHECKING HOME TEAM ADVANTAGE =====')
print(dataset["HomeWin"].mean())        # Checking home team advantage
print('')


# Creating feature to check if the two teams won their previous game, so we check if they are playing well
from collections import defaultdict

won_last = defaultdict(int)             # Dictionary will be used to store the team's last result
dataset["HomeLastWin"] = 0              # Creating new features into dataset to store the results of our new features
dataset["VisitorLastWin"] = 0

for index, row in dataset.iterrows():
    home_team = row["Home Team"]
    visitor_team = row["Visitor Team"]
    row["HomeLastWin"] = won_last[home_team]
    dataset.at[index, "HomeLastWin"] = won_last[home_team]
    dataset.at[index, "VisitorLastWin"] = won_last[visitor_team]
    won_last[home_team] = int(row["HomeWin"])
    won_last[visitor_team] = 1 - int(row["HomeWin"])

print('====== PRINTING FIRST SIX ROWS TO CHECK INCLUSIONS =====')
print(dataset.head(6))
print('')

print('===== PRINTING OTHER PART OF DATASET TO CHECK INCLUSIONS =====')
print(dataset.loc[1000:1005])           # Check last columns to see example of home team and visitor team that won their recent game
print('')


# Importing tools to create a decision tree
from sklearn.tree import DecisionTreeClassifier
clf = DecisionTreeClassifier(random_state=14)

X_previouswins = dataset[["HomeLastWin", "VisitorLastWin"]].values      # Extracting the values of dataset
print('===== CHECKING PREVIOUSWINS DATA VALUES =====')
print(X_previouswins)          # Checking data values
print('')

# Since decision trees are estimators, they have fit and predict methods. Using cross_val_score we can get the average score
from sklearn.model_selection import cross_val_score
import numpy as np

scores = cross_val_score(clf, X_previouswins, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY BASED ON PREVIOUS WINS =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')


"""
Using two features to get better results and answer the following questions:
1) Which team is considered better generally? 
    - A team will be considered better if it ranked higher in last season than other team.
2) Which team won their last encounter?

Obtaining the standings data to perform is the first step.
"""
import os

standing_filename = os.path.join("standings.csv")
standings = pd.read_csv(standing_filename, skiprows=1)
print('===== PRINTING STANDINGS FIVE FIRST ROW =====')
print(standings.head())
print('')

# Creating a feature similar to the previous to get standings for home team and visitor team
dataset["HomeTeamRanksHigher"] = 0

for index, row in dataset.iterrows():
    home_team = row["Home Team"]
    visitor_team = row["Visitor Team"]
    home_rank = standings[standings["Team"] == home_team]["Rk"].values[0]
    visitor_rank = standings[standings["Team"] == visitor_team]["Rk"].values[0]
    row["HomeTeamRanksHigher"] = int(home_rank > visitor_rank)
    dataset.at[index, "HomeTeamRanksHigher"] = int(home_rank < visitor_rank)

# Using cross_val_score to test the result
X_homehigher = dataset[["HomeLastWin", "VisitorLastWin", "HomeTeamRanksHigher"]].values
print('===== CHECKING HOMEHIGHER DATA VALUES =====')
print(X_homehigher)             # Checking data values
print('')

# Creating a new decision tree classifier to run the evaluation
clf = DecisionTreeClassifier(random_state=14)
scores = cross_val_score(clf, X_homehigher, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY BASED ON HIGHER RANK AND PREVIOUS WINS =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')


# Creating a dictionary to store the winner of the past game and creating a new feature in the dataframe
last_match_winner = defaultdict(int)
dataset["HomeTeamWonLast"] = 0

for index, row in dataset.iterrows():
    home_team = row["Home Team"]
    visitor_team = row["Visitor Team"]
    # Sort for a consistent ordering
    teams = tuple(sorted([home_team, visitor_team]))
    # Set in the row who won the last encounter
    home_team_won_last = 1 if last_match_winner[teams] == row["Home Team"] else 0
    dataset.at[index, "HomeTeamWonLast"] = home_team_won_last
    # Who won this one?
    winner = row["Home Team"] if row["HomeWin"] else row["Visitor Team"]
    last_match_winner[teams] = winner

# Evaluating the result
X_lastwinner = dataset[["HomeTeamWonLast", "HomeTeamRanksHigher", "HomeLastWin", "VisitorLastWin"]].values
print('===== CHECKING LASTWINNER DATA VALUES =====')
print(X_lastwinner)             # Checking data values
print('')

clf = DecisionTreeClassifier(random_state=14, criterion="entropy")
scores = cross_val_score(clf, X_lastwinner, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY BASED ON HIGHER RANK, PREVIOUS WINS AND LAST ENCOUNTER WINS =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')


# Then check what happens if a lot of data is thrown at the Decision Tree and see it can learn an effective model.
# Converting string-based team names into assigned integer values
from sklearn.preprocessing import LabelEncoder

encoding = LabelEncoder()
encoding.fit(dataset["Home Team"].values)
home_teams = encoding.transform(dataset["Home Team"].values)
visitor_teams = encoding.transform(dataset["Visitor Team"].values)
X_teams = np.vstack([home_teams, visitor_teams]).T

# Transforming those integers into a number of binary features
from sklearn.preprocessing import OneHotEncoder

onehot = OneHotEncoder()
X_teams = onehot.fit_transform(X_teams).todense()
print('===== CHECKING TEAMS NAMES TRANSFORMED =====')
print(X_teams)             # Checking data values
print('')

# Running decision tree on the new dataset
clf = DecisionTreeClassifier(random_state=14)
scores = cross_val_score(clf, X_teams, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY OF DECISION TREE WITH NEW INFORMATION =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')


# Testing Random Forests algorithm to get accuracy
from sklearn.ensemble import RandomForestClassifier

clf = RandomForestClassifier(random_state=14)
scores = cross_val_score(clf, X_teams, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY USING RANDOM FORESTS =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')

# Using subsets of the features with Random Forests
X_all = np.hstack([X_lastwinner, X_teams])
clf = RandomForestClassifier(random_state=14)
scores = cross_val_score(clf, X_all, y_true, scoring='accuracy')
print('===== CHECKING ACCURACY USING SUBSETS OF FEATURES WITH RANDOM FORESTS =====')
print(f'Accuracy: {np.mean(scores)*100:.1f}%')
print('')


# Testing GridSearchCV algorithm to get accuracy
from sklearn.model_selection import GridSearchCV

parameter_space = {
    "max_features": [2, 10, 'auto'],
    "n_estimators": [100, 200],
    "criterion": ["gini", "entropy"],
    "min_samples_leaf": [2, 4, 6],
}
clf = RandomForestClassifier(random_state=14)
grid = GridSearchCV(clf, parameter_space)
grid.fit(X_all, y_true)
print('===== CHECKING ACCURACY USING GRID SEARCH CV =====')
print(f'Accuracy: {grid.best_score_*100:.1f}%')
print('')

# Checking best model found in the grid search
print('===== PRINTING THE BEST ESTIMATOR =====')
print(grid.best_estimator_)
print('')






