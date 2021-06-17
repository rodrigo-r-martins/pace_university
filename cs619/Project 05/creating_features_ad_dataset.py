"""
In this program it will be created new features from the features we already have using Internet Advertisements dataset
Creating new features may seen unnucessary and to have no clear benefit but some algorithms struggle when features correlate significantly, or if there are redundant features.
For this reason it will be created new features.
"""

import os
import numpy as np
import pandas as pd
data_folder = os.path.join(os.path.expanduser('~'), 'OneDrive\Desktop\Pace\CS619\Chapter05\Data')
data_filename = os.path.join(data_folder, 'ad.data')

# Reading dataset and checking it
ads = pd.read_csv(data_filename, header=None)
print('===== CHECKING DATASET =====')
print(ads.head(10))
print('')


def convert_number(x):
    # Defining a function that converts number to a float and if that fails, it returns NumPy's special NaN value
    try:
        return float(x)
    except ValueError:
        return np.nan


# Creating a dictionary for the conversion
converters = {}
for i in range(1558):    # 1558 is the last column
    converters[i] = convert_number

# Setting column 1558, the class, to a binary feature
converters[1558] = lambda x: 1 if x.strip() == 'ad.' else 0

# Reloading dataset with those changes
ads = pd.read_csv(data_filename, header=None, converters=converters)
print('===== CHECKING DATASET WITH THOSE CHANGES =====')
print(ads.head(10))
print('')

# Extracting the x and y data for the classification algorithm, and dropping any row with NaN value
# The x matrix will be all of the columns except the last which will be the y array
ads.dropna(inplace=True)
X = ads.drop(1558, axis=1).values
y = ads[1558]

# Using Principal Component Analysis (PCA) algorithm to find combinations of features that describe dataset in less information
from sklearn.decomposition import PCA
pca = PCA(n_components=5)
Xd = pca.fit_transform(X)
print('===== CHECKING DATASET AFTER PCA TRANSFORMATION =====')
print(Xd)    # This result in a matrix with just five features
print('')

# Let's look at the amount of variance that is explained by each of these features
np.set_printoptions(precision=3, suppress=True)
print('===== GETTING VARIANCE RATIO OF DATASET =====')
print(pca.explained_variance_ratio_)
print('')

# Using PCA to improve the performance in classification tasks
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_val_score
clf = DecisionTreeClassifier(random_state=14)
scores_reduced = cross_val_score(clf, Xd, y, scoring='accuracy')
print('===== GETTING PCA SCORE =====')
print(f'PCA score: {scores_reduced.mean():.4f}')
print('')

# Plotting dataset to show the result of PCA transformation
from matplotlib import pyplot as plt

classes = set(y)    # Get all of distinct classes (there are only two: true (is ad) or false (not ad))
colors = ['red', 'green']    # Assign colors to each class

for cur_class, color in zip(classes, colors):
    # Iterate over both lists (classes and colors)
    mask = (y == cur_class)
    plt.scatter(Xd[mask,0], Xd[mask,1], marker='o', color=color, label=int(cur_class))

plt.legend()
plt.show()

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

# Putting the transformer into action
from sklearn.pipeline import Pipeline
pipeline = Pipeline([('mean_discrete', MeanDiscrete()), ('classifier', DecisionTreeClassifier(random_state=14))])
scores_mean_discrete = cross_val_score(pipeline, X, y, scoring='accuracy')
print('===== CHECKING MEAN DISCRETE PERFORMANCE =====')
print(f'Mean Discrete performance: {scores_mean_discrete.mean():.3f}')
print('')