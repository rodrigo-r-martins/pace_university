"""
The data set we are going to use for this example is the famous Iris database of plant classification.
In this dataset, we have 150 plant samples and four measurements of each:
1) Sepal length
2) Sepal width
3) Petal length
4) Petal width

There are 3 classes:
1) Iris Setosa
2) Iris Versicolour
3) Iris Virginica

The aim is to determine which type of plant sample is by examining its measurements.
"""
import numpy as np
from sklearn.datasets import load_iris

dataset = load_iris()                   # Loading dataset
x = dataset.data
y = dataset.target
print(dataset.DESCR)                    # Printing dataset description
print('')
n_samples, n_features = x.shape         # (150, 4)

print('===== UNDERSTANDING THE DATASET =====')
print(dataset)                          # Understanding the dataset
print('')

attribute_means = x.mean(axis=0)
assert attribute_means.shape == (n_features,)
x_d = np.array(x >= attribute_means, dtype='int')

# Necessary imports that we will use to create a function that computes class prediction and error for specific feature value
from collections import defaultdict
from operator import itemgetter


def train_feature_value(x, y_true, feature, value):
    # Create a simple dictionary to count how frequency they give certain predictions
    class_counts = defaultdict(int)

    # Iterate through each sample and count the frequency of each class/value pair
    for sample, y in zip(x, y_true):
        if sample[feature] == value:
            class_counts[y] += 1

    # Now get the best one by sorting (highest first) and choosing the first item
    sorted_class_counts = sorted(class_counts.items(), key=itemgetter(1), reverse=True)
    most_frequent_class = sorted_class_counts[0][0]

    # The error is the number of samples that do not classify as the most frequent class and have the feature value
    n_samples = x.shape[1]
    error = sum([class_count for class_value, class_count in class_counts.items()
                 if class_value != most_frequent_class])
    return most_frequent_class, error


def train(x, y_true, feature):
    # Check that variable is a valid number
    n_samples, n_features = x.shape
    assert 0 <= feature < n_features

    # Get all of the unique values that this variable has
    values = set(x[:, feature])

    # Stores the predictors array that is returned
    predictors = dict()
    errors = []
    for current_value in values:
        most_frequent_class, error = train_feature_value(x, y_true, feature, current_value)
        predictors[current_value] = most_frequent_class
        errors.append(error)

    # Compute the total error of using this feature to classify on
    total_error = sum(errors)
    return predictors, total_error


# Splitting dataset into small datasets: training and testing
from sklearn.model_selection import train_test_split

# Creating datasets for training and testing
print('===== CHECKING TRAINING AND TESTING DATASETS =====')
xd_train, xd_test, y_train, y_test = train_test_split(x_d, y, random_state=14)
print(f'There are {y_train.shape} training sets')
print(f'There are {y_test.shape} testing sets')
print('')

# Computing the predictors for all the features for out dataset
all_predictors = {}
errors = {}
for feature_index in range(xd_train.shape[1]):
    predictors, total_error = train(xd_train, y_train, feature_index)
    all_predictors[feature_index] = predictors
    errors[feature_index] = total_error

# Next, we find the best feature to use our One Rule by finding the feature with the lowest error
best_feature, best_error = sorted(errors.items(), key=itemgetter(1))[0]

# Creating our model by storing the predictors for the best feature
print('===== CHECKING MODEL =====')
model = {'feature': best_feature, 'predictor': all_predictors[best_feature]}
print(model)
print('')


# Defining a function that can predict several new samples at one time
def predict(x_test, model):
    variable = model['feature']
    predictor = model['predictor']
    y_predicted = np.array([predictor[int(sample[variable])]
                            for sample in x_test])
    return y_predicted


# Getting predictions of testing dataset
print('===== GETTING PREDICTIONS OF TESTING DATASET =====')
y_predicted = predict(xd_test, model)
print(y_predicted)
print('')

# Computing accuracy of this testing dataset by comparing it to the known classes
print('===== GETTING ACCURACY OF THE TESTING DATASET =====')
accuracy = np.mean(y_predicted == y_test) * 100
print(f'The test accuracy is {accuracy:.1f}%')
