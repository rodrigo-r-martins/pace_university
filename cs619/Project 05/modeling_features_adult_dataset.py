"""
In this program we will use Adult dataset as example of taking a complex reality and attempting to model it using features.
The aim is to estimate if someone earns more than $50,000 per year.
"""

# Loading the dataset
import os
import pandas as pd
data_folder = os.path.join(os.path.expanduser("~"), "OneDrive\Desktop\Pace\CS619\Chapter05\Data")
adult_filename = os.path.join(data_folder, "adult.data")
adult = pd.read_csv(adult_filename, header=None, names=["Age", "Work-Class", "fnlwgt", "Education", "Education-Num", 
                                                        "Marital-Status", "Ocupation", "Relationship", "Race", "Sex", 
                                                       "Capital-gain", "Capital-loss", "Hours-per-week", "Native-Country", 
                                                       "Earnings-Raw"])

adult.dropna(how='all', inplace=True)   # Removing blank lines or invalid numbers

print('===== CHECKING DATASET =====')
print(adult.columns)                    # Having a look at the columns of dataset
print('')

print('===== CHECKING FIRST FIVE ROWS OF DATASET =====')
print(adult.head())
print('')

print('===== CHECKING BASIC SUMMARY STATS OF DATA =====')
print(adult['Hours-per-week'].describe())      # Using describe function to get basic summary stats of the data
print('')

# Creating an approximation of Education feature using Education-Num (number of years) by taking the mean value
print('===== TAKING MEAN VALUE OF EDUCATION-NUM FEATURE =====')
print(adult['Education-Num'].median())
print('')

# Checking unique values of categorical feature Work-Class
print('===== CHECKING UNIQUE VALUES OF WORK-CLASS FEATURE =====')
print(adult['Work-Class'].unique())
print('')

# Checking frequency of each value of feature Work-Class
print('===== CHECKING FREQUENCY OF EACH VALUE OF WORK-CLASS FEATURE =====')
print(adult['Work-Class'].value_counts())
print('')

# Creating swarm plot to visualise relation between education and hours-worked
import seaborn as sns
from matplotlib import pyplot as plt
sns.swarmplot(x='Education-Num', y='Hours-per-week', hue='Earnings-Raw', data=adult[::50])    # Showing every 50 rows
plt.show()

# Creating another feature that tell if a person works more than 40 hours per week
# This turns the continuous feature Hours-per-week into a categorical one that is True or False depending on number of hours
adult['LongHours'] = adult['Hours-per-week'] > 40
print('===== CHECKING DATASET WITH NEW FEATURE =====')
print(adult.head(10))
print('')

# Using VarianceThreshold transformer to remove any feature that doesn't have at least a minimum level of variance in the values
import numpy as np
X = np.arange(30).reshape((10,3))

# Checking dataset
print('===== CHECKING DATASET =====')
print(X)
print('')

# Setting entire second column/feature to the value 1
X[:,1] = 1

# Checking changes
print('===== CHECKING DATASET WITH CHANGES =====')
print(X)
print('')

# Creating VarianceThreshold transformer and applying to the dataset created
from sklearn.feature_selection import VarianceThreshold
vt = VarianceThreshold()
Xt = vt.fit_transform(X)

# Checking dataset after transformation
print('===== CHECKING DATASET AFTER TRANSFORMATION WITH VARIANCETHRESHOLD =====')
print(Xt)
print('')

# Checking variances for each column
print('===== CHECKING VARIANCES FOR EACH COLUMN =====')
print(vt.variances_)
print('')

# Testing single-feature correlation with a class value using method chi-squared and transformer SelectKBest

# Getting selection of features
X = adult[['Age', 'Education-Num', 'Capital-gain', 'Capital-loss', 'Hours-per-week']].values
print('===== PRINTING THE SELECTION OF FEATURES VALUES =====')
print(X)
print('')

# Creating a target class array by testing whether the Earnings-Raw value is above $50,000 or not
y = (adult['Earnings-Raw'] == ' >50K').values
print('===== PRINTING THE CLASS ARRAY =====')
print(y)
print('')

# Creating transformer using chi2 and selectKBest transformer
from sklearn.feature_selection import SelectKBest
from sklearn.feature_selection import chi2
transformer = SelectKBest(score_func=chi2, k=3)

# Running fit_transform to create new dataset choosing only the best three features
Xt_chi2 = transformer.fit_transform(X, y)

print('===== PRINTING NEW DATASET WITH CHI2 =====')
print(transformer.scores_)
print('')

# Implementing other correlation such as Pearson correlation coefficient
from scipy.stats import pearsonr


def multivariate_pearsonr(X, y):
    # Defining a function that allow the use of multivariate arrays like the one we have
    scores, pvalues = [], []
    for column in range(X.shape[1]):
        # Compute the Pearson correlation for this column only
        cur_score, cur_p = pearsonr(X[:,column], y)
        # Record both the score and p-value
        scores.append(abs(cur_score))
        pvalues.append(cur_p)
    return (np.array(scores), np.array(pvalues))


# Using the transformer class as before to rank the features using the Pearson correlation coefficient
transformer = SelectKBest(score_func=multivariate_pearsonr, k=3)
Xt_pearson = transformer.fit_transform(X, y)
print('===== PRINTING TRANSFORMER SCORES OF DATASET =====')
print(transformer.scores_)
print('')

# Running features through classifier to see which one is better
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_val_score
clf = DecisionTreeClassifier(random_state=14)
scores_chi2 = cross_val_score(clf, Xt_chi2, y, scoring='accuracy')
scores_pearson = cross_val_score(clf, Xt_pearson, y, scoring='accuracy')

print('===== GETTING FEATURES CLASSIFIER RESULTS =====')
print(f'Chi2 score: {scores_chi2.mean():.2f}')
print(f'Pearson score: {scores_pearson.mean():.2f}')
print('')

# Implementing a Transformer by creating a class and two method for:
# Get the mean for each feature in the fit method
# Return which values are more than the mean for a given feature in the transform method
from sklearn.base import TransformerMixin
from sklearn.utils import as_float_array


class MeanDiscrete(TransformerMixin):
    def fit(self, X, y=None):
        X = as_float_array(X)
        self.mean = X.mean(axis=0)
        return self
    
    def transform(self, X, y=None):
        X = as_float_array(X)
        assert X.shape[1] == self.mean.shape[0]
        return X > self.mean


mean_discrete = MeanDiscrete()
X_mean = mean_discrete.fit_transform(X)

# Checking the mean of Xt variable
print('===== CHECKING MEAN OF Xt VARIABLE =====')
print(Xt.mean(0))
print('')

# Creating unit test to test if the transformer is working as it should be
from numpy.testing import assert_array_equal


def test_meandiscrete():
    X_test = np.array([[0, 2],
                      [3, 5],
                      [6, 8],
                      [9, 11],
                      [12, 14],
                      [15, 17],
                      [18, 20],
                      [21, 23],
                      [24, 26],
                      [27, 29]])
    # Create an instance of the Transformer
    mean_discrete = MeanDiscrete()
    mean_discrete.fit(X_test)
    # Check that the computed mean is correct
    assert_array_equal(mean_discrete.mean, np.array([13.5, 15.5]))    # Mean of the two features of Xt variable
    # Also test that transform works properly
    X_transformed = mean_discrete.transform(X_test)
    X_expected = np.array([[0, 0],
                          [0, 0],
                          [0, 0],
                          [0, 0],
                          [0, 0],
                          [1, 1],
                          [1, 1],
                          [1, 1],
                          [1, 1],
                          [1, 1]])
    assert_array_equal(X_transformed, X_expected)

    
# Testing the transformer
test_meandiscrete()

# Putting the transformer into action
from sklearn.pipeline import Pipeline
pipeline = Pipeline([('mean_discrete', MeanDiscrete()), ('classifier', DecisionTreeClassifier(random_state=14))])
scores_mean_discrete = cross_val_score(pipeline, X, y, scoring='accuracy')
print('===== CHECKING MEAN DISCRETE PERFORMANCE =====')
print(f'Mean Discrete performance: {scores_mean_discrete.mean():.3f}')
print('')


